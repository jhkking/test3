package workerBoard.model.vo;

import java.sql.Date;

public class WbBoard {
	
	
	private int wbnumber;
	private String wbtitle;
	private String wbcontent;
	private String wbwriter;
	private Date wbdate;
	private String wboriginalfilename;
	private String rename;
	private int wb_readcount;
	private int wblevel;
	private int wbref;
	private int wbreplyref;
	private int wbreplyseq;
	public WbBoard() {}
	public int getWbnumber() {
		return wbnumber;
	}
	public void setWbnumber(int wbnumber) {
		this.wbnumber = wbnumber;
	}
	public String getWbtitle() {
		return wbtitle;
	}
	public void setWbtitle(String wbtitle) {
		this.wbtitle = wbtitle;
	}
	public String getWbcontent() {
		return wbcontent;
	}
	public void setWbcontent(String wbcontent) {
		this.wbcontent = wbcontent;
	}
	public String getWbwriter() {
		return wbwriter;
	}
	public void setWbwriter(String wbwriter) {
		this.wbwriter = wbwriter;
	}
	public Date getWbdate() {
		return wbdate;
	}
	public void setWbdate(Date wbdate) {
		this.wbdate = wbdate;
	}
	public String getWboriginalfilename() {
		return wboriginalfilename;
	}
	public void setWboriginalfilename(String wboriginalfilename) {
		this.wboriginalfilename = wboriginalfilename;
	}
	public String getRename() {
		return rename;
	}
	public void setRename(String rename) {
		this.rename = rename;
	}
	
	
	public int getWb_readcount() {
		return wb_readcount;
	}
	public void setWb_readcount(int wb_readcount) {
		this.wb_readcount = wb_readcount;
	}
	public int getWblevel() {
		return wblevel;
	}
	public void setWblevel(int wblevel) {
		this.wblevel = wblevel;
	}
	public int getWbref() {
		return wbref;
	}
	public void setWbref(int wbref) {
		this.wbref = wbref;
	}
	public int getWbreplyref() {
		return wbreplyref;
	}
	public void setWbreplyref(int wbreplyref) {
		this.wbreplyref = wbreplyref;
	}
	public int getWbreplyseq() {
		return wbreplyseq;
	}
	public void setWbreplyseq(int wbreplyseq) {
		this.wbreplyseq = wbreplyseq;
	}
	public WbBoard(int wbnumber, String wbtitle, String wbcontent, String wbwriter, Date wbdate,
			String wboriginalfilename, String rename, int wb_readcount, int wblevel, int wbref, int wbreplyref,
			int wbreplyseq) {
		super();
		this.wbnumber = wbnumber;
		this.wbtitle = wbtitle;
		this.wbcontent = wbcontent;
		this.wbwriter = wbwriter;
		this.wbdate = wbdate;
		this.wboriginalfilename = wboriginalfilename;
		this.rename = rename;
		this.wb_readcount = wb_readcount;
		this.wblevel = wblevel;
		this.wbref = wbref;
		this.wbreplyref = wbreplyref;
		this.wbreplyseq = wbreplyseq;
	}
	
	public WbBoard( String wbtitle, String wbcontent, String wbwriter,
			String wboriginalfilename, String rename) {
		super();
	
		this.wbtitle = wbtitle;
		this.wbcontent = wbcontent;
		this.wbwriter = wbwriter;
		this.wboriginalfilename = wboriginalfilename;
		this.rename = rename;
	
	}
	
	@Override
	public String toString() {
		return "WbBoard [wbnumber=" + wbnumber + ", wbtitle=" + wbtitle + ", wbcontent=" + wbcontent + ", wbwriter="
				+ wbwriter + ", wbdate=" + wbdate + ", wboriginalfilename=" + wboriginalfilename + ", rename=" + rename
				+ ", wb_readcount=" + wb_readcount + ", wblevel=" + wblevel + ", wbref=" + wbref + ", wbreplyref="
				+ wbreplyref + ", wbreplyseq=" + wbreplyseq + "]";
	}
	
	
	
	
	
	
	

}
