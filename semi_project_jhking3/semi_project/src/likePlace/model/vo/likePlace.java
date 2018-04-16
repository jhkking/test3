package likePlace.model.vo;

public class likePlace implements java.io.Serializable {

	private static final long serialVersionUID = 4L;
	
	private String likeUser;
	private int likePlaceNum;
	
	public likePlace() {}
	

	public likePlace(String likeUser, int likePlaceNum) {
		super();
		this.likeUser = likeUser;
		this.likePlaceNum = likePlaceNum;
	}

	public String getLikeUser() {
		return likeUser;
	}

	public void setLikeUser(String likeUser) {
		this.likeUser = likeUser;
	}

	public int getLikePlaceNum() {
		return likePlaceNum;
	}

	public void setLikePlaceNum(int likePlaceNum) {
		this.likePlaceNum = likePlaceNum;
	}


	@Override
	public String toString() {
		return "likePlace [likeUser=" + likeUser + ", likePlaceNum=" + likePlaceNum + "]";
	}
	
	
}
