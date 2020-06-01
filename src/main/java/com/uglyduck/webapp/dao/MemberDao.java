package com.uglyduck.webapp.dao;


import java.util.List;

import com.uglyduck.webapp.dto.MemberDto;

public interface MemberDao {
	
	public int addMember(MemberDto mDto);
	public MemberDto idCheck(String id);
	public int modifyMember(MemberDto mDto);
	public int updateLog(String ip, String id);
	public int pwUpdate(String pw, String id);
	public int dropMember(String id);
	public MemberDto emailConfirm(MemberDto	mDto);
	public int uuidUpdate(String uuid, String id);
	public int newPassword(String pw, String id, String uuid);
	public List<MemberDto> memberList(String sort, int begin, int end);
	public int memberListSize(String sort);
	public List<MemberDto> search(String sort, String query, int begin, int end);
	public int searchListSize(String query);
	public int memberCountBoard(String id);
	public int memberCountReply(String id);
}
