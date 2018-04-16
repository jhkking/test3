package workerBoard.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import qnaBoard.model.vo.QnaBoard;
import workerBoard.model.vo.WbBoard;

public class WbDao {

	public int getlistcount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from worker_board";
		
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

	public ArrayList<WbBoard> selectList(Connection con, int currentPage, int limit) {
		ArrayList<WbBoard> list = new ArrayList<WbBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		 String query = "SELECT * " + 
		            "FROM (SELECT ROWNUM RNUM, WB_NO, WB_TITLE,WB_CONTENT, WB_WRITER, " + 
		            "WB_DATE, WB_ORIGINAL_FILENAME, WB_RENAME, " + 
		            "WB_READCOUNT, WB_LEVEL, WB_REF, WB_REPLY_REF,WB_REPLY_SEQ " + 
		            "FROM (SELECT * FROM Worker_board " + 
		            "ORDER BY WB_REF desc ,  WB_LEVEL asc,WB_REPLY_REF DESC, " + 
		            " WB_REPLY_SEQ ASC)) " + 
		            "WHERE RNUM BETWEEN ? AND ?";
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					WbBoard b = new WbBoard();
					b.setWbnumber(rset.getInt("WB_NO"));
					b.setWbtitle(rset.getString("WB_TITLE"));
					
					b.setWbcontent(rset.getString("WB_CONTENT"));
					b.setWbwriter(rset.getString("WB_WRITER"));
					b.setWbdate(rset.getDate("WB_DATE"));
					b.setWboriginalfilename(rset.getString("WB_ORIGINAL_FILENAME"));
					b.setRename(rset.getString("WB_RENAME"));
				
					b.setWb_readcount(rset.getInt("WB_READCOUNT"));
					b.setWblevel(rset.getInt("WB_LEVEL"));
					b.setWbref(rset.getInt("WB_REF"));
					b.setWbreplyref(rset.getInt("WB_REPLY_REF"));
					b.setWbreplyseq(rset.getInt("WB_REPLY_SEQ"));
					
					
					
					list.add(b);
					//System.out.println(b);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
	}


	public int addReadCount(Connection con, int qnano) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = "update Worker_board set WB_READCOUNT = WB_READCOUNT + 1 where WB_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnano);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public WbBoard selectOne(Connection con, int qnano) {
		WbBoard qboard  = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from Worker_board where WB_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnano);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				qboard = new WbBoard();
				
				qboard.setWbnumber(rset.getInt("WB_NO"));
				qboard.setWbtitle(rset.getString("WB_TITLE"));
				qboard.setWbcontent(rset.getString("WB_CONTENT"));
				qboard.setWbwriter(rset.getString("WB_WRITER"));
				qboard.setWbdate(rset.getDate("WB_DATE"));
				qboard.setWboriginalfilename(rset.getString("WB_ORIGINAL_FILENAME"));
				qboard.setRename(rset.getString("WB_RENAME"));
				
				qboard.setWb_readcount(rset.getInt("WB_READCOUNT"));
				qboard.setWblevel(rset.getInt("WB_LEVEL"));
				qboard.setWbref(rset.getInt("WB_REF"));
				qboard.setWbreplyref(rset.getInt("WB_REPLY_REF"));
				qboard.setWbreplyseq(rset.getInt("WB_REPLY_SEQ"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return qboard;
	}

	public int insertBoad(Connection con, WbBoard board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Worker_board values("
				+ "  (select max(WB_NO) + 1  from Worker_board), ?, ?, ?, sysdate, ?,?, default, default,(select max(WB_NO) + 1  from Worker_board), default, default)";
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, board.getWbtitle());
			pstmt.setString(3, board.getWbcontent());
			pstmt.setString(2, board.getWbwriter());
			
			pstmt.setString(4, board.getWboriginalfilename());
			pstmt.setString(5, board.getRename());
			
			
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection con, WbBoard board) {
		int result =0;
        PreparedStatement pstmt = null;
        
        String query = "update Worker_board set"
              + " WB_TITLE = ?, WB_CONTENT = ?, WB_ORIGINAL_FILENAME = ?, WB_RENAME = ? "
              + " where WB_NO = ?";
        try {
           pstmt = con.prepareStatement(query);
           pstmt.setString(1, board.getWbtitle());
           pstmt.setString(2, board.getWbcontent());
           pstmt.setString(3, board.getWboriginalfilename());
           pstmt.setString(4, board.getRename());
           pstmt.setInt(5, board.getWbnumber());
          
        
           result = pstmt.executeUpdate();
           
        } catch (Exception e) {
           e.printStackTrace();
        }finally {
           close(pstmt);
        }
        
        return result;
	}

	public int updateReplySeq(Connection con, WbBoard reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Worker_board set "
				+ "WB_REPLY_SEQ = "
				+ "WB_REPLY_SEQ + 1 "
				+ "where WB_REF = ? and "
				+ "WB_LEVEL = ? "
				+ "and WB_REPLY_REF = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reply.getWbref());
			pstmt.setInt(2, reply.getWblevel());
			pstmt.setInt(3, reply.getWbreplyref());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReply(Connection con, WbBoard origin, WbBoard reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		if(reply.getWblevel() == 1) {
			query = "insert into Worker_board values ("
					+ "(select  max(WB_NO) + 1 from Worker_board), "
					+ "?, ?, ?,sysdate, NULL, NULL,default,  ?, ?, "
					+ "(select max(WB_NO) +1 from Worker_board), "
					+ "1 )";
		}
		
		if(reply.getWblevel() == 2) {
			query = "insert into Worker_board values ("
				+ "(select max(WB_NO) + 1 from Worker_board), "
				+ "?, ?, ?,sysdate, NULL, NULL, default, ?, ?, "
				+ "?, 1)";
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reply.getWbtitle());
			pstmt.setString(2, reply.getWbcontent());
			pstmt.setString(3, reply.getWbwriter());
		
			pstmt.setInt(4, reply.getWblevel());
			pstmt.setInt(5, origin.getWbref());
			
			if(reply.getWblevel() == 2)
				pstmt.setInt(6, reply.getWbreplyref());
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteWb(Connection con, int qnano) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from worker_board where WB_NO = ?";
	
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnano);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	
			close(pstmt);
		}
		
		return result;
	}
	public ArrayList<WbBoard> selectMyList(Connection con, String myId) {
		ArrayList<WbBoard> list = new ArrayList<WbBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		 String query = "select * from worker_board where wb_writer = ?"
		 		+ "order by wb_no asc";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, myId);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					WbBoard w = new WbBoard();
					w.setWbnumber(rset.getInt("WB_NO"));
					w.setWbtitle(rset.getString("WB_TITLE"));
					
					w.setWbcontent(rset.getString("WB_CONTENT"));
					w.setWbwriter(rset.getString("WB_WRITER"));
					w.setWbdate(rset.getDate("WB_DATE"));
					w.setWboriginalfilename(rset.getString("WB_ORIGINAL_FILENAME"));
					w.setRename(rset.getString("WB_RENAME"));
				
					w.setWb_readcount(rset.getInt("WB_READCOUNT"));
					w.setWblevel(rset.getInt("WB_LEVEL"));
					w.setWbref(rset.getInt("WB_REF"));
					w.setWbreplyref(rset.getInt("WB_REPLY_REF"));
					w.setWbreplyseq(rset.getInt("WB_REPLY_SEQ"));
					
					list.add(w);
					//System.out.println(b);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
	}

}
