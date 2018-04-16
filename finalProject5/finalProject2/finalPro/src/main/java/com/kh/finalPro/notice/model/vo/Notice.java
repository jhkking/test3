package com.kh.finalPro.notice.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class Notice implements java.io.Serializable {
	private static final long serialVersionUID = 22L;
	
	private int n_no;
	private String n_title;
	private String n_writer;
	private Date n_date;
	private String n_content;
	private String n_original_filename;
	private String n_rename_filename;
	private int n_readcount;
	
	public Notice() {}

	public Notice(int n_no, String n_title, String n_writer, Date n_date, String n_content, String n_original_filename,
			String n_rename_filename, int n_readcount) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_writer = n_writer;
		this.n_date = n_date;
		this.n_content = n_content;
		this.n_original_filename = n_original_filename;
		this.n_rename_filename = n_rename_filename;
		this.n_readcount = n_readcount;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_original_filename() {
		return n_original_filename;
	}

	public void setN_original_filename(String n_original_filename) {
		this.n_original_filename = n_original_filename;
	}

	public String getN_rename_filename() {
		return n_rename_filename;
	}

	public void setN_rename_filename(String n_rename_filename) {
		this.n_rename_filename = n_rename_filename;
	}

	public int getN_readcount() {
		return n_readcount;
	}

	public void setN_readcount(int n_readcount) {
		this.n_readcount = n_readcount;
	}

	@Override
	public String toString() {
		return "Notice [n_no=" + n_no + ", n_title=" + n_title + ", n_writer=" + n_writer + ", n_date=" + n_date
				+ ", n_content=" + n_content + ", n_original_filename=" + n_original_filename + ", n_rename_filename="
				+ n_rename_filename + ", n_readcount=" + n_readcount + "]";
	}
	
	
}
