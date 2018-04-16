package com.kh.finalPro.review.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable{
	
	private static final long serialVersionUID = 111L;
	
	private int r_no;
	private int r_day;
	private String r_nation1;
	private String r_nation2;
	private String r_title;
	private String r_writer;
	private String r_content;
	private String r_original_filename;
	private String r_rename_filename;
	private int r_readcount;
	private Date r_date;
	
	public Review() {}

	public Review(int r_no, int r_day, String r_nation1, String r_nation2, String r_title, String r_writer,
			String r_content, String r_original_filename, String r_rename_filename, int r_readcount, Date r_date) {
		super();
		this.r_no = r_no;
		this.r_day = r_day;
		this.r_nation1 = r_nation1;
		this.r_nation2 = r_nation2;
		this.r_title = r_title;
		this.r_writer = r_writer;
		this.r_content = r_content;
		this.r_original_filename = r_original_filename;
		this.r_rename_filename = r_rename_filename;
		this.r_readcount = r_readcount;
		this.r_date = r_date;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getR_day() {
		return r_day;
	}

	public void setR_day(int r_day) {
		this.r_day = r_day;
	}

	public String getR_nation1() {
		return r_nation1;
	}

	public void setR_nation1(String r_nation1) {
		this.r_nation1 = r_nation1;
	}

	public String getR_nation2() {
		return r_nation2;
	}

	public void setR_nation2(String r_nation2) {
		this.r_nation2 = r_nation2;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_writer() {
		return r_writer;
	}

	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_original_filename() {
		return r_original_filename;
	}

	public void setR_original_filename(String r_original_filename) {
		this.r_original_filename = r_original_filename;
	}

	public String getR_rename_filename() {
		return r_rename_filename;
	}

	public void setR_rename_filename(String r_rename_filename) {
		this.r_rename_filename = r_rename_filename;
	}

	public int getR_readcount() {
		return r_readcount;
	}

	public void setR_readcount(int r_readcount) {
		this.r_readcount = r_readcount;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Review [r_no=" + r_no + ", r_day=" + r_day + ", r_nation1=" + r_nation1 + ", r_nation2=" + r_nation2
				+ ", r_title=" + r_title + ", r_writer=" + r_writer + ", r_content=" + r_content
				+ ", r_original_filename=" + r_original_filename + ", r_rename_filename=" + r_rename_filename
				+ ", r_readcount=" + r_readcount + ", r_date=" + r_date + "]";
	}


	
	
}
