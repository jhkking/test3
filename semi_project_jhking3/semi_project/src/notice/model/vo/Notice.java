package notice.model.vo;

import java.io.Serializable;
import java.sql.*;

public class Notice implements Serializable{
	
	private static final long serialVersionUID=2L;
	
	private int noticeNum;
	private String noticeTitle;
	private String noticeWriter;
	private Date noticeDate;
	private String noticeContent;
	private String noticeOriginalFilename;
	private String noticeRenameFilename;
	private int noticeReadCount;
	
	public Notice(){}
	
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeOriginalFilename() {
		return noticeOriginalFilename;
	}
	public void setNoticeOriginalFilename(String noticeOriginalFilename) {
		this.noticeOriginalFilename = noticeOriginalFilename;
	}
	public String getNoticeRenameFilename() {
		return noticeRenameFilename;
	}
	public void setNoticeRenameFilename(String noticeRenameFilename) {
		this.noticeRenameFilename = noticeRenameFilename;
	}
	public int getNoticeReadCount() {
		return noticeReadCount;
	}
	public void setNoticeReadCount(int noticeReadCount) {
		this.noticeReadCount = noticeReadCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Notice(int noticeNum, String noticeTitle, String noticeWriter, Date noticeDate, String noticeContent,
			String noticeOriginalFilename, String noticeRenameFilename, int noticeReadCount) {
		super();
		this.noticeNum = noticeNum;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.noticeOriginalFilename = noticeOriginalFilename;
		this.noticeRenameFilename = noticeRenameFilename;
		this.noticeReadCount = noticeReadCount;
	}
	public Notice(String noticeTitle, String noticeWriter, String noticeContent, String noticeOriginalFilename, String noticeRenameFilename) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeOriginalFilename = noticeOriginalFilename;
		this.noticeRenameFilename = noticeRenameFilename;
	}

	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeDate=" + noticeDate + ", noticeContent=" + noticeContent + ", noticeOriginalFilename="
				+ noticeOriginalFilename + ", noticeRenameFilename=" + noticeRenameFilename + ", noticeReadCount="
				+ noticeReadCount + "]";
	}
	
	
}
