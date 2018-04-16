package com.kh.finalPro.rootconsulting.model.vo;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Rootconsulting implements java.io.Serializable{

	private static final long serialVersionUID = 22L;
	
	private String mr_writer ;
	private int mr_day;
	private String mr_nation1;
	private String mr_nation2;
	private String mr_title;
	private String mr_content;
	private String mr_original_filename;
	private String mr_rename_filename;
	private int mr_readcount;
	private Date mr_date;
	
	public Rootconsulting() {}
	

	public Rootconsulting(String mr_writer, int mr_day, String mr_nation1, String mr_nation2, String mr_title,
			String mr_content, String mr_original_filename, String mr_rename_filename, int mr_readcount, Date mr_date) {
		super();
		this.mr_writer = mr_writer;
		this.mr_day = mr_day;
		this.mr_nation1 = mr_nation1;
		this.mr_nation2 = mr_nation2;
		this.mr_title = mr_title;
		this.mr_content = mr_content;
		this.mr_original_filename = mr_original_filename;
		this.mr_rename_filename = mr_rename_filename;
		this.mr_readcount = mr_readcount;
		this.mr_date = mr_date;
	}


	public String getMr_writer() {
		return mr_writer;
	}

	public void setMr_writer(String mr_writer) {
		this.mr_writer = mr_writer;
	}

	public int getMr_day() {
		return mr_day;
	}

	public void setMr_day(int mr_day) {
		this.mr_day = mr_day;
	}

	public String getMr_nation1() {
		return mr_nation1;
	}

	public void setMr_nation1(String mr_nation1) {
		this.mr_nation1 = mr_nation1;
	}

	public String getMr_nation2() {
		return mr_nation2;
	}

	public void setMr_nation2(String mr_nation2) {
		this.mr_nation2 = mr_nation2;
	}

	public String getMr_title() {
		return mr_title;
	}

	public void setMr_title(String mr_title) {
		this.mr_title = mr_title;
	}

	public String getMr_content() {
		return mr_content;
	}

	public void setMr_content(String mr_content) {
		this.mr_content = mr_content;
	}

	public String getMr_original_filename() {
		return mr_original_filename;
	}

	public void setMr_original_filename(String mr_original_filename) {
		this.mr_original_filename = mr_original_filename;
	}
	
	public String getMr_rename_filename() {
		return mr_rename_filename;
	}

	public void setMr_rename_filename(String mr_rename_filename) {
		this.mr_rename_filename = mr_rename_filename;
	}
	
	public int getMr_readcount() {
		return mr_readcount;
	}

	public void setMr_readcount(int mr_readcount) {
		this.mr_readcount = mr_readcount;
	}

	public Date getMr_date() {
		return mr_date;
	}

	public void setMr_date(Date mr_date) {
		this.mr_date = mr_date;
	}


	@Override
	public String toString() {
		return "Rootconsulting [mr_writer=" + mr_writer + ", mr_day=" + mr_day + ", mr_nation1=" + mr_nation1
				+ ", mr_nation2=" + mr_nation2 + ", mr_title=" + mr_title + ", mr_content=" + mr_content
				+ ", mr_original_filename=" + mr_original_filename + ", mr_rename_filename=" + mr_rename_filename
				+ ", mr_readcount=" + mr_readcount + ", mr_date=" + mr_date + "]";
	}

	
}
