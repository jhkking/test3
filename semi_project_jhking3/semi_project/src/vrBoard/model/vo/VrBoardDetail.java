package vrBoard.model.vo;

public class VrBoardDetail implements java.io.Serializable {
	private static final long serialVersionUID = 3L;
	
	private int vrdetailnum;
	private String vrdetailaddress;
	private String vropentime;
	private String vrphone;
	private String vrhomepage;
	
	public VrBoardDetail() {}

	public int getVrdetailnum() {
		return vrdetailnum;
	}

	public void setVrdetailnum(int vrdetailnum) {
		this.vrdetailnum = vrdetailnum;
	}

	public String getVrdetailaddress() {
		return vrdetailaddress;
	}

	public void setVrdetailaddress(String vrdetailaddress) {
		this.vrdetailaddress = vrdetailaddress;
	}

	public String getVropentime() {
		return vropentime;
	}

	public void setVropentime(String vropentime) {
		this.vropentime = vropentime;
	}

	public String getVrphone() {
		return vrphone;
	}

	public void setVrphone(String vrphone) {
		this.vrphone = vrphone;
	}

	public String getVrhomepage() {
		return vrhomepage;
	}

	public void setVrhomepage(String vrhomepage) {
		this.vrhomepage = vrhomepage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public VrBoardDetail(int vrdetailnum, String vrdetailaddress, String vropentime, String vrphone,
			String vrhomepage) {
		super();
		this.vrdetailnum = vrdetailnum;
		this.vrdetailaddress = vrdetailaddress;
		this.vropentime = vropentime;
		this.vrphone = vrphone;
		this.vrhomepage = vrhomepage;
	}

	@Override
	public String toString() {
		return "VrBoardDetail [vrdetailnum=" + vrdetailnum + ", vrdetailaddress=" + vrdetailaddress + ", vropentime="
				+ vropentime + ", vrphone=" + vrphone + ", vrhomepage=" + vrhomepage + "]";
	}
	
	

}
