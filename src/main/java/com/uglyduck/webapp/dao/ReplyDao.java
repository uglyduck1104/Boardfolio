package com.uglyduck.webapp.dao;

import java.util.List;

import com.uglyduck.webapp.dto.ReplyDto;
/**
 * 
 * @author UglyDuck
 * getReplyList: 특정 게시물의 댓글 목록
 * getReplyListSize: 모든 게시물의 댓글 총 개수
 * getReplyTotalCount: 특정 게시물의 댓글 총 개수
 * replyWrite: 댓글 작성
 * replyUpdate: 댓글 수정
 * replyDrop: 댓글 삭제
 * memberReplyList: 특정 회원이 작성한 댓글 목록
 * memberReplyListSize: 특정 회원이 작성한 댓글 총 개수
 *
 */
public interface ReplyDao {

	public List<ReplyDto> getReplyList(int boardNo);
	public int getReplyListSize();
	public int getReplyTotalCount(int boardNo);
	public int replyWrite(ReplyDto rDto);
	public int replyUpdate(int replyNo, String replyCon);
	public int replyDrop(int replyNo);
	public List<ReplyDto> memberReplyList(String id, int begin, int end);
	public int memberReplyListSize(String id);
}
