package com.kh.finalPro.qna.model.vo;

import java.sql.Date;

public class Qnareply {
   
   private int qr_no;
   private int qr_ref_no;
   
   private String qr_writer;
   private String qr_content;
   private Date qr_date;
   public Qnareply() {}
   public int getQr_no() {
      return qr_no;
   }
   public void setQr_no(int qr_no) {
      this.qr_no = qr_no;
   }
   public int getQr_ref_no() {
      return qr_ref_no;
   }
   public void setQr_ref_no(int qr_ref_no) {
      this.qr_ref_no = qr_ref_no;
   }
   public String getQr_writer() {
      return qr_writer;
   }
   public void setQr_writer(String qr_writer) {
      this.qr_writer = qr_writer;
   }
   public String getQr_content() {
      return qr_content;
   }
   public void setQr_content(String qr_content) {
      this.qr_content = qr_content;
   }
   public Date getQr_date() {
      return qr_date;
   }
   public void setQr_date(Date qr_date) {
      this.qr_date = qr_date;
   }
   public Qnareply(int qr_no, int qr_ref_no, String qr_writer, String qr_content, Date qr_date) {
      super();
      this.qr_no = qr_no;
      this.qr_ref_no = qr_ref_no;
      this.qr_writer = qr_writer;
      this.qr_content = qr_content;
      this.qr_date = qr_date;
   }
   @Override
   public String toString() {
      return "Qnareply [qr_no=" + qr_no + ", qr_ref_no=" + qr_ref_no + ", qr_writer=" + qr_writer + ", qr_content="
            + qr_content + ", qr_date=" + qr_date + "]";
   }
   

}