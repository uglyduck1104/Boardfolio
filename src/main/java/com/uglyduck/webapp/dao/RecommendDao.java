package com.uglyduck.webapp.dao;

import com.uglyduck.webapp.dto.RecommendDto;

/** 
 * 
 * @author UglyDuck
 * getRecommend: 특정 회원의 게시물의 추천, 비추천 데이터 조회
 * getRecommendSize: 모든 게시물의 총 추천 개수
 * setRecommed: 특정 게시물의 추천, 비추천 데이터 저장
 * updateRecommend: 특정 회원 및 게시물의 추천, 비추천 데이터 변경
 * resetRecommend: 특정 회원 및 게시물의 추천, 비추천 데이터 삭제(초기화)
 * memberRecommendListSize: 특정 회원의 모든 게시물 총 추천 개수
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
