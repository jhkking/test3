package com.kh.finalPro.feedback.model.vo;

import java.sql.Date;

public class Feedback implements java.io.Serializable{
	private static final long serialVersionUID=11L;
	
	private int f_no;
	private int f_day;
	private String f_nation1;
	private String f_nation2;
	private String f_title;
	private String f_writer;
	private String f_content;
	private String f_original_filename;
	private String f_rename_filename;
	private String f_readcount;
	private Date f_date;
	
	
	public Feedback() {}

	
	public String getF_original_filename() {
		return f_original_filename;
	}


	public void setF_original_filename(String f_original_filename) {
		this.f_original_filename = f_original_filename;
	}


	public String getF_rename_filename() {
		return f_rename_filename;
	}


	public void setF_rename_filename(String f_rename_filename) {
		this.f_rename_filename = f_rename_filename;
	}


	public int getF_no() {
		return f_no;
	}


	public void setF_no(int f_no) {
		this.f_no = f_no;
	}


	public int getF_day() {
		return f_day;
	}


	public void setF_day(int f_day) {
		this.f_day = f_day;
	}


	public String getF_nation1() {
		return f_nation1;
	}


	public void setF_nation1(String f_nation1) {
		this.f_nation1 = f_nation1;
	}


	public String getF_nation2() {
		return f_nation2;
	}


	public void setF_nation2(String f_nation2) {
		this.f_nation2 = f_nation2;
	}


	public String getF_title() {
		return f_title;
	}


	public void setF_title(String f_title) {
		this.f_title = f_title;
	}


	public String getF_writer() {
		return f_writer;
	}


	public void setF_writer(String f_writer) {
		this.f_writer = f_writer;
	}


	public String getF_content() {
		return f_content;
	}


	public void setF_content(String f_content) {
		this.f_content = f_content;
	}


	public String getF_readcount() {
		return f_readcount;
	}


	public void setF_readcount(String f_readcount) {
		this.f_readcount = f_readcount;
	}


	public Date getF_date() {
		return f_date;
	}


	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	


	public Feedback(int f_no, int f_day, String f_nation1, String f_nation2, String f_title, String f_writer,
			String f_content, String f_original_filename, String f_rename_filename, String f_readcount, Date f_date) {
		super();
		this.f_no = f_no;
		this.f_day = f_day;
		this.f_nation1 = f_nation1;
		this.f_nation2 = f_nation2;
		this.f_title = f_title;
		this.f_writer = f_writer;
		this.f_content = f_content;
		this.f_original_filename = f_original_filename;
		this.f_rename_filename = f_rename_filename;
		this.f_readcount = f_readcount;
		this.f_date = f_date;
	}


	@Override
	public String toString() {
		return "Feedback [f_no=" + f_no + ", f_day=" + f_day + ", f_nation1=" + f_nation1 + ", f_nation2=" + f_nation2
				+ ", f_title=" + f_title + ", f_writer=" + f_writer + ", f_content=" + f_content
				+ ", f_original_filename=" + f_original_filename + ", f_rename_filename=" + f_rename_filename
				+ ", f_readcount=" + f_readcount + ", f_date=" + f_date + "]";
	}





	

}
