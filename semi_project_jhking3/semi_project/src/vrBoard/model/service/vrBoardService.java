package vrBoard.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import vrBoard.model.dao.vrBoardDao;
import vrBoard.model.vo.DetailComment;
import vrBoard.model.vo.Maplocation;
import vrBoard.model.vo.VrBoardDetail;
import vrBoard.model.vo.vrBoard;

public class vrBoardService {

	public vrBoardService() {
	}

	public vrBoard selectOne(int bnum) {
		// 글번호에 대한 게시글 정보 조회용
		Connection con = getConnection();
		vrBoard board = new vrBoardDao().selectOne(con, bnum);
		close(con);
		return board;
	};

	public vrBoard selectList(String title) {
		// 글번호에 대한 게시글 정보 조회용
		Connection con = getConnection();
		vrBoard board = new vrBoardDao().selectList(con, title);
		close(con);
		return board;
	}

	public ArrayList<vrBoard> selectList(int currentPage, int limit) {
		// 글번호에 대한 게시글 정보 조회용
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

	public int getListCount(String placeName) {
		Connection con = getConnection();
		int listCount = new vrBoardDao().getListCount(con, placeName);
		close(con);
		return listCount;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new vrBoardDao().getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<vrBoard> selectListAll() {
		// 전체 리스트
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().selectListAll(con);
		close(con);
		return list;
	}

	public Maplocation selectLocation(int vrboardnum) {
		Connection con = getConnection();
		Maplocation maplo = new vrBoardDao().selectListAll(con, vrboardnum);
		close(con);
		return maplo;
	}

	public ArrayList<vrBoard> searchLikePlace(String userid) {
		Connection con = getConnection();
		ArrayList<vrBoard> likeBoard = new vrBoardDao().searchLikePlace(con, userid);
		close(con);
		return likeBoard;
	}

	public int addReadCount(int vrboardnum) {
		Connection con = getConnection();
		int result = new vrBoardDao().addReadCount(con, vrboardnum);
		close(con);
		return result;
	}

	public VrBoardDetail selectDetail(int vrboardnum) {
		Connection con = getConnection();
		VrBoardDetail vbd = new vrBoardDao().selectDetail(con, vrboardnum);
		close(con);
		return vbd;
	}

	public ArrayList<vrBoard> PlaceList() {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().PlaceList(con);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> HotelList() {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().HotelList(con);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> ResList() {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().ResList(con);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> PlaceList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().PlaceList(con, currentPage, limit);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> ResList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().ResList(con, currentPage, limit);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> HotelList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().HotelList(con, currentPage, limit);
		close(con);
		return list;
	}

	public vrBoard selectTopLikeCount() {
		Connection con = getConnection();
		vrBoard board = new vrBoardDao().selectTopLikeCount(con);
		close(con);
		return board;
	}

	public ArrayList<vrBoard> searchList(int currentPage, int sclimit, String keyword, String searchoption) {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().searchList(con, sclimit, currentPage, keyword, searchoption);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> selectPlaceList() {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().selectPlaceList(con);
		close(con);
		return list;
	}

	public ArrayList<vrBoard> selectResBoard(String placeName) {
		//vrBoardSelect에 편의시설
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().selectResBoard(con,placeName);
		close(con);
		return list;
	}

	public ArrayList<VrBoardDetail> selectResBoardDetail(String placeName) {
		//vrBoardSelect에 모달 창 detail
		Connection con = getConnection();
		ArrayList<VrBoardDetail> list = new vrBoardDao().selectResBoardDetail(con,placeName);
		close(con);
		return list;
	}
	public int addvrdetail(int boardnum, String address, String opentime, String phone, String homepageadd) {
		Connection con = getConnection();
		int listCount = new vrBoardDao().addvrdetail(boardnum, address, opentime, phone, homepageadd, con);
		return listCount;
	}

	public int addvrBoard(String vrcode, String title, String writer, String address, String img) {
	      Connection con = getConnection();
	      int listCount = new vrBoardDao().addvrBoard(vrcode, title, writer, address, img ,con);
	      return listCount;
	   }
	public ArrayList<vrBoard> getvrBoard(String title) {
	      Connection con = getConnection();
	      ArrayList<vrBoard> list = new vrBoardDao().getvrBoard(con, title);
	      close(con);
	      return list;
	   }
	public int insertComment(DetailComment comment) {
		Connection con = getConnection();
		int result = new vrBoardDao().insertComment(con, comment);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
   
	public ArrayList<DetailComment> selectReplyList(int bnum) {
		Connection con = getConnection();
		ArrayList<DetailComment> list = new vrBoardDao().selectReplyList(con, bnum);
		close(con);
		return list;
	}
	public int deleteReply(int cnum) {
		Connection con = getConnection();
		int result = new vrBoardDao().deleteReply(con, cnum);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public ArrayList<DetailComment> selectReplyList() {
		Connection con = getConnection();
		ArrayList<DetailComment> list = new vrBoardDao().selectReplyList(con);
		close(con);
		return list;
	}
	
	public vrBoard VrBoardModify(int boardnum) {
		Connection con = getConnection();
		vrBoard board = new vrBoardDao().VrBoardModify(con, boardnum);
		close(con);
		return board;
	}
	public int updatevrBoard(int boardnum, String vrcode, String title, String writer, String address, String img) {
		Connection con = getConnection();
		int listCount = new vrBoardDao().updatevrBoard(boardnum, vrcode, title, writer, address, img, con);
		return listCount;
	}
	public int updatevrDetail(int boardnum, String address, String opentime, String phone, String homepageadd) {
		Connection con = getConnection();
		int listCount = new vrBoardDao().updatevrDetail(boardnum, address, opentime, phone, homepageadd, con);
		return listCount;
	}
	public ArrayList<vrBoard> selectListnum(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<vrBoard> list = new vrBoardDao().selectListnum(con, currentPage, limit);
		close(con);
		return list;
	}

	public VrBoardDetail detailselectOne(int num) {
		Connection con = getConnection();
		VrBoardDetail vrBoardDetail = new vrBoardDao().detailselectOne(con, num);
		close(con);
		return vrBoardDetail;
	}
	public VrBoardDetail VrDetailModify(int boardnum) {
		Connection con = getConnection();
		VrBoardDetail detail = new vrBoardDao().VrDetailModify(con, boardnum);
		close(con);
		return detail;
	}

	
	public int VrBoardDelete(int boardnum) {
		Connection con = getConnection();
		int listCount = new vrBoardDao().VrBoardDelete(boardnum, con);
		return listCount;
	}
	
	public int vrBoardDelete2(int boardnum) {
		Connection con = getConnection();
		int listCount = new vrBoardDao().vrBoardDelete2(boardnum, con);
		return listCount;
	}

	public ArrayList<VrBoardDetail> DetailList() {
		Connection con = getConnection();
		ArrayList<VrBoardDetail> list = new vrBoardDao().DetailList(con);
		close(con);
		return list;
	}

	public ArrayList<Maplocation> MapList() {
		Connection con = getConnection();
		ArrayList<Maplocation> list = new vrBoardDao().MapList(con);
		close(con);
		return list;
	}

	public ArrayList<Maplocation> BestMapList() {
		Connection con = getConnection();
		ArrayList<Maplocation> list = new vrBoardDao().BestMapList(con);
		close(con);
		return list;
	}

	public int getPlaceListCount() {
		Connection con = getConnection();
		int listCount = new vrBoardDao().getPlaceListCount(con);
		return listCount;
	}
	

	   public int getHotelListCount() {
	      Connection con = getConnection();
	      int listCount = new vrBoardDao().getHotelListCount(con);
	      return listCount;
	   }

	   public int getResListCount() {
	      Connection con = getConnection();
	      int listCount = new vrBoardDao().getResListCount(con);
	      return listCount;
	   }
	   
	   public ArrayList<vrBoard> selectMyList(String myId) {
			Connection con = getConnection();
			ArrayList<vrBoard> vmylist = new vrBoardDao().selectMyList(con, myId);
			close(con);
			return vmylist;
		}

	public ArrayList<VrBoardDetail> selectDetailRes() {
		Connection con = getConnection();
		ArrayList<VrBoardDetail> listD = new vrBoardDao().selectDetailRes(con);
		close(con);
		return listD;
	}

	public ArrayList<VrBoardDetail> selectDetailHotel() {
		Connection con = getConnection();
		ArrayList<VrBoardDetail> listD = new vrBoardDao().selectDetailHotel(con);
		close(con);
		return listD;
	}
}
