package com.kh.finalPro.qna.model.vo;

import java.sql.Date;

public class Qna implements java.io.Serializable{
	private static final long serialVersionUID =13L;
	
	private int q_no;
	private String q_title;
	private String q_writer;
	private String q_content;
	private String q_readcount;
	private Date q_date;
	
	public Qna() {}

	public int getQ_no() {
		return q_no;
	}

	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_writer() {
		return q_writer;
	}

	public void setQ_writer(String q_write) {
		this.q_writer = q_write;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_readcount() {
		return q_readcount;
	}

	public void setQ_readcount(String q_readcount) {
		this.q_readcount = q_readcount;
	}

	public Date getQ_date() {
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Qna(int q_no, String q_title, String q_writer, String q_content, String q_readcount, Date q_date) {
		super();
		this.q_no = q_no;
		this.q_title = q_title;
		this.q_writer = q_writer;
		this.q_content = q_content;
		this.q_readcount = q_readcount;
		this.q_date = q_date;
	}

	@Override
	public String toString() {
		return "Qna [q_no=" + q_no + ", q_title=" + q_title + ", q_writer=" + q_writer + ", q_content=" + q_content
				+ ", q_readcount=" + q_readcount + ", q_date=" + q_date + "]";
	}
	
	

}
