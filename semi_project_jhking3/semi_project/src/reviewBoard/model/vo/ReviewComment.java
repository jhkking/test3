package reviewBoard.model.vo;

import java.sql.Date;

public class ReviewComment {

	public ReviewComment() {}
	
	private int cno;
	private int bno;
	private String cwriter;
	private String ccontent;
	private Date re_date;
	
	public ReviewComment(int cno, int bno, String cwriter, String ccontent, Date re_date) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.cwriter = cwriter;
		this.ccontent = ccontent;
		this.re_date = re_date;
	}
	
	

	public ReviewComment(int bno, String cwriter, String ccontent) {
		super();
		this.bno = bno;
		this.cwriter = cwriter;
		this.ccontent = ccontent;
	}



	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getRe_date() {
		return re_date;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	@Override
	public String toString() {
		return "ReviewComment [cno=" + cno + ", bno=" + bno + ", cwriter=" + cwriter + ", ccontent=" + ccontent
				+ ", re_date=" + re_date + "]";
	}
	
	
	
	
}
