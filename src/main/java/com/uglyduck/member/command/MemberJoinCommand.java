package com.uglyduck.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
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
		memberDto.setIp(request.getRemoteAddr());
		int result = mDao.addMember(memberDto);
		if( result > 0 ) {
			rtts.addFlashAttribute("userJoin", "SUCCESS");
		} else {
			rtts.addFlashAttribute("userJoin", "FAIL");
		}
		
		
		
	}

}
