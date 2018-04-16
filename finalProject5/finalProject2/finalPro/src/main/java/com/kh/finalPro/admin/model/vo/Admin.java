package com.kh.finalPro.admin.model.vo;

import java.sql.Date;

public class Admin implements java.io.Serializable {
   private static final long serialVersionUID = 124L;
   
   private String member_id;
   private String member_pwd;
   private String member_name;
   private String pwd_hint;
   private String pwd_answer;
   private Date member_birth;
   private char gender;
   private String phone;
   private String email;
   private String address;
   private char blackuser;
   
   public Admin() {}

   public Admin(String member_id, String member_pwd, String member_name, String pwd_hint, String pwd_answer,
         Date member_birth, char gender, String phone, String email, String address, char blackuser) {
      super();
      this.member_id = member_id;
      this.member_pwd = member_pwd;
      this.member_name = member_name;
      this.pwd_hint = pwd_hint;
      this.pwd_answer = pwd_answer;
      this.member_birth = member_birth;
      this.gender = gender;
      this.phone = phone;
      this.email = email;
      this.address = address;
      this.blackuser = blackuser;
   }

   public char getBlackuser() {
	return blackuser;
}

public void setBlackUser(char blackuser) {
	this.blackuser = blackuser;
}

public String getMember_id() {
      return member_id;
   }

   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }

   public String getMember_pwd() {
      return member_pwd;
   }

   public void setMember_pwd(String member_pwd) {
      this.member_pwd = member_pwd;
   }

   public String getMember_name() {
      return member_name;
   }

   public void setMember_name(String member_name) {
      this.member_name = member_name;
   }

   public String getPwd_hint() {
      return pwd_hint;
   }

   public void setPwd_hint(String pwd_hint) {
      this.pwd_hint = pwd_hint;
   }

   public String getPwd_answer() {
      return pwd_answer;
   }

   public void setPwd_answer(String pwd_answer) {
      this.pwd_answer = pwd_answer;
   }

   public Date getMember_birth() {
      return member_birth;
   }

   public void setMember_birth(Date member_birth) {
      this.member_birth = member_birth;
   }

   public char getGender() {
      return gender;
   }

   public void setGender(char gender) {
      this.gender = gender;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

@Override
public String toString() {
	return "Admin [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
			+ ", pwd_hint=" + pwd_hint + ", pwd_answer=" + pwd_answer + ", member_birth=" + member_birth + ", gender="
			+ gender + ", phone=" + phone + ", email=" + email + ", address=" + address + ", blackUser=" + blackuser
			+ "]";
}



}