package notice.model.service;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;


public class NoticeService {
	public NoticeService() 	{}
	
	//전체 조회용
	public ArrayList<Notice> selectList(){
		Connection con=getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(con);
		close(con);
		
		return list;
	}
	public ArrayList<Notice> selectList(int currentPage,int limit){
		Connection con=getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(con,currentPage,limit);
		close(con);
		
		return list;
	}
	
	//글 번호로 조회
	public Notice selectOne(int noticeNum) {
		Connection con = getConnection();
		Notice notice =new NoticeDao().selectOne(con, noticeNum);
		close(con);
		return notice;
	}
	
	//글 작성용 메소드
		public int insertNotice(Notice notice) {
			Connection con =getConnection();
			int result = new NoticeDao().insertNotice(con,notice);
			
			if(result>0)
				commit(con);
			else
				rollback(con);
			close(con);
			
			return result;
		}
		
		public int updateNotice(Notice notice) {
			Connection con=getConnection();
			int result = new NoticeDao().updateNotice(con,notice);
			
			if(result>0) {
				commit(con);
			}else {
				rollback(con);
			}
			close(con);
			
			return result;
		}
		//게시글 삭제용
		public int deleteNotice(int no) {
			Connection con = getConnection();
			int result = new NoticeDao().deleteNotice(con,no);
			
			if(result>0) {
				commit(con);
			}else {
				rollback(con);
			}
			
			close(con);
			
			return result;
		}
		
		//공지사항 제목으로 검색
		public ArrayList<Notice> selectSearchTitle(String title){
			Connection con = getConnection();
			ArrayList<Notice> list =new NoticeDao().selectSearchTitle(con,title);
			close(con);
			return list;
		}

		public int getListCount() {
			Connection con=getConnection();
			int listCount=new NoticeDao().getListCount(con);
			close(con);
			return listCount;
		}

		public void addReadCount(int noticeNum) {
			Connection con =getConnection();
			int result = new NoticeDao().addReadCount(con,noticeNum);
			if(result>0)
				commit(con);
			else
				rollback(con);
			close(con);
			return;
		}

		public ArrayList<Notice> selelctSearchTitle(String title) {
			Connection con = getConnection();
			ArrayList<Notice> list = new NoticeDao().selectSearchTitle(con, title);
			close(con);
			return list;
		}

		

		public Notice selectPrev(int prevNum) {
			Connection con = getConnection();
			Notice pnotice =new NoticeDao().selectPrev(con, prevNum);
			close(con);
			return pnotice;
		}
	
		public Notice selectNext(int nextNum) {
			Connection con = getConnection();
			Notice nnotice =new NoticeDao().selectNext(con, nextNum);
			close(con);
			return nnotice;
		}
		
}
