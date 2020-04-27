package com.uglyduck.webapp.dto;

import java.sql.Date;

public class ReplyDto {

	// Field
	int reply_no, board_no;
	Date reply_dt;
	String reply_con, member_id;
	
	// Constructor
	public ReplyDto() { }
	public ReplyDto(int reply_no, int board_no, Date reply_dt, String reply_con, String member_id) {
		this.reply_no = reply_no;
		this.board_no = board_no;
		this.reply_dt = reply_dt;
		this.reply_con = reply_con;
		this.member_id = member_id;
	}
	
	// Method
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public Date getReply_dt() {
		return reply_dt;
	}
	public void setReply_dt(Date reply_dt) {
		this.reply_dt = reply_dt;
	}
	public String getReply_con() {
		return reply_con;
	}
	public void setReply_con(String reply_con) {
		this.reply_con = reply_con;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
}
