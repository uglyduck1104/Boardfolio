package com.uglyduck.webapp.dao;

import java.util.List;

import com.uglyduck.webapp.dto.ReplyDto;

public interface ReplyDao {

	// 댓글 조회
	public List<ReplyDto> getReplyList(int boardNo);
	public Integer getReplyTotalCount();
	// 댓글 삽입
	public int replyWrite(ReplyDto rDto);
	// 댓글 보기
	// public ReplyDto replyView(int replyNo);
	// 댓글 수정
	public int replyUpdate(String replyCon);
	// 댓글 삭제
	public int replyDrop(int replyNo);
	
	
	
}
