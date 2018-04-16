package notice.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import notice.model.dao.*;
import notice.model.vo.*;

public class NoticeDao {
	public NoticeDao() {}

	public ArrayList<Notice> selectList(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Notice> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Notice> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="SELECT * FROM ("
				+ "SELECT ROWNUM RNUM,N_NUM,N_TITLE,N_WRITER,"
				+ "N_ORIGINAL_FILENAME,N_CONTENT,N_DATE,N_READCOUNT,"
				+ "N_RENAME_FILENAME FROM (SELECT * FROM NOTICE_ADMIN "
				+ "ORDER BY N_NUM DESC)) "
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNum(rset.getInt("n_num"));
				n.setNoticeTitle(rset.getString("n_title"));
				n.setNoticeWriter(rset.getString("n_writer"));
				n.setNoticeOriginalFilename(rset.getString("n_original_filename"));
				n.setNoticeContent(rset.getString("n_content"));
				n.setNoticeDate(rset.getDate("n_date"));
				n.setNoticeReadCount(rset.getInt("n_readcount"));
				n.setNoticeRenameFilename(rset.getString("n_rename_filename"));
			
				list.add(n);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		
		}
		
		return list;		
	}

	

	public int insertNotice(Connection con, Notice notice) {
		int result = 0;
		PreparedStatement pstmt= null;
		String query="insert into notice_admin values("
				+ "(select max(n_num)+1 from notice_admin), "
				+ "?,?,?,?,sysdate,default,?)";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2,notice.getNoticeWriter());
			pstmt.setString(3, notice.getNoticeOriginalFilename());
			pstmt.setString(4, notice.getNoticeContent());
			pstmt.setString(5, notice.getNoticeRenameFilename());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateNotice(Connection con, Notice notice) {
		int result = 0;
		PreparedStatement pstmt=null;
		String query="update notice_admin set "
				+ "n_title = ?,n_content=?,n_original_filename = ? ,n_rename_filename = ? "
				+ " where n_num = ?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeOriginalFilename());
			pstmt.setString(4, notice.getNoticeRenameFilename());
			pstmt.setInt(5, notice.getNoticeNum());
			
			result=pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection con, int no) {
		int result = 0;
		PreparedStatement pstmt=null;
		String query="delete from notice_admin where n_num = ? ";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notice> selectSearchTitle(Connection con, String title) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice_admin where n_title like ?"
				+ " order by n_num desc";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, '%'+title+'%');
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("n_num"),rset.getString("n_title"),
						rset.getString("n_writer"),rset.getDate("n_date"),rset.getString("n_original_filename"),
						rset.getString("n_content"),rset.getString("n_rename_filename"),rset.getInt("n_readcount")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from notice_admin";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public int addReadCount(Connection con, int noticeNum) {
		int result = 0;
		PreparedStatement pstmt=null;
		String query="update notice_admin set n_readcount=n_readcount+1"
				+ " where n_num = ?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	public Notice selectOne(Connection con, int noticeNum) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice_admin where n_num = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
			notice = new Notice();
			
			notice.setNoticeNum(rset.getInt("n_num"));
			notice.setNoticeTitle(rset.getString("n_title"));
			notice.setNoticeWriter(rset.getString("n_writer"));
			notice.setNoticeContent(rset.getString("n_content"));
			notice.setNoticeDate(rset.getDate("n_date"));
			notice.setNoticeOriginalFilename(rset.getString("n_original_filename"));
			notice.setNoticeRenameFilename(rset.getString("n_rename_filename"));
			notice.setNoticeReadCount(rset.getInt("n_readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	

	public Notice selectPrev(Connection con, int prevNum) {
		Notice pnotice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice_admin "
				+ "where n_num in (select max(n_num) "
				+ "from notice_admin "
				+ "where n_num < ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, prevNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
			pnotice = new Notice();
			pnotice.setNoticeNum(rset.getInt("n_num"));
			pnotice.setNoticeTitle(rset.getString("n_title"));
			pnotice.setNoticeWriter(rset.getString("n_writer"));
			pnotice.setNoticeContent(rset.getString("n_content"));
			pnotice.setNoticeDate(rset.getDate("n_date"));
			pnotice.setNoticeOriginalFilename(rset.getString("n_original_filename"));
			pnotice.setNoticeRenameFilename(rset.getString("n_rename_filename"));
			pnotice.setNoticeReadCount(rset.getInt("n_readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pnotice;
	}

	public Notice selectNext(Connection con, int nextNum) {
		Notice nnotice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice_admin "
				+ "where n_num in (select min(n_num) "
				+ "from notice_admin "
				+ "where n_num > ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nextNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
			nnotice = new Notice();
			
			nnotice.setNoticeNum(rset.getInt("n_num"));
			nnotice.setNoticeTitle(rset.getString("n_title"));
			nnotice.setNoticeWriter(rset.getString("n_writer"));
			nnotice.setNoticeContent(rset.getString("n_content"));
			nnotice.setNoticeDate(rset.getDate("n_date"));
			nnotice.setNoticeOriginalFilename(rset.getString("n_original_filename"));
			nnotice.setNoticeRenameFilename(rset.getString("n_rename_filename"));
			nnotice.setNoticeReadCount(rset.getInt("n_readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return nnotice;
	}
	
	
}
