package likePlace.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import likePlace.model.dao.likePlaceDao;
import likePlace.model.vo.likePlace;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import vrBoard.model.dao.vrBoardDao;
import vrBoard.model.vo.vrBoard;

public class likePlaceService {

	public int likevrBoardCount(vrBoard board) {
		Connection conn = getConnection();
		int result = new likePlaceDao().likevrBoardCount(conn, board);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public int likevrBoard(String userId, int vrboardnum) {
		Connection conn = getConnection();
		int result = new likePlaceDao().likevrBoard(conn, userId, vrboardnum);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public int unlikevrBoard(String userId, int vrboardnum) {
		Connection conn = getConnection();
		int result = new likePlaceDao().unlikevrBoard(conn, userId, vrboardnum);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public int unlikevrBoardCount(vrBoard board) {
		Connection conn = getConnection();
		int result = new likePlaceDao().unlikevrBoardCount(conn, board);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public ArrayList<likePlace> selectList(String userId) {
		Connection conn = getConnection();
		ArrayList<likePlace> list = new likePlaceDao().selectList(conn, userId);
		close(conn);
		return list;
	}

	public ArrayList<likePlace> selectListUser(String userId) {
		Connection conn = getConnection();
		ArrayList<likePlace> list = new likePlaceDao().selectListUser(conn, userId);
		close(conn);
		return list;
	}

	public ArrayList<likePlace> selectLikeAll() {
		// likePlace 테이블 목록 전체 뽑아오기
		Connection conn = getConnection();
		ArrayList<likePlace> list = new likePlaceDao().selectLikeAll(conn);
		close(conn);
		return list;
	}

	public int likevrBoardCount(int vrboardnum) {
		// vrBoard 좋아요 증가
		Connection conn = getConnection();
		int result = new likePlaceDao().likevrBoardCount(conn, vrboardnum);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public int unLikevrBoard(String userId, int vrboardnum) {
		// vrBoard 좋아요 취소
		Connection conn = getConnection();
		int result = new likePlaceDao().unLikevrBoard(conn, userId, vrboardnum);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public int unLikevrBoardCount(int vrboardnum) {
		// vrBoard 좋아요 감소
		Connection conn = getConnection();
		int result = new likePlaceDao().unLikevrBoardCount(conn, vrboardnum);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public ArrayList<likePlace> selectHotelUser(String userId) {
		Connection conn = getConnection();
		ArrayList<likePlace> list = new likePlaceDao().selectHotelUser(conn, userId);
		close(conn);
		return list;
	}

	public ArrayList<likePlace> selectResUser(String userId) {
		Connection conn = getConnection();
		ArrayList<likePlace> list = new likePlaceDao().selectResUser(conn, userId);
		close(conn);
		return list;
	}

	public ArrayList<likePlace> selectPlaceUser(String userId) {
		Connection conn = getConnection();
		ArrayList<likePlace> list = new likePlaceDao().selectPlaceUser(conn, userId);
		close(conn);
		return list;
	}

}
