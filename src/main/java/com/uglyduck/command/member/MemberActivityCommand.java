package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dao.RecommendDao;
import com.uglyduck.webapp.dao.ReplyDao;

public class MemberActivityCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String id = request.getParameter("id");
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		RecommendDao reDao = sqlSession.getMapper(RecommendDao.class);
		model.addAttribute("boardCount", bDao.memberBoardListSize(id));
		model.addAttribute("replyCount", rDao.memberReplyListSize(id));
		model.addAttribute("recommendCount", reDao.memberRecommendListSize(id));

	}

}
