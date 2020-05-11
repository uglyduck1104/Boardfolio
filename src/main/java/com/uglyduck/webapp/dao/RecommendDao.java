package com.uglyduck.webapp.dao;

import com.uglyduck.webapp.dto.RecommendDto;

/** 
 * 
 * @author UglyDuck
 * setRecommed: 게시물 번호, 회원 아이디를 기준으로 한 추천, 비추천 데이터 저장
 *
 */
public interface RecommendDao {

	public RecommendDto getRecommend(String memberId, int boardNo);
	public int setRecommend(String memberId, int boardNo, String recVote);
	public int updateRecommend(String memberId, int boardNo, String recVote);
	
}
