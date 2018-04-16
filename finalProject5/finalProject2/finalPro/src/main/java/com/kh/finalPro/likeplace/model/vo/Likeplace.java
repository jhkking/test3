package com.kh.finalPro.likeplace.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Likeplace implements java.io.Serializable{
	
	private static final long serialVersionUID=33L;
	
	private String like_member;
	private String like_place_code;
	private int like_place_no;
	
	public Likeplace() {}
	
	public String getLike_member() {
		return like_member;
	}
	public void setLike_member(String like_member) {
		this.like_member = like_member;
	}
	public String getLike_place_code() {
		return like_place_code;
	}
	public void setLike_place_code(String like_place_code) {
		this.like_place_code = like_place_code;
	}
	public int getLike_place_no() {
		return like_place_no;
	}
	public void setLike_place_no(int like_place_no) {
		this.like_place_no = like_place_no;
	}
	public Likeplace(String like_member, String like_place_code, int like_place_no) {
		super();
		this.like_member = like_member;
		this.like_place_code = like_place_code;
		this.like_place_no = like_place_no;
	}
	@Override
	public String toString() {
		return "Likeplace [like_member=" + like_member + ", like_place_code=" + like_place_code + ", like_place_no="
				+ like_place_no + "]";
	}
	
	

}
