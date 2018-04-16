package com.kh.finalPro.hotel.model.vo;

public class Hotel {
	private static final long serialVersionUID =32L;
	private int h_no;
	private String h_nation1;
	private String h_nation2;
	private String h_title;
	private String h_content;
	private String h_original_filename;
	private String h_rename_filename;
	private String h_address;
	private String h_writer;
	private String h_phone;
	private String h_like_count;
	
	public Hotel() {}

	public Hotel(int h_no, String h_nation1, String h_nation2, String h_title, String h_content,
			String h_original_filename, String h_rename_filename, String h_address, String h_writer, String h_phone,
			String h_like_count) {
		super();
		this.h_no = h_no;
		this.h_nation1 = h_nation1;
		this.h_nation2 = h_nation2;
		this.h_title = h_title;
		this.h_content = h_content;
		this.h_original_filename = h_original_filename;
		this.h_rename_filename = h_rename_filename;
		this.h_address = h_address;
		this.h_writer = h_writer;
		this.h_phone = h_phone;
		this.h_like_count = h_like_count;
	}

	public int getH_no() {
		return h_no;
	}

	public void setH_no(int h_no) {
		this.h_no = h_no;
	}

	public String getH_nation1() {
		return h_nation1;
	}

	public void setH_nation1(String h_nation1) {
		this.h_nation1 = h_nation1;
	}

	public String getH_nation2() {
		return h_nation2;
	}

	public void setH_nation2(String h_nation2) {
		this.h_nation2 = h_nation2;
	}

	public String getH_title() {
		return h_title;
	}

	public void setH_title(String h_title) {
		this.h_title = h_title;
	}

	public String getH_content() {
		return h_content;
	}

	public void setH_content(String h_content) {
		this.h_content = h_content;
	}

	public String getH_original_filename() {
		return h_original_filename;
	}

	public void setH_original_filename(String h_original_filename) {
		this.h_original_filename = h_original_filename;
	}

	public String getH_rename_filename() {
		return h_rename_filename;
	}

	public void setH_rename_filename(String h_rename_filename) {
		this.h_rename_filename = h_rename_filename;
	}

	public String getH_address() {
		return h_address;
	}

	public void setH_address(String h_address) {
		this.h_address = h_address;
	}

	public String getH_writer() {
		return h_writer;
	}

	public void setH_writer(String h_writer) {
		this.h_writer = h_writer;
	}

	public String getH_phone() {
		return h_phone;
	}

	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}

	public String getH_like_count() {
		return h_like_count;
	}

	public void setH_like_count(String h_like_count) {
		this.h_like_count = h_like_count;
	}

	@Override
	public String toString() {
		return "Hotel [h_no=" + h_no + ", h_nation1=" + h_nation1 + ", h_nation2=" + h_nation2 + ", h_title=" + h_title
				+ ", h_content=" + h_content + ", h_original_filename=" + h_original_filename + ", h_rename_filename="
				+ h_rename_filename + ", h_address=" + h_address + ", h_writer=" + h_writer + ", h_phone=" + h_phone
				+ ", h_like_count=" + h_like_count + "]";
	}

	
}
