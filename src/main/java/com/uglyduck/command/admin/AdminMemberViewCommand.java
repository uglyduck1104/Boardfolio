package com.uglyduck.command.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

public class AdminMemberViewCommand implements AdminCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		MemberDto mDto = mDao.idCheck(id);
		model.addAttribute("mDto", mDto);
	}

}
