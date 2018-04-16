package com.kh.finalPro.spot.model.vo;

import java.sql.Date;

public class Spotreply implements java.io.Serializable {
	
	private static final long serialVersionUID =42L;
	
	private int sp_no;
	private int sp_ref_no;
	private String sp_writer;
	private String sp_content;
	private Date sp_date;

	public Spotreply() {}

	public int getSp_no() {
		return sp_no;
	}

	public void setSp_no(int sp_no) {
		this.sp_no = sp_no;
	}

	public int getSp_ref_no() {
		return sp_ref_no;
	}

	public void setSp_ref_no(int sp_ref_no) {
		this.sp_ref_no = sp_ref_no;
	}

	public String getSp_writer() {
		return sp_writer;
	}

	public void setSp_writer(String sp_writer) {
		this.sp_writer = sp_writer;
	}

	public String getSp_content() {
		return sp_content;
	}

	public void setSp_content(String sp_content) {
		this.sp_content = sp_content;
	}

	public Date getSp_date() {
		return sp_date;
	}

	public void setSp_date(Date sp_date) {
		this.sp_date = sp_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Spotreply(int sp_no, int sp_ref_no, String sp_writer, String sp_content, Date sp_date) {
		super();
		this.sp_no = sp_no;
		this.sp_ref_no = sp_ref_no;
		this.sp_writer = sp_writer;
		this.sp_content = sp_content;
		this.sp_date = sp_date;
	}

	@Override
	public String toString() {
		return "Spotreply [sp_no=" + sp_no + ", sp_ref_no=" + sp_ref_no + ", sp_writer=" + sp_writer + ", sp_content="
				+ sp_content + ", sp_date=" + sp_date + "]";
	}
	
	
}
