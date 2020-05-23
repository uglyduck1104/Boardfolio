package com.uglyduck.command.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

public class MemberWriteListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		BoardDao bDao = sqlSession.getMapper(BoardDao.class); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		List<BoardDto> list = bDao.memberWriteList(id);
		model.addAttribute("list", list);
	}

}
