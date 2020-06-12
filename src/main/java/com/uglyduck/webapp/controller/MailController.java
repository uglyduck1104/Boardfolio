package com.uglyduck.webapp.controller;

import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

@Controller
public class MailController {
	
	@Autowired
	SqlSession sqlSession;
	@Autowired
	JavaMailSender mailSender;
	
	
	@RequestMapping("confirm-pass")
	public String confirmPass(Model model, HttpServletResponse response) {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		MemberDto memberDto = (MemberDto)map.get("mDto");
		String uuid = UUID.randomUUID().toString();
		mDao.uuidUpdate(uuid, memberDto.getId());
        String setfrom = "Uglyduck9292@gmail.com";         
        String tomail  = memberDto.getEmail();    
        String title   = "[The Ugly Duckling] 비밀번호 변경 링크 안내.";
        StringBuilder contents = new StringBuilder().append("<h1>비밀번호 변경 링크 안내</h1>") 
        		.append("<p>" + memberDto.getName() + "님의 아이디는 " + memberDto.getId() + "입니다.</p>" )
        		.append("<a href='http://localhost:9090/new-password-page?id=")
        		.append(memberDto.getId())
        		.append("&uuid=")
        		.append(uuid)
        		.append("' target='_blank'>비밀번호 변경</a>");
        try {
        	MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);
			messageHelper.setTo(tomail);
			messageHelper.setSubject(title);
			messageHelper.setText(contents.toString(), true);
			mailSender.send(message);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append("<script>")
			  .append("location.href='email-info';")
			  .append("</script>");
			out.println(sb.toString());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login/loginPage";
	}
	
	@RequestMapping("email-info")
	public String emailInfo() {
		return "login/emailInfo";
	}
	

}
