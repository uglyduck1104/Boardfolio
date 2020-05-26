package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

public class MemberJoinCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		RedirectAttributes rtts = (RedirectAttributes)map.get("rtts");
		MemberDto memberDto = (MemberDto)map.get("memberDto");
		String hashPwd = BCrypt.hashpw(memberDto.getPw(), BCrypt.gensalt());
		memberDto.setIp(request.getRemoteAddr());
		memberDto.setPw(hashPwd);
		int result = mDao.addMember(memberDto);
		rtts.addFlashAttribute("isJoin", "YES");
		rtts.addFlashAttribute("isJoinRes", result);
		
	}

}
