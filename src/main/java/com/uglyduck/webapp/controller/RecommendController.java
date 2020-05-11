package com.uglyduck.webapp.controller;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dao.RecommendDao;
import com.uglyduck.webapp.dto.RecommendDto;

@Controller
public class RecommendController {

	@Autowired
	SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="rec-btn-stat", produces="aplication/json; charset=UTF-8", method=RequestMethod.GET)
	@ResponseBody
	public String getRecommend(@RequestParam String memberId, @RequestParam int boardNo) {
		JSONObject obj = new JSONObject();
		RecommendDao rDao = sqlSession.getMapper(RecommendDao.class);
		RecommendDto rDto = rDao.getRecommend(memberId, boardNo);
		if( rDto != null ) {
			if(rDto.getRec_vote().equals("good")) {
				obj.put("btnStat", "good");
			} else if(rDto.getRec_vote().equals("bad")){
				obj.put("btnStat", "bad");
			}
		} else {
			obj.put("btnStat", "default");
		}
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="count-recs", produces = "aplication/json; charset=UTF-8", method= RequestMethod.POST)
	@ResponseBody
	public String countHits(@RequestParam String memberId, @RequestParam int boardNo, @RequestParam String recVote) {
		
		JSONObject obj = new JSONObject();
		RecommendDao rDao = sqlSession.getMapper(RecommendDao.class);
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		RecommendDto rDto = rDao.getRecommend(memberId, boardNo);
		if( rDto == null ) {								    
			rDao.setRecommend(memberId, boardNo, recVote);  
			if(recVote.equals("good")) {            			
				bDao.setBoardGoodRec(boardNo);
				obj.put("isRecommend", "good");
			} else {										
				bDao.setBoardBadRec(boardNo);
				obj.put("isRecommend", "bad");
			}
		} else {											
			rDao.updateRecommend(memberId, boardNo, recVote);
			if( rDto.getRec_vote().equals(recVote) ) {  		
				if(recVote.equals("good")) {		    
					obj.put("isChecked", "true");
				} else {		
					obj.put("isChecked", "false");
				}
			} else { 										
				if(recVote.equals("good")) {            			
					bDao.setBoardGoodRec(boardNo);
					obj.put("isRecommend", "good");
				} else {										
					bDao.setBoardBadRec(boardNo);
					obj.put("isRecommend", "bad");
				}
			}
		}
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="reset-recs", produces="aplication/json; charset=UTF-8", method=RequestMethod.POST)
	@ResponseBody
	public String resetRecommend(@RequestParam String memberId, @RequestParam int boardNo) {
		JSONObject obj = new JSONObject();
		RecommendDao rDao = sqlSession.getMapper(RecommendDao.class);
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		RecommendDto rDto = rDao.getRecommend(memberId, boardNo);
		if( rDto.getRec_vote().equals("good") ) {
			bDao.setBoardBadRec(boardNo);
		} else {
			bDao.setBoardGoodRec(boardNo);
		}
		int result = rDao.resetRecommend(memberId, boardNo);
		obj.put("result", result);
		
		return obj.toJSONString();
	}

	
}
