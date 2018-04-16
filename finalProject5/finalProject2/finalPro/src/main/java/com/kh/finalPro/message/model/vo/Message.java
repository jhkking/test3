package com.kh.finalPro.message.model.vo;

import java.sql.Date;

public class Message implements java.io.Serializable{
   public static final long serialVersionUID = 125L; 
   
   public Message() {}
   
   private int m_no;
   private String m_title;
   private String m_content;
   private String m_writer;
   private String m_date;
   private String m_read;
   private String m_recv;
   private String m_d_writer;
   private String m_d_recv;

   public int getM_no() {
      return m_no;
   }
   public void setM_no(int m_no) {
      this.m_no = m_no;
   }
   public String getM_title() {
      return m_title;
   }
   public void setM_title(String m_title) {
      this.m_title = m_title;
   }
   public String getM_content() {
      return m_content;
   }
   public void setM_content(String m_content) {
      this.m_content = m_content;
   }
   public String getM_writer() {
      return m_writer;
   }
   public void setM_writer(String m_writer) {
      this.m_writer = m_writer;
   }
   public String getM_date() {
      return m_date;
   }
   public void setM_date(String m_date) {
      this.m_date = m_date;
   }
   public String getM_read() {
      return m_read;
   }
   public void setM_read(String m_read) {
      this.m_read = m_read;
   }
   public String getM_recv() {
      return m_recv;
   }
   public void setM_recv(String m_recv) {
      this.m_recv = m_recv;
   }
   public String getM_d_writer() {
      return m_d_writer;
   }
   public void setM_d_writer(String m_d_writer) {
      this.m_d_writer = m_d_writer;
   }
   public String getM_d_recv() {
      return m_d_recv;
   }
   public void setM_d_recv(String m_d_recv) {
      this.m_d_recv = m_d_recv;
   }
   public Message(int m_no, String m_title, String m_content, String m_writer, String m_date, String m_read,
         String m_recv, String m_d_writer, String m_d_recv) {
      super();
      this.m_no = m_no;
      this.m_title = m_title;
      this.m_content = m_content;
      this.m_writer = m_writer;
      this.m_date = m_date;
      this.m_read = m_read;
      this.m_recv = m_recv;
      this.m_d_writer = m_d_writer;
      this.m_d_recv = m_d_recv;
   }
   @Override
   public String toString() {
      return "Message [m_no=" + m_no + ", m_title=" + m_title + ", m_content=" + m_content + ", m_writer=" + m_writer
            + ", m_date=" + m_date + ", m_read=" + m_read + ", m_recv=" + m_recv + ", m_d_writer=" + m_d_writer
            + ", m_d_recv=" + m_d_recv + "]";
   }


}