package workerBoard.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import workerBoard.model.dao.WbDao;
import workerBoard.model.vo.WbBoard;

public class WbService {
	// 젠체목록 갯수 조회용
	public int getListCount() {
		Connection con = getConnection();
		int listCount = new WbDao().getlistcount(con);
		return listCount;
	}

	public ArrayList<WbBoard> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<WbBoard> list = new WbDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

	// 삭제
	public int deleteQna(int qnano) {
		Connection con = getConnection();
		int result = new WbDao().deleteWb(con, qnano);
		close(con);
		return result;
	}

	// 조회수
	public void addReadCount(int qnano) {
		Connection con = getConnection();
		int result = new WbDao().addReadCount(con, qnano);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);

		}
		close(con);
		return;
	}

	// 한줄골라오는거
	public WbBoard selectOne(int qnano) {
		Connection con = getConnection();
		WbBoard board = new WbDao().selectOne(con, qnano);
		close(con);
		return board;
	}

	// 삽입
	public int insertBoard(WbBoard board) {
		Connection con = getConnection();
		int result = new WbDao().insertBoad(con, board);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	// 수정
	public int updateQna(WbBoard board) {
		Connection con = getConnection();
		int result = new WbDao().updateBoard(con, board);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public void updateReplySeq(WbBoard reply) {
		Connection con = getConnection();
		int result = new WbDao().updateReplySeq(con, reply);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);

	}

	public int insertReply(WbBoard origin, WbBoard reply) {
		Connection con = getConnection();
		int result = new WbDao().insertReply(con, origin, reply);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	
	public ArrayList<WbBoard> selectMyList(String myId) {
		Connection con = getConnection();
		ArrayList<WbBoard> wmylist = new WbDao().selectMyList(con, myId);
		close(con);
		return wmylist;
	}


}
