package com.uglyduck.webapp.dao;

import com.uglyduck.webapp.dto.MemberDto;

public interface MemberDao {
	
	public int addMember(MemberDto mDto);
	public MemberDto idCheck(String id);
	public MemberDto idPwCheck(String id, String pw);
}
