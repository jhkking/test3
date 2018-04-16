package com.kh.finalPro.spot.model.vo;

public class Spot implements java.io.Serializable{

	private static final long serialVersionUID = 123L;
	
	private int s_no;
	private String s_nation1;
	private String s_nation2;
	private String s_title;
	private String s_content;
	private String s_original_filename;
	private String s_rename_filename;
	private String s_address;
	private String s_writer;
	private String s_phone;
	private int s_like_count;
	
	public Spot() {}

	public Spot(int s_no, String s_nation1, String s_nation2, String s_title, String s_content,
			String s_original_filename, String s_rename_filename, String s_address, String s_writer, String s_phone,
			int s_like_count) {
		super();
		this.s_no = s_no;
		this.s_nation1 = s_nation1;
		this.s_nation2 = s_nation2;
		this.s_title = s_title;
		this.s_content = s_content;
		this.s_original_filename = s_original_filename;
		this.s_rename_filename = s_rename_filename;
		this.s_address = s_address;
		this.s_writer = s_writer;
		this.s_phone = s_phone;
		this.s_like_count = s_like_count;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_nation1() {
		return s_nation1;
	}

	public void setS_nation1(String s_nation1) {
		this.s_nation1 = s_nation1;
	}

	public String getS_nation2() {
		return s_nation2;
	}

	public void setS_nation2(String s_nation2) {
		this.s_nation2 = s_nation2;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public String getS_original_filename() {
		return s_original_filename;
	}

	public void setS_original_filename(String s_original_filename) {
		this.s_original_filename = s_original_filename;
	}

	public String getS_rename_filename() {
		return s_rename_filename;
	}

	public void setS_rename_filename(String s_rename_filename) {
		this.s_rename_filename = s_rename_filename;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_writer() {
		return s_writer;
	}

	public void setS_writer(String s_writer) {
		this.s_writer = s_writer;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public int getS_like_count() {
		return s_like_count;
	}

	public void setS_like_count(int s_like_count) {
		this.s_like_count = s_like_count;
	}

	@Override
	public String toString() {
		return "Spot [s_no=" + s_no + ", s_nation1=" + s_nation1 + ", s_nation2=" + s_nation2 + ", s_title=" + s_title
				+ ", s_content=" + s_content + ", s_original_filename=" + s_original_filename + ", s_rename_filename="
				+ s_rename_filename + ", s_address=" + s_address + ", s_writer=" + s_writer + ", s_phone=" + s_phone
				+ ", s_like_count=" + s_like_count + "]";
	}
	
	

}