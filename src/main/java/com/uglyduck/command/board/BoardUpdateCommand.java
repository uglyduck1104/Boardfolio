package com.uglyduck.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.BoardDao;

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		RedirectAttributes rtts = (RedirectAttributes)map.get("rtts");
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		rtts.addFlashAttribute("isBoardUpdateRes", bDao.boardUpdate(title, contents, boardNo));
		rtts.addFlashAttribute("isBoardUpdate", "YES");
		
	}

}
