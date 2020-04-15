package com.uglyduck.webapp.dto;

import java.sql.Date;

public class BoardDto {

	//Fields
	private String member_id, title, contents, board_ip;
	private int board_no, hits_cnt, good_cnt, reply_cnt;
	private Date board_dt;
	
	// Constructor
	public BoardDto() { }
	public BoardDto(String member_id, String title, String contents, String board_ip, int board_no, int hits_cnt,
			int good_cnt, int reply_cnt, Date board_dt) {
		this.member_id = member_id;
		this.title = title;
		this.contents = contents;
		this.board_ip = board_ip;
		this.board_no = board_no;
		this.hits_cnt = hits_cnt;
		this.good_cnt = good_cnt;
		this.reply_cnt = reply_cnt;
		this.board_dt = board_dt;
	}
	
	// getters/setters
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBoard_ip() {
		return board_ip;
	}
	public void setBoard_ip(String board_ip) {
		this.board_ip = board_ip;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getHits_cnt() {
		return hits_cnt;
	}
	public void setHits_cnt(int hits_cnt) {
		this.hits_cnt = hits_cnt;
	}
	public int getGood_cnt() {
		return good_cnt;
	}
	public void setGood_cnt(int good_cnt) {
		this.good_cnt = good_cnt;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	public Date getBoard_dt() {
		return board_dt;
	}
	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}
	
}
