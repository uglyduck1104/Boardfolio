package com.uglyduck.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
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
		MemberDto mDto = null;
		String aId = null;
		String mId = null;
		if (session.getAttribute("mDto") != null) {
			mDto = (MemberDto)session.getAttribute("mDto");
			mId = mDto.getId();
		}
		int rSize = rDao.getReplyTotalCount();
		JSONObject jsonObj = new JSONObject();
		JSONArray jArray = new JSONArray();
		for( int i = 0; i < rList.size(); i++ ) {
			JSONObject obj = new JSONObject();
			obj.put("member_id", rList.get(i).getMember_id());
			obj.put("reply_con", rList.get(i).getReply_con());
			obj.put("reply_dt", rList.get(i).getReply_dt().toString().replaceAll("-", ""));
			aId = rList.get(i).getMember_id();
			if( mDto != null ) {
				if( !mId.equals(aId) ) {
					obj.put("isYourId", false);
				} else {
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
		logger.info("ReplyDto: " + rDto.toString());
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
}
