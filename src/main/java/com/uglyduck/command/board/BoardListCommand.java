package com.uglyduck.command.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		Object isOpen = session.getAttribute("isOpen");
		if( isOpen == null ) {
			session.removeAttribute("isOpen");
		}
		List<BoardDto> list = bDao.getBoardList();
		model.addAttribute("list", list);

	}

}
