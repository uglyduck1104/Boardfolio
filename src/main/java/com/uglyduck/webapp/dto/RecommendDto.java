package com.uglyduck.webapp.dto;

public class RecommendDto {
	
	// Field
	int rec_no, board_no;
	String member_id, rec_vote;
	
	// Constructor
	public RecommendDto() { }
	public RecommendDto(int rec_no, int board_no, String member_id, String rec_vote) {
		this.rec_no = rec_no;
		this.board_no = board_no;
		this.member_id = member_id;
		this.rec_vote = rec_vote;
	}
	
	// getters/setters
	public int getRec_no() {
		return rec_no;
	}
	public void setRec_no(int rec_no) {
		this.rec_no = rec_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getRec_vote() {
		return rec_vote;
	}
	public void setRec_vote(String rec_vote) {
		this.rec_vote = rec_vote;
	}


	
}
