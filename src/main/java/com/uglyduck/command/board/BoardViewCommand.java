package com.uglyduck.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

public class BoardViewCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BoardDto bDto = bDao.boardView(Integer.parseInt(request.getParameter("board_no")));
		HttpSession session = request.getSession();
		Object isOpen = session.getAttribute("isOpen"); // 게시물을 열었는지 확인 
		if( isOpen == null ) { // 최초 게시물을 열었다면
			session.setAttribute("isOpen", "YES");
			int hit = bDto.getHits_cnt();
			bDto.setHits_cnt(hit + 1);
			bDao.boardHits(bDto);
		}
		model.addAttribute("bDto", bDto); 
	}

}

