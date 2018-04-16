package com.kh.finalPro.food.model.vo;

import java.sql.Date;

public class Foodreply implements java.io.Serializable {
	private static final long serialVersionUID =18L;
	
	private int fo_no;
	private int fo_ref_no;
	private String fo_writer;
	private String fo_content;
	private Date fo_date;
	
	public Foodreply() {}

	public int getFo_no() {
		return fo_no;
	}

	public void setFo_no(int fo_no) {
		this.fo_no = fo_no;
	}

	public int getFo_ref_no() {
		return fo_ref_no;
	}

	public void setFo_ref_no(int fo_ref_no) {
		this.fo_ref_no = fo_ref_no;
	}

	public String getFo_writer() {
		return fo_writer;
	}

	public void setFo_writer(String fo_writer) {
		this.fo_writer = fo_writer;
	}

	public String getFo_content() {
		return fo_content;
	}

	public void setFo_content(String fo_content) {
		this.fo_content = fo_content;
	}

	public Date getFo_date() {
		return fo_date;
	}

	public void setFo_date(Date fo_date) {
		this.fo_date = fo_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Foodreply(int fo_no, int fo_ref_no, String fo_writer, String fo_content, Date fo_date) {
		super();
		this.fo_no = fo_no;
		this.fo_ref_no = fo_ref_no;
		this.fo_writer = fo_writer;
		this.fo_content = fo_content;
		this.fo_date = fo_date;
	}

	@Override
	public String toString() {
		return "Foodreply [fo_no=" + fo_no + ", fo_ref_no=" + fo_ref_no + ", fo_writer=" + fo_writer + ", fo_content="
				+ fo_content + ", fo_date=" + fo_date + "]";
	}
	
	

}
