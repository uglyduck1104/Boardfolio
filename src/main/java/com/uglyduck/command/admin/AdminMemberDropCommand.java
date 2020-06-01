package com.uglyduck.command.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.MemberDao;

public class AdminMemberDropCommand implements AdminCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		RedirectAttributes rtts = (RedirectAttributes) map.get("rtts");
		String id = request.getParameter("id");
		rtts.addFlashAttribute("isAdminMemberDrop", "YES");
		rtts.addFlashAttribute("isAdminMemberDropRes", mDao.dropMember(id));
		

	}

}
