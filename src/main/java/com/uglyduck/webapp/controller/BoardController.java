package com.uglyduck.webapp.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uglyduck.command.board.BoardCommand;
import com.uglyduck.command.board.BoardListCommand;

@Controller
public class BoardController {
	
	@Autowired
	SqlSession sqlSession;
	BoardCommand boardCommand;
	
	@RequestMapping("board-list")
	public String getBoardList(Model model) {
		boardCommand = new BoardListCommand();
		boardCommand.execute(sqlSession, model);
		return "board/boardList";
	}
	
	
	
}
