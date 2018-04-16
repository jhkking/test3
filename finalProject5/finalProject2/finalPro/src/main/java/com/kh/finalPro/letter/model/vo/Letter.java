package com.kh.finalPro.letter.model.vo;

import java.sql.Date;

public class Letter implements java.io.Serializable{
	public static final long serialVersionUID = 122L;
	
	public Letter() {	}
	
	private int b_no;
	private String white_id;
	private String black_id;
	private String b_title;
	private String b_content;
	private Date b_date;
	

	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getWhite_id() {
		return white_id;
	}
	public void setWhite_id(String white_id) {
		this.white_id = white_id;
	}
	public String getBlack_id() {
		return black_id;
	}
	public void setBlack_id(String black_id) {
		this.black_id = black_id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Letter [b_num=" + b_no + ", white_id=" + white_id + ", black_id=" + black_id + ", b_title=" + b_title
				+ ", b_content=" + b_content + ", b_date=" + b_date + "]";
	}
	public Letter(int b_no, String white_id, String black_id, String b_title, String b_content, Date b_date) {
		super();
		this.b_no = b_no;
		this.white_id = white_id;
		this.black_id = black_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = b_date;
	}
}
