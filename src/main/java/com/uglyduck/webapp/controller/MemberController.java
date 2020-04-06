package com.uglyduck.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.member.command.MemberCommand;
import com.uglyduck.member.command.MemberJoinCommand;
import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// Field
	@Autowired
	SqlSession sqlSession;
	MemberCommand memberCommand;
	
	// Simply move page
	@RequestMapping("login-form")
	public String loginForm() {
		
		return "login/loginPage";
	}
	
	@RequestMapping("sign-form")
	public String signForm(Model model) {
		model.addAttribute("memberDto", new MemberDto());
		return "join/signPage";
	}
	
	// Method
	@RequestMapping("login-user")
	public String loginUser() {
		return "";
	}
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "id-check", method = RequestMethod.POST, produces = "application/json")
	public String idCheck(@RequestParam("id") String id) {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		MemberDto mDto = mDao.idCheck(id);
		JSONObject obj = new JSONObject();
		if( mDto != null ) {
			obj.put("isValid", "FALSE");
		} else {
			obj.put("isValid", "TRUE");
		}
		return obj.toJSONString();
	}
	@RequestMapping(value = "sign-user", method = RequestMethod.POST)
	public String signUser(@Valid MemberDto memberDto, BindingResult bdr, RedirectAttributes rtts,
							Model model, HttpServletRequest request) {
		String urlPath = "";
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("request", request);
		model.addAttribute("rtts", rtts);
		// 유효성 검증
		if( bdr.hasErrors() ) {
			urlPath = "join/signPage";
		} else {
			memberCommand = new MemberJoinCommand();
			memberCommand.execute(sqlSession, model);
			urlPath = "redirect:login-form";
		}
		return urlPath;
	}
	
}
