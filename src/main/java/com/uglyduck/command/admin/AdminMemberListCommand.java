package com.uglyduck.command.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

public class AdminMemberListCommand implements AdminCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		List<MemberDto> list = mDao.memberList();
		model.addAttribute("list", list);
		model.addAttribute("listSize", list.size());

	}

}
