package com.uglyduck.webapp.dao;


import com.uglyduck.webapp.dto.MemberDto;

public interface MemberDao {
	
	public int addMember(MemberDto mDto);
	public MemberDto idCheck(String id);
	public int modifyMember(MemberDto mDto);
	public int pwUpdate(String pw, String id);
	public int dropMember(String id);
}
