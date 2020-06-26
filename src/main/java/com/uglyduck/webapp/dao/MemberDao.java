package com.uglyduck.webapp.dao;

import java.util.List;
import com.uglyduck.webapp.dto.MemberDto;
/**
 * 
 * @author UglyDuck
 * addMember: 회원 추가
 * idCheck: 아이디 중복 여부 확인
 * modifyMember: 회원 수정
 * updateLog: 회원 관련 로그 기록
 * pwUpdate: 비밀번호 수정
 * dropMember: 회원 탈퇴
 * emailConfirm: 회원 이메일 주소 검증
 * uuidUpdate: 고유 번호 등록
 * newPassword: 새로운 비밀번호 수정(계정 찾기)
 * memberList: 회원 목록 조회
 * memberListSize: 회원 목록의 개수
 * search: 특정 회원 검색
 * searchListSize: 특정 회원 검색 결과의 개수 
 * memberCountBoard: 특정 회원이 작성한 게시물의 총 개수
 * memberCountReply: 특정 회원이 작성한 댓글의 총 개수
 *
 */
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
