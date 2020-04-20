package com.uglyduck.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.BoardDao;

public class BoardDeleteCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		RedirectAttributes rtts = (RedirectAttributes)map.get("rtts");
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		rtts.addFlashAttribute("isBoardDeleteRes", bDao.boardDrop(boardNo));
		rtts.addFlashAttribute("isBoardDelete", "YES");
	}

}
