package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.MemberDao;

public class MemberDropCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		RedirectAttributes rtts = (RedirectAttributes) map.get("rtts");
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		session.invalidate();
		rtts.addFlashAttribute("isMemberDropRes", mDao.dropMember(id));
		rtts.addFlashAttribute("isMemberDrop", "YES");
		

	}

}
