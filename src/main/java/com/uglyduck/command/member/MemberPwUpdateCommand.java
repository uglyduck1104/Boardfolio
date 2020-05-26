package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.MemberDao;

public class MemberPwUpdateCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		RedirectAttributes rtts = (RedirectAttributes)map.get("rtts");
		HttpSession session = request.getSession();
		String newPw = request.getParameter("newPw");
		String id = request.getParameter("id");
		String pw = BCrypt.hashpw(newPw, BCrypt.gensalt());
		session.invalidate();
		rtts.addFlashAttribute("isPwUpdateRes", mDao.pwUpdate(pw, id));
		rtts.addFlashAttribute("isPwUpdate", "YES");
		

	}

}
