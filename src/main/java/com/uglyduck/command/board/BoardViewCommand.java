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
		String currentPage = request.getParameter("currentPage");
		BoardDto bDto = bDao.boardView(Integer.parseInt(request.getParameter("board_no")));
		HttpSession session = request.getSession();
		Object isOpen = session.getAttribute("isOpen: " + bDto.getBoard_no());  // 게시물 번호 기준 session 호출
		if( isOpen == null ) { // 게시물이 열린적이 없다면
 			session.setAttribute("isOpen: " + bDto.getBoard_no(), "YES");  // 게시물 번호 기준 session 저장
			int hit = bDto.getHits_cnt();		     
			bDto.setHits_cnt(hit + 1);              
			bDao.boardHits(bDto);                      
		}
		model.addAttribute("bDto", bDto); 
		model.addAttribute("currentPage", currentPage);
	}

}

