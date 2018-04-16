package vrBoard.model.vo;

import java.sql.Date;

public class vrBoard implements java.io.Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private int vrboardnum;
	private String vrcode;
	private String vrboardtitle;
	private String vrboardwriter;
	private String vrboardcontent;
	private String vrboardoriginalfilename;
	private String vrboardrenamefilename;
	private Date vrboarddate;
	private int vrboardreadcount;
	private int vrlikecount;
	
	public vrBoard(){}

	public int getVrboardnum() {
		return vrboardnum;
	}

	public void setVrboardnum(int vrboardnum) {
		this.vrboardnum = vrboardnum;
	}

	public String getVrcode() {
		return vrcode;
	}

	public void setVrcode(String vrcode) {
		this.vrcode = vrcode;
	}

	public String getVrboardtitle() {
		return vrboardtitle;
	}

	public void setVrboardtitle(String vrboardtitle) {
		this.vrboardtitle = vrboardtitle;
	}

	public String getVrboardwriter() {
		return vrboardwriter;
	}

	public void setVrboardwriter(String vrboardwriter) {
		this.vrboardwriter = vrboardwriter;
	}

	public String getVrboardcontent() {
		return vrboardcontent;
	}

	public void setVrboardcontent(String vrboardcontent) {
		this.vrboardcontent = vrboardcontent;
	}

	public String getVrboardoriginalfilename() {
		return vrboardoriginalfilename;
	}

	public void setVrboardoriginalfilename(String vrboardoriginalfilename) {
		this.vrboardoriginalfilename = vrboardoriginalfilename;
	}

	public String getVrboardrenamefilename() {
		return vrboardrenamefilename;
	}

	public void setVrboardrenamefilename(String vrboardrenamefilename) {
		this.vrboardrenamefilename = vrboardrenamefilename;
	}

	public Date getVrboarddate() {
		return vrboarddate;
	}

	public void setVrboarddate(Date vrboarddate) {
		this.vrboarddate = vrboarddate;
	}

	public int getVrboardreadcount() {
		return vrboardreadcount;
	}

	public void setVrboardreadcount(int vrboardreadcount) {
		this.vrboardreadcount = vrboardreadcount;
	}

	public int getVrlikecount() {
		return vrlikecount;
	}

	public void setVrlikecount(int vrlikecount) {
		this.vrlikecount = vrlikecount;
	}

	public vrBoard(int vrboardnum, String vrcode, String vrboardtitle, String vrboardwriter, String vrboardcontent,
			String vrboardoriginalfilename, String vrboardrenamefilename, Date vrboarddate, int vrboardreadcount,
			int vrlikecount) {
		super();
		this.vrboardnum = vrboardnum;
		this.vrcode = vrcode;
		this.vrboardtitle = vrboardtitle;
		this.vrboardwriter = vrboardwriter;
		this.vrboardcontent = vrboardcontent;
		this.vrboardoriginalfilename = vrboardoriginalfilename;
		this.vrboardrenamefilename = vrboardrenamefilename;
		this.vrboarddate = vrboarddate;
		this.vrboardreadcount = vrboardreadcount;
		this.vrlikecount = vrlikecount;
	}

	@Override
	public String toString() {
		return "vrBoard [vrboardnum=" + vrboardnum + ", vrcode=" + vrcode + ", vrboardtitle=" + vrboardtitle
				+ ", vrboardwriter=" + vrboardwriter + ", vrboardcontent=" + vrboardcontent
				+ ", vrboardoriginalfilename=" + vrboardoriginalfilename + ", vrboardrenamefilename="
				+ vrboardrenamefilename + ", vrboarddate=" + vrboarddate + ", vrboardreadcount=" + vrboardreadcount
				+ ", vrlikecount=" + vrlikecount + "]";
	}

	
	
	
}
