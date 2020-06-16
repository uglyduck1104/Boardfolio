package com.uglyduck.webapp.dao;

import com.uglyduck.webapp.dto.RecommendDto;

/** 
 * 
 * @author UglyDuck
 * getRecommend: 기존의 추천, 비추천 데이터 조회
 * getRecommendSize: 총 추천 수
 * setRecommed: 게시물 번호, 회원 아이디를 기준으로 한 추천, 비추천 데이터 저장
 * updateRecommend: 추천, 비추천 데이터 변경
 * resetRecommend: 추천, 비추천 데이터 삭제(초기화)
 * memberRecommendListSize: 회원 추천 게시글 조회
 *
 */
public interface RecommendDao {

	public RecommendDto getRecommend(String memberId, int boardNo);
	public int getRecommendSize();
	public int setRecommend(String memberId, int boardNo, String recVote);
	public int updateRecommend(String memberId, int boardNo, String recVote);
	public int resetRecommend(String memberId, int boardNo);
	public int memberRecommendListSize(String id);
	
}
