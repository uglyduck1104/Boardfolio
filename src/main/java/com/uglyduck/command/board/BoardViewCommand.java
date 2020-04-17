package com.uglyduck.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;

public class BoardViewCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		model.addAttribute("bDto", bDao.boardView(Integer.parseInt(request.getParameter("board_no")))); 
	}

}

