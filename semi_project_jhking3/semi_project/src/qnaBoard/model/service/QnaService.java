package qnaBoard.model.service;
import static common.JDBCTemplate.*;


import java.sql.*;
import java.util.*;

import qnaBoard.model.dao.QnaDao;
import qnaBoard.model.vo.QnaBoard;
import reviewBoard.model.dao.ReviewBoardDao;
import reviewBoard.model.vo.ReviewBoard;
public class QnaService {
	public QnaService() {}

	//젠체목록 갯수 조회용
	public int getListCount() {
		Connection con = getConnection();
		int listCount = new QnaDao().getListCount(con);
		return listCount;
	}
	
	public ArrayList<QnaBoard> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<QnaBoard> list = new QnaDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}
	//삭제
	public int deleteQna(int qnano) {
		Connection con = getConnection();
		int result = new QnaDao().deleteQna(con,qnano);
		close(con);
		return result;
	}
	//조회수
	public void addReadCount(int qnano) {
		Connection con = getConnection();
		int result = new QnaDao().addReadCount(con,qnano);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
			
		}
		close(con);
		return;
	}
	//한줄골라오는거
	public QnaBoard selectOne(int qnano) {
		Connection con=getConnection();
		QnaBoard board = new QnaDao().selectOne(con,qnano);
		close(con);
		return board;
	}
	//삽입
	public int insertBoard(QnaBoard board) {
		Connection con = getConnection();
		int result =new QnaDao().insertBoad(con,board);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}
	//수정
	public int updateQna(QnaBoard board) {
		Connection con = getConnection();
		int result = new QnaDao().updateBoard(con, board);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public void updateReplySeq(QnaBoard reply) {
		Connection con = getConnection();
		int result = new QnaDao().updateReplySeq(con, reply);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		
	}

	public int insertReply(QnaBoard origin, QnaBoard reply) {
		Connection con = getConnection();
		int result = new QnaDao().insertReply(con, origin, reply);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}



	public ArrayList<QnaBoard> selectMyList(String myId) {
		Connection con = getConnection();
		ArrayList<QnaBoard> qmylist = new QnaDao().selectMyList(con, myId);
		close(con);
		return qmylist;
	}
	
	
}
