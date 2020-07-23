package com.uglyduck.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uglyduck.command.reply.ReplyCommand;
import com.uglyduck.webapp.dao.ReplyDao;
import com.uglyduck.webapp.dto.MemberDto;
import com.uglyduck.webapp.dto.ReplyDto;

@Controller
public class ReplyController {
	
	// Field
	@Autowired
	SqlSession sqlSession;
	ReplyCommand replyCommand;
	
	// Methods
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "reply-list", produces="application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String getReplyList(@RequestParam int boardNo, HttpServletRequest request) {
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		
		HttpSession session = request.getSession();
		List<ReplyDto> rList = rDao.getReplyList(boardNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd a h:mm:ss");
		MemberDto mDto = null;
		String aId = null;
		if (session.getAttribute("mDto") != null) {
			mDto = (MemberDto)session.getAttribute("mDto");
		}
		int rSize = rDao.getReplyTotalCount(boardNo);
		JSONObject jsonObj = new JSONObject();
		JSONArray jArray = new JSONArray();
		for( int i = 0; i < rList.size(); i++ ) {
			JSONObject obj = new JSONObject();
			obj.put("reply_no", rList.get(i).getReply_no());
			obj.put("member_id", rList.get(i).getMember_id());
			obj.put("reply_con", rList.get(i).getReply_con());
			obj.put("reply_dt", sdf.format(rList.get(i).getReply_dt()));
			aId = rList.get(i).getMember_id();
			if( mDto != null ) {
				if( mDto.getRole().equals("admin") ) {
					obj.put("isAdmin", true);
				}
				if( mDto.getId().equals(aId) ) {
					obj.put("isYourId", true);
				} 
			} else {
				obj.put("isYourId", null);
			}
			jArray.add(obj);
		}
		jsonObj.put("data", jArray);
		jsonObj.put("dataSize", rSize);
		return jsonObj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "reply-write", produces="application/json; charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String replyWrite(ReplyDto rDto) {
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		int result = rDao.replyWrite(rDto);
		JSONObject obj = new JSONObject();
		if( result > 0) {
			obj.put("isReplyWrite", "YES");
		} else {
			obj.put("isReplyWrite", "NO");
		}
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "reply-update", produces="application/json; charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String replyUpdate(@RequestParam int replyNo, @RequestParam String replyCon) {
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		int result = rDao.replyUpdate(replyNo, replyCon);
		JSONObject obj = new JSONObject();
		if( result > 0) {
			obj.put("isReplyUpdate", "YES");
		} else {
			obj.put("isReplyUpdate", "NO");
		}
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "reply-drop", produces="application/json; charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String replyDrop(@RequestParam int replyNo) {
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		int result = rDao.replyDrop(replyNo);
		JSONObject obj = new JSONObject();
		if( result > 0) {
			obj.put("isReplyDelete", "YES");
		} else {
			obj.put("isReplyDelete", "NO");
		}
		return obj.toJSONString();
	}
	
	@RequestMapping("member-reply-list")
	public String memberReplyList(Model model, HttpServletRequest request) {
		return "user/memberReplyList";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="reply-ajax-list", produces="application/json; charset=UTF-8", method=RequestMethod.GET)
	@ResponseBody
	public String replyAjaxList(HttpServletRequest request) {
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd a h:mm:ss");
		String id = request.getParameter("id");
		String currentPage = request.getParameter("currentPage");
		int nowPage = 1;
		if( currentPage != null && currentPage.length() != 0 ) {
			nowPage = Integer.parseInt(currentPage);
		}
		int recordPerPage = 8;
		int begin = (nowPage - 1) * recordPerPage + 1; 
		int end = begin + recordPerPage - 1;
		List<ReplyDto> list = rDao.memberReplyList(id, begin, end);
		JSONObject jObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		for( int i = 0; i < list.size(); i++ ) {
			JSONObject obj = new JSONObject();
			obj.put("board_no", list.get(i).getBoard_no());
			obj.put("reply_con", list.get(i).getReply_con());
			obj.put("member_id", list.get(i).getMember_id());
			obj.put("reply_dt", sdf.format(list.get(i).getReply_dt()));
			jArray.add(obj);
		}
		jObject.put("data", jArray);
		jObject.put("dataSize", list.size());
		
		return jObject.toJSONString();
	}
	

	
}
