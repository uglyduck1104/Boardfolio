package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.MemberDao;

public class MemberNewPasswordCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		RedirectAttributes rtts = (RedirectAttributes) map.get("rtts");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String uuid = request.getParameter("uuid");
		String pw = request.getParameter("newPw");
		String hashPw = BCrypt.hashpw(pw, BCrypt.gensalt());
		rtts.addFlashAttribute("isPwUpdate", "YES");
		rtts.addFlashAttribute("isPwUpdateRes", mDao.newPassword(hashPw, id, uuid));

	}

}
