package reviewBoard.model.vo;

import java.sql.Date;

public class ReviewBoard implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int reviewNum;
	private String reviewTitle;
	private String reviewWriter;
	private String reviewContent;
	private String reviewOriginalFilename;
	private String reviewReFilename;
	private Date reviewDate;
	private int reviewReadcount;
	private int reviewLevel;
	private int reviewRef;
	private int reviewReplyRef;
	private int reviewReplyTurn;
	
	public ReviewBoard() {}
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewOriginalFilename() {
		return reviewOriginalFilename;
	}
	public void setReviewOriginalFilename(String reviewOriginalFilename) {
		this.reviewOriginalFilename = reviewOriginalFilename;
	}
	public String getReviewReFilename() {
		return reviewReFilename;
	}
	public void setReviewReFilename(String reviewReFilename) {
		this.reviewReFilename = reviewReFilename;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewReadcount() {
		return reviewReadcount;
	}
	public void setReviewReadcount(int reviewReadcount) {
		this.reviewReadcount = reviewReadcount;
	}
	public int getReviewLevel() {
		return reviewLevel;
	}
	public void setReviewLevel(int reviewLevel) {
		this.reviewLevel = reviewLevel;
	}
	public int getReviewRef() {
		return reviewRef;
	}
	public void setReviewRef(int reviewRef) {
		this.reviewRef = reviewRef;
	}
	public int getReviewReplyRef() {
		return reviewReplyRef;
	}
	public void setReviewReplyRef(int reviewReplyRef) {
		this.reviewReplyRef = reviewReplyRef;
	}
	public int getReviewReplyTurn() {
		return reviewReplyTurn;
	}
	public void setReviewReplyTurn(int reviewReplyTurn) {
		this.reviewReplyTurn = reviewReplyTurn;
	}
	public ReviewBoard(int reviewNum, String reviewTitle, String reviewWriter, String reviewContent,
			String reviewOriginalFilename, String reviewReFilename, Date reviewDate, int reviewReadcount,
			int reviewLevel, int reviewRef, int reviewReplyRef, int reviewReplyTurn) {
		super();
		this.reviewNum = reviewNum;
		this.reviewTitle = reviewTitle;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.reviewOriginalFilename = reviewOriginalFilename;
		this.reviewReFilename = reviewReFilename;
		this.reviewDate = reviewDate;
		this.reviewReadcount = reviewReadcount;
		this.reviewLevel = reviewLevel;
		this.reviewRef = reviewRef;
		this.reviewReplyRef = reviewReplyRef;
		this.reviewReplyTurn = reviewReplyTurn;
	}
	
	
	
	public ReviewBoard(String reviewTitle, String reviewWriter, String reviewContent, String reviewOriginalFilename,
			String reviewReFilename) {
		super();
		this.reviewTitle = reviewTitle;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.reviewOriginalFilename = reviewOriginalFilename;
		this.reviewReFilename = reviewReFilename;
	}

	@Override
	public String toString() {
		return "ReviewBoard [reviewNum=" + reviewNum + ", reviewTitle=" + reviewTitle + ", reviewWriter=" + reviewWriter
				+ ", reviewContent=" + reviewContent + ", reviewOriginalFilename=" + reviewOriginalFilename
				+ ", reviewReFilename=" + reviewReFilename + ", reviewDate=" + reviewDate + ", reviewReadcount="
				+ reviewReadcount + ", reviewLevel=" + reviewLevel + ", reviewRef=" + reviewRef + ", reviewReplyRef="
				+ reviewReplyRef + ", reviewReplyTurn=" + reviewReplyTurn + "]";
	}
	
	

}
