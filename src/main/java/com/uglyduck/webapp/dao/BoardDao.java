package com.uglyduck.webapp.dao;

import java.util.List;

import com.uglyduck.webapp.dto.BoardDto;
/**
 * 
 * @author Uglyduck
 * getBoardList: 게시물 전체 목록 조회
 * getBoardListSize: 게시물 전체 개수 조회
 * boardWrite: 게시물 추가
 * boardView: 게시물 상세 보기
 * boardUpdate: 게시물 수정
 * boardDrop: 게시물 삭제
 * boardHits: 게시물 조회수 증가
 * setBoardGoodRec: 게시물 추천수 증가
 * setBoardBadRec: 게시물 추천수 감소
 * search: 게시물 검색어 기준 목록 조회
 * searchListSize: 게시물 검색어 기준 목록 개수 조회 
 * memberWriteList: 내가 쓴 게시물 조회
 * adminBoardList: 관리자용 게시물 조회
 * adminBoardSearch: 관리자용 게시물 검색
 * adminBoardSearchSize: 관리자용 게시물 검색 값
 * memberRecommendList: 내가 추천한 게시물 조회
 * memberBoardListSize: 특정 회원 게시물 개수 조회
 */
public interface BoardDao {

	public List<BoardDto> getBoardList(String sort, int begin, int end);
	public int getBoardListSize();
	public int memberBoardListSize(String id);
	public int boardWrite(BoardDto bDto);
	public BoardDto boardView(int boardNo);
	public int boardUpdate(String title, String contents, int boardNo);
	public int boardDrop(int boardNo);
	public int boardHits(BoardDto bDto);
	public int countHits(BoardDto bDto);
	public int setBoardGoodRec(int boardNo);
	public int setBoardBadRec(int boardNo);
	public List<BoardDto> search(String query, String sort, int begin, int end);
	public int searchListSize(String query);
	public List<BoardDto> memberWriteList(String id, int begin, int end);
	public List<BoardDto> memberRecommendList(String id, int begin, int end);
	public List<BoardDto> adminBoardList(int begin, int end);
	public List<BoardDto> adminBoardSearch(String query, String beginDate, String endDate, int begin, int end);
	public int adminBoardSearchSize(String query, String beginDate, String endDate);
	public List<BoardDto> todayBestList(int begin, int end);
	public List<BoardDto> weekBestList(int begin, int end);
	public List<BoardDto> monthBestList(int begin, int end);
	public List<BoardDto> yearBestList(int begin, int end);
}
