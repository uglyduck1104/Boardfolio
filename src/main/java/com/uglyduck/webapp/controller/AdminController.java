package com.uglyduck.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.command.admin.AdminCommand;
import com.uglyduck.command.admin.AdminMemberDropCommand;
import com.uglyduck.command.admin.AdminMemberListCommand;
import com.uglyduck.command.admin.AdminMemberViewCommand;

@Controller
public class AdminController {

	@Autowired
	SqlSession sqlSession;
	AdminCommand adminCommand;
	
	@RequestMapping("admin-member-list")
	public String adminMemberList(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
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
	
	@RequestMapping("admin-member-drop")
	public String adminMemberDrop(Model model, RedirectAttributes rtts, HttpServletRequest request) {
		model.addAttribute("request", request);
		model.addAttribute("rtts", rtts);
		adminCommand = new AdminMemberDropCommand();
		adminCommand.execute(sqlSession, model);
		return "redirect:admin-member-list";
		
	}
	
	
}
