package vrBoard.model.vo;

import java.sql.Date;

public class DetailComment {
	public DetailComment() {}
	
	private int cno;
	private int bno;
	private String dwriter;
	private String dcontent;
	private Date re_date;
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
	public String getDwriter() {
		return dwriter;
	}
	public void setDwriter(String dwriter) {
		this.dwriter = dwriter;
	}
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	
	
	
	public DetailComment(int cno, int bno, String dwriter, String dcontent, Date re_date) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.dwriter = dwriter;
		this.dcontent = dcontent;
		this.re_date = re_date;
	}
	
	public DetailComment( int bno, String dwriter, String dcontent) {
		super();
	
		this.bno = bno;
		this.dwriter = dwriter;
		this.dcontent = dcontent;

	}
	@Override
	public String toString() {
		return "DetailComment [cno=" + cno + ", bno=" + bno + ", dwriter=" + dwriter + ", dcontent=" + dcontent
				+ ", re_date=" + re_date + "]";
	}
	


}
