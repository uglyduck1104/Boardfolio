package com.uglyduck.webapp.dao;

import java.util.List;

import com.uglyduck.webapp.dto.BoardDto;

public interface BoardDao {

	// 게시물 전체 목록 조회
	public List<BoardDto> getBoardList();
	// 게시물 추가
	public int boardWrite(BoardDto bDto);
	// 게시물 보기
	public BoardDto boardView(int boardNo);
	// 게시물 수정
	public int boardUpdate(String title, String contents, int boardNo);
	// 게시물 삭제
	public int boardDrop(int boardNo);
	// 게시물 조회수 증가
	public int boardHits(BoardDto bDto);
	
}
