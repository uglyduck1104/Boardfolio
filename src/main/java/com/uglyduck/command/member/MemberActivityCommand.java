package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dao.RecommendDao;
import com.uglyduck.webapp.dao.ReplyDao;
import com.uglyduck.webapp.dto.MemberDto;

public class MemberActivityCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class);
		RecommendDao reDao = sqlSession.getMapper(RecommendDao.class);
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		MemberDto mDto = (MemberDto)session.getAttribute("mDto");
		String id = mDto.getId();
		String role = mDto.getRole();
		if( role.equals("user") ) {
			model.addAttribute("boardCount", bDao.memberBoardListSize(id));
			model.addAttribute("replyCount", rDao.memberReplyListSize(id));
			model.addAttribute("recommendCount", reDao.memberRecommendListSize(id));
		} else {
			model.addAttribute("memberCount", mDao.memberListSize("user"));
			model.addAttribute("withdrawCount", mDao.memberListSize("withdraw"));
			model.addAttribute("boardCount", bDao.getBoardListSize());
			model.addAttribute("replyCount", rDao.getReplyListSize());
			model.addAttribute("recommendCount", reDao.getRecommendSize());
		}

		
		
	}

}
