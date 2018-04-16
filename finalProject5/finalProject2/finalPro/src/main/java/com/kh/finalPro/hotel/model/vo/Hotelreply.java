package com.kh.finalPro.hotel.model.vo;

import java.sql.Date;

public class Hotelreply implements java.io.Serializable{
	private static final long serialVersionUID =20L;
	
	private int ho_no;
	private int ho_ref_no;
	private String ho_writer;
	private String ho_content;
	private Date ho_date;
	
	public Hotelreply() {}

	public int getHo_no() {
		return ho_no;
	}

	public void setHo_no(int ho_no) {
		this.ho_no = ho_no;
	}

	public int getHo_ref_no() {
		return ho_ref_no;
	}

	public void setHo_ref_no(int ho_ref_no) {
		this.ho_ref_no = ho_ref_no;
	}

	public String getHo_writer() {
		return ho_writer;
	}

	public void setHo_writer(String ho_writer) {
		this.ho_writer = ho_writer;
	}

	public String getHo_content() {
		return ho_content;
	}

	public void setHo_content(String ho_content) {
		this.ho_content = ho_content;
	}

	public Date getHo_date() {
		return ho_date;
	}

	public void setHo_date(Date ho_date) {
		this.ho_date = ho_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Hotelreply(int ho_no, int ho_ref_no, String ho_writer, String ho_content, Date ho_date) {
		super();
		this.ho_no = ho_no;
		this.ho_ref_no = ho_ref_no;
		this.ho_writer = ho_writer;
		this.ho_content = ho_content;
		this.ho_date = ho_date;
	}

	@Override
	public String toString() {
		return "Hotelreply [ho_no=" + ho_no + ", ho_ref_no=" + ho_ref_no + ", ho_writer=" + ho_writer + ", ho_content="
				+ ho_content + ", ho_date=" + ho_date + "]";
	}
	
	

}
