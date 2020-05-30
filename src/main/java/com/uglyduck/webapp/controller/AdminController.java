package com.uglyduck.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uglyduck.command.admin.AdminCommand;
import com.uglyduck.command.admin.AdminMemberListCommand;
import com.uglyduck.command.admin.AdminMemberViewCommand;

@Controller
public class AdminController {

	@Autowired
	SqlSession sqlSession;
	AdminCommand adminCommand;
	
	@RequestMapping("admin-member-list")
	public String adminMemberList(Model model) {
		adminCommand = new AdminMemberListCommand();
		adminCommand.execute(sqlSession, model);
		return "admin/adminMemberList";
	}
	
	@RequestMapping("admin-member-view")
	public String adminMemberView(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		adminCommand = new AdminMemberViewCommand();
		adminCommand.execute(sqlSession, model);
		return "admin/adminMemberView";
	}
	
	
}
