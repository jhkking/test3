package member.model.vo;
import java.sql.Date;
public class Member implements java.io.Serializable{
	  private static final long serialVersionUID = 10000L;
	  private String smemberId;
	  private String smemberPwd;
	  private String smemberPwdHint;
	  private String smemberPwdAns;
	  private String smemberName;
	  private int smemberIdNumber;
	  private String smemberAddress;
	  private String smemberGender;
	  private String smemberPhone;
	  private String smemberEmail;
	  private String smemberAdminYN;
	  private Date smemberDate;
	  private String smemberWorkerYN;
	  
	   public Member() {}


/*	public Member(String smemberId, String smemberPwd, String smemberPwdHint, String smemberPwdAns, String smemberName,
			int smemberIdNumber, String smemberAddress, String smemberGender, String smemberPhone, String smemberEmail,
			String smemberYN, Date smemberDate) {
		super();
		this.smemberId = smemberId;
		this.smemberPwd = smemberPwd;
		this.smemberPwdHint = smemberPwdHint;
		this.smemberPwdAns = smemberPwdAns;
		this.smemberName = smemberName;
		this.smemberIdNumber = smemberIdNumber;
		this.smemberAddress = smemberAddress;
		this.smemberGender = smemberGender;
		this.smemberPhone = smemberPhone;
		this.smemberEmail = smemberEmail;
		this.smemberYN = smemberYN;
		this.smemberDate = smemberDate;
	}




*/




	public Member(String smemberId, String smemberPwd, String smemberName, int smemberIdNumber,
			String smemberAddress, String smemberGender, String smemberPhone, String smemberEmail) {
		this.smemberId = smemberId;
		this.smemberPwd = smemberPwd;
		this.smemberName = smemberName;
		this.smemberIdNumber = smemberIdNumber;
		this.smemberAddress = smemberAddress;
		this.smemberGender = smemberGender;
		this.smemberPhone = smemberPhone;
		this.smemberEmail = smemberEmail;
	}

	public Member(String smemberId, String smemberPwd, String smemberPwdHint, String smemberPwdAns, String smemberName,
		int smemberIdNumber, String smemberAddress, String smemberGender, String smemberPhone, String smemberEmail,
		String smemberAdminYN, Date smemberDate, String smemberWorkerYN) {
	super();
	this.smemberId = smemberId;
	this.smemberPwd = smemberPwd;
	this.smemberPwdHint = smemberPwdHint;
	this.smemberPwdAns = smemberPwdAns;
	this.smemberName = smemberName;
	this.smemberIdNumber = smemberIdNumber;
	this.smemberAddress = smemberAddress;
	this.smemberGender = smemberGender;
	this.smemberPhone = smemberPhone;
	this.smemberEmail = smemberEmail;
	this.smemberAdminYN = smemberAdminYN;
	this.smemberDate = smemberDate;
	this.smemberWorkerYN = smemberWorkerYN;
}

	public Member(String smemberId, String smemberPwd, String smemberPwdHint, String smemberPwdAns, String smemberName,
			int smemberIdNumber, String smemberAddress, String smemberGender, String smemberPhone, String smemberEmail,
			String smemberAdminYN, String smemberWorkerYN) {
		super();
		this.smemberId = smemberId;
		this.smemberPwd = smemberPwd;
		this.smemberPwdHint = smemberPwdHint;
		this.smemberPwdAns = smemberPwdAns;
		this.smemberName = smemberName;
		this.smemberIdNumber = smemberIdNumber;
		this.smemberAddress = smemberAddress;
		this.smemberGender = smemberGender;
		this.smemberPhone = smemberPhone;
		this.smemberEmail = smemberEmail;
		this.smemberAdminYN = smemberAdminYN;
		this.smemberWorkerYN = smemberWorkerYN;
	}


	public Member(String smemberId, String smemberPwd, String smemberPwdHint, String smemberPwdAns, String smemberName,
	         int smemberIdNumber, String smemberAddress, String smemberGender, String smemberPhone, String smemberEmail) {
	      super();
	      this.smemberId = smemberId;
	      this.smemberPwd = smemberPwd;
	      this.smemberPwdHint = smemberPwdHint;
	      this.smemberPwdAns = smemberPwdAns;
	      this.smemberName = smemberName;
	      this.smemberIdNumber = smemberIdNumber;
	      this.smemberAddress = smemberAddress;
	      this.smemberGender = smemberGender;
	      this.smemberPhone = smemberPhone;
	      this.smemberEmail = smemberEmail;
	   }

	public String getSmemberId() {
		return smemberId;
	}







	public void setSmemberId(String smemberId) {
		this.smemberId = smemberId;
	}







	public String getSmemberPwd() {
		return smemberPwd;
	}







	public void setSmemberPwd(String smemberPwd) {
		this.smemberPwd = smemberPwd;
	}







	public String getSmemberPwdHint() {
		return smemberPwdHint;
	}







	public void setSmemberPwdHint(String smemberPwdHint) {
		this.smemberPwdHint = smemberPwdHint;
	}







	public String getSmemberPwdAns() {
		return smemberPwdAns;
	}







	public void setSmemberPwdAns(String smemberPwdAns) {
		this.smemberPwdAns = smemberPwdAns;
	}







	public String getSmemberName() {
		return smemberName;
	}







	public void setSmemberName(String smemberName) {
		this.smemberName = smemberName;
	}







	public int getSmemberIdNumber() {
		return smemberIdNumber;
	}







	public void setSmemberIdNumber(int smemberIdNumber) {
		this.smemberIdNumber = smemberIdNumber;
	}







	public String getSmemberAddress() {
		return smemberAddress;
	}







	public void setSmemberAddress(String smemberAddress) {
		this.smemberAddress = smemberAddress;
	}







	public String getSmemberGender() {
		return smemberGender;
	}







	public void setSmemberGender(String smemberGender) {
		this.smemberGender = smemberGender;
	}







	public String getSmemberPhone() {
		return smemberPhone;
	}







	public void setSmemberPhone(String smemberPhone) {
		this.smemberPhone = smemberPhone;
	}







	public String getSmemberEmail() {
		return smemberEmail;
	}







	public void setSmemberEmail(String smemberEmail) {
		this.smemberEmail = smemberEmail;
	}





	public String getSmemberAdminYN() {
		return smemberAdminYN;
	}


	public void setSmemberAdminYN(String smemberAdminYN) {
		this.smemberAdminYN = smemberAdminYN;
	}


	public Date getSmemberDate() {
		return smemberDate;
	}







	public void setSmemberDate(Date smemberDate) {
		this.smemberDate = smemberDate;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getSmemberWorkerYN() {
		return smemberWorkerYN;
	}


	public void setSmemberWorkerYN(String smemberWorkerYN) {
		this.smemberWorkerYN = smemberWorkerYN;
	}


	@Override
	public String toString() {
		return "Member [smemberId=" + smemberId + ", smemberPwd=" + smemberPwd + ", smemberPwdHint=" + smemberPwdHint
				+ ", smemberPwdAns=" + smemberPwdAns + ", smemberName=" + smemberName + ", smemberIdNumber="
				+ smemberIdNumber + ", smemberAddress=" + smemberAddress + ", smemberGender=" + smemberGender
				+ ", smemberPhone=" + smemberPhone + ", smemberEmail=" + smemberEmail + ", smemberAdminYN="
				+ smemberAdminYN + ", smemberDate=" + smemberDate + ", smemberWorkerYN=" + smemberWorkerYN + "]";
	}




	   
	   
}
