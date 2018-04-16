package com.kh.finalPro.food.model.vo;

public class Food implements java.io.Serializable{
	
	private static final long serialVersionUID =321L;
	private int food_no;
	private String food_nation1;
	private String food_nation2;
	private String food_title;
	private String food_content;
	private String food_original_filename;
	private String food_rename_filename;
	private String food_address;
	private String food_writer;
	private String food_phone;
	private int food_like_count;
	
	public Food() {}

	
	
	public Food(int food_no, String food_nation1, String food_nation2, String food_title, String food_content,
			String food_original_filename, String food_rename_filename, String food_address, String food_writer,
			String food_phone, int food_like_count) {
		super();
		this.food_no = food_no;
		this.food_nation1 = food_nation1;
		this.food_nation2 = food_nation2;
		this.food_title = food_title;
		this.food_content = food_content;
		this.food_original_filename = food_original_filename;
		this.food_rename_filename = food_rename_filename;
		this.food_address = food_address;
		this.food_writer = food_writer;
		this.food_phone = food_phone;
		this.food_like_count = food_like_count;
	}



	public int getFood_no() {
		return food_no;
	}

	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}

	public String getFood_nation1() {
		return food_nation1;
	}

	public void setFood_nation1(String food_nation1) {
		this.food_nation1 = food_nation1;
	}

	public String getFood_nation2() {
		return food_nation2;
	}

	public void setFood_nation2(String food_nation2) {
		this.food_nation2 = food_nation2;
	}

	public String getFood_title() {
		return food_title;
	}

	public void setFood_title(String food_title) {
		this.food_title = food_title;
	}

	public String getFood_content() {
		return food_content;
	}

	public void setFood_content(String food_content) {
		this.food_content = food_content;
	}

	public String getFood_original_filename() {
		return food_original_filename;
	}

	public void setFood_original_filename(String food_original_filename) {
		this.food_original_filename = food_original_filename;
	}

	public String getFood_rename_filename() {
		return food_rename_filename;
	}

	public void setFood_rename_filename(String food_rename_filename) {
		this.food_rename_filename = food_rename_filename;
	}

	public String getFood_address() {
		return food_address;
	}

	public void setFood_address(String food_address) {
		this.food_address = food_address;
	}

	public String getFood_writer() {
		return food_writer;
	}

	public void setFood_writer(String food_writer) {
		this.food_writer = food_writer;
	}

	public String getFood_phone() {
		return food_phone;
	}

	public void setFood_phone(String food_phone) {
		this.food_phone = food_phone;
	}

	public int getFood_like_count() {
		return food_like_count;
	}

	public void setFood_like_count(int food_like_count) {
		this.food_like_count = food_like_count;
	}

	@Override
	public String toString() {
		return "Food [food_no=" + food_no + ", food_nation1=" + food_nation1 + ", food_nation2=" + food_nation2
				+ ", food_title=" + food_title + ", food_content=" + food_content + ", food_original_filename="
				+ food_original_filename + ", food_rename_filename=" + food_rename_filename + ", food_address="
				+ food_address + ", food_writer=" + food_writer + ", food_phone=" + food_phone + ", food_like_count="
				+ food_like_count + "]";
	}

	
	
}
