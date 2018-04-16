package reviewBoard.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import reviewBoard.model.dao.ReviewBoardDao;
import reviewBoard.model.vo.ReviewBoard;
import reviewBoard.model.vo.ReviewComment;

public class ReviewBoardService {

	public ReviewBoardService() {
	}

	public int getListCount() {

		Connection con = getConnection();
		int listCount = new ReviewBoardDao().getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<ReviewBoard> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<ReviewBoard> list = new ReviewBoardDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

	public int deleteBoard(int boardNum) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().deleteBoard(con, boardNum);
		close(con);
		return result;
	}

	public void addReadCount(int boardNum) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().addReadCount(con, boardNum);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return;
	}

	public ReviewBoard selectOne(int boardNum) {
		Connection con = getConnection();
		ReviewBoard board = new ReviewBoardDao().selectOne(con, boardNum);
		close(con);
		return board;
	}

	public int insertBoard(ReviewBoard board) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().insertBoard(con, board);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int updateBoard(ReviewBoard board) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().updateBoard(con, board);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int insertComment(ReviewComment comment) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().insertComment(con, comment);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public ArrayList<ReviewComment> selectReplyList(int bnum) {
		Connection con = getConnection();
		ArrayList<ReviewComment> list = new ReviewBoardDao().selectReplyList(con, bnum);
		close(con);
		return list;
	}
	
	public int getReplyListCount(int bnum) {

		Connection con = getConnection();
		int listCount = new ReviewBoardDao().getReplyListCount(con,bnum);
		close(con);
		return listCount;
	}

	public int deleteReply(int cNum) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().deleteReply(con, cNum);
		close(con);
		return result;
	}

	public int updateReply(int cNum, String content) {
		Connection con = getConnection();
		int result = new ReviewBoardDao().updateReply(con, cNum , content);
		close(con);
		return result;
	}
	public ArrayList<ReviewBoard> selectMyList(String myId) {
		Connection con = getConnection();
		ArrayList<ReviewBoard> mylist = new ReviewBoardDao().selectMyList(con, myId);
		close(con);
		return mylist;
	}

	
}
