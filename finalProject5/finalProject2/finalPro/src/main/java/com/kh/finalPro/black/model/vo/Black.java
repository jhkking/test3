package com.kh.finalPro.black.model.vo;

public class Black implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Black() {}
	
	private String white_id;
	private String black_id;
	private String b_title;
	private String b_content;

	public Black(String white_id, String black_id, String b_title, String b_content) {
		super();
		this.white_id = white_id;
		this.black_id = black_id;
		this.b_title = b_title;
		this.b_content = b_content;
	}

	@Override
	public String toString() {
		return "Black [whtie_id=" + white_id + ", black_id=" + black_id + ", b_title=" + b_title + ", b_content="
				+ b_content + "]";
	}

	public String getWhite_id() {
		return white_id;
	}

	public void setWhite_id(String white_id) {
		this.white_id = white_id;
	}

	public String getBlack_id() {
		return black_id;
	}

	public void setBlack_id(String black_id) {
		this.black_id = black_id;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
