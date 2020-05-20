package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

public class MemberUpdateCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		RedirectAttributes rtts = (RedirectAttributes)map.get("rtts");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		session.invalidate();
		MemberDto memberDto = (MemberDto)map.get("memberDto");
		rtts.addFlashAttribute("isMemberUpdate", "YES");
		rtts.addFlashAttribute("isMemberUpdateRes", mDao.modifyMember(memberDto));

	}

}
