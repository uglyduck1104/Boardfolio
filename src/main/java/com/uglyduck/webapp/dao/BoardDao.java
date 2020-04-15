package com.uglyduck.webapp.dao;

import java.util.List;

import com.uglyduck.webapp.dto.BoardDto;

public interface BoardDao {

	// 게시물 전체 목록 조회
	public List<BoardDto> getBoardList();
	// 게시물 갯수
	public int getBoardTotalCount();
	// 게시물 추가
	public int writeBoard(BoardDto bDto);
}
