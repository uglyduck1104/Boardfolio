package com.uglyduck.webapp.dao;

import java.util.List;

import com.uglyduck.webapp.dto.BoardDto;
/**
 * 
 * @author Uglyduck
 * getBoardList: 게시물 전체 목록 조회
 * getBoardListSize: 게시물 개수 조회
 * boardWrite: 게시물 추가
 * boardView: 게시물 상세 보기
 * boardUpdate: 게시물 수정
 * boardDrop: 게시물 삭제
 * boardHits: 게시물 조회수 증가
 * setBoardGoodRec: 게시물 추천수 증가
 * setBoardBadRec: 게시물 추천수 감소
 *
 */
public interface BoardDao {

	public List<BoardDto> getBoardList(int begin, int end);
	public int getBoardListSize();
	public int boardWrite(BoardDto bDto);
	public BoardDto boardView(int boardNo);
	public int boardUpdate(String title, String contents, int boardNo);
	public int boardDrop(int boardNo);
	public int boardHits(BoardDto bDto);
	public int countHits(BoardDto bDto);
	public int setBoardGoodRec(int boardNo);
	public int setBoardBadRec(int boardNo);
	
}
