package qnaBoard.model.vo;

import java.sql.Date;

import oracle.sql.DATE;

public class QnaBoard {
	
	
	private String qnavisible;
	private int qnano;
	private String title;
	private String content;
	private String qnawriter;
	private Date qnadate;
	private String qnaoriginalfilename;
	private String rename;
	private int qnareadcount;
	private int qnalevel;
	private int qnaref;
	private int qnareplyref;
	private int qnareplyseq;

	public QnaBoard() {}

	public String getQnavisible() {
		return qnavisible;
	}

	public void setQnavisible(String qnavisible) {
		this.qnavisible = qnavisible;
	}

	public int getQnano() {
		return qnano;
	}

	public void setQnano(int qnano) {
		this.qnano = qnano;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQnawriter() {
		return qnawriter;
	}

	public void setQnawriter(String qnawriter) {
		this.qnawriter = qnawriter;
	}

	public Date getQnadate() {
		return qnadate;
	}

	public void setQnadate(Date qnadate) {
		this.qnadate = qnadate;
	}

	public String getQnaoriginalfilename() {
		return qnaoriginalfilename;
	}

	public void setQnaoriginalfilename(String qnaoriginalfilename) {
		this.qnaoriginalfilename = qnaoriginalfilename;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public int getQnareadcount() {
		return qnareadcount;
	}

	public void setQnareadcount(int qnareadcount) {
		this.qnareadcount = qnareadcount;
	}

	public int getQnalevel() {
		return qnalevel;
	}

	public void setQnalevel(int qnalevel) {
		this.qnalevel = qnalevel;
	}

	public int getQnaref() {
		return qnaref;
	}

	public void setQnaref(int qnaref) {
		this.qnaref = qnaref;
	}

	public int getQnareplyref() {
		return qnareplyref;
	}

	public void setQnareplyref(int qnareplyref) {
		this.qnareplyref = qnareplyref;
	}

	public int getQnareplyseq() {
		return qnareplyseq;
	}

	public void setQnareplyseq(int qnareplyseq) {
		this.qnareplyseq = qnareplyseq;
	}

	public QnaBoard(String qnavisible, int qnano, String title, String content, String qnawriter, Date qnadate,
			String qnaoriginalfilename, String rename, int qnareadcount, int qnalevel, int qnaref, int qnareplyref,
			int qnareplyseq) {
		super();
		this.qnavisible = qnavisible;
		this.qnano = qnano;
		this.title = title;
		this.content = content;
		this.qnawriter = qnawriter;
		this.qnadate = qnadate;
		this.qnaoriginalfilename = qnaoriginalfilename;
		this.rename = rename;
		this.qnareadcount = qnareadcount;
		this.qnalevel = qnalevel;
		this.qnaref = qnaref;
		this.qnareplyref = qnareplyref;
		this.qnareplyseq = qnareplyseq;
	}


	public QnaBoard(String title, String content, String qnawriter, String qnaoriginalfilename, String rename) {
		super();
		this.title = title;
		this.content = content;
		this.qnawriter = qnawriter;
		this.qnaoriginalfilename = qnaoriginalfilename;
		this.rename = rename;
	}

	@Override
	public String toString() {
		return "QnaBoard [qnavisible=" + qnavisible + ", qnano=" + qnano + ", title=" + title + ", content=" + content
				+ ", qnawriter=" + qnawriter + ", qnadate=" + qnadate + ", qnaoriginalfilename=" + qnaoriginalfilename
				+ ", rename=" + rename + ", qnareadcount=" + qnareadcount + ", qnalevel=" + qnalevel + ", qnaref="
				+ qnaref + ", qnareplyref=" + qnareplyref + ", qnareplyseq=" + qnareplyseq + "]";
	}
	
	

}
