package com.kh.finalPro.feedback.model.vo;

import java.sql.Date;

public class Feedbackreply implements java.io.Serializable {
	private static final long serialVersionUID =2345L;
	
	private int fr_no;
	private int fr_ref_no;
	private String fr_title;
	private String fr_writer;
	private String fr_content;
	private Date fr_date;
	
	public Feedbackreply() {}
	
	public int getFr_no() {
		return fr_no;
	}
	public void setFr_no(int fr_no) {
		this.fr_no = fr_no;
	}
	public int getFr_ref_no() {
		return fr_ref_no;
	}
	public void setFr_ref_no(int fr_ref_no) {
		this.fr_ref_no = fr_ref_no;
	}
	public String getFr_title() {
		return fr_title;
	}
	public void setFr_title(String fr_title) {
		this.fr_title = fr_title;
	}
	public String getFr_writer() {
		return fr_writer;
	}
	public void setFr_writer(String fr_writer) {
		this.fr_writer = fr_writer;
	}
	public String getFr_content() {
		return fr_content;
	}
	public void setFr_content(String fr_content) {
		this.fr_content = fr_content;
	}
	public Date getFr_date() {
		return fr_date;
	}
	public void setFr_date(Date fr_date) {
		this.fr_date = fr_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Feedbackreply(int fr_no, int fr_ref_no, String fr_title, String fr_writer, String fr_content, Date fr_date) {
		super();
		this.fr_no = fr_no;
		this.fr_ref_no = fr_ref_no;
		this.fr_title = fr_title;
		this.fr_writer = fr_writer;
		this.fr_content = fr_content;
		this.fr_date = fr_date;
	}
	@Override
	public String toString() {
		return "Feedbackreply [fr_no=" + fr_no + ", fr_ref_no=" + fr_ref_no + ", fr_title=" + fr_title + ", fr_writer="
				+ fr_writer + ", fr_content=" + fr_content + ", fr_date=" + fr_date + "]";
	}
	
	

}
