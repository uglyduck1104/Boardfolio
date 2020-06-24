package com.uglyduck.webapp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uglyduck.command.main.MainCommand;
import com.uglyduck.command.main.MainListCommand;

@Controller
public class HomeController {
	
	@Autowired
	SqlSession sqlSession;
	MainCommand mainCommand;
	
	@RequestMapping("/")
	public String main(Model model) {
		mainCommand = new MainListCommand();
		mainCommand.execute(sqlSession, model);
		return "main";
	}
	
}
