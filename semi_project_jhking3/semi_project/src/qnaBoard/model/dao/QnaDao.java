package qnaBoard.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import qnaBoard.model.vo.QnaBoard;
import reviewBoard.model.vo.ReviewBoard;
public class QnaDao {

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from qna";
		
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

	public int deleteQna(Connection con, int qnano) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = "delete from qna where qna_no = ?";
		
			
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
	

	public int addReadCount(Connection con, int qnano) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = "update qna set QNA_READCOUNT = QNA_READCOUNT + 1 where QNA_NO = ?";
		
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

	public QnaBoard selectOne(Connection con, int qnano) {
	//  글번호에 대한 게시글 정보 조회용
				QnaBoard qboard  = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String query = "select * from qna where QNA_NO = ?";
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, qnano);
					
					rset=pstmt.executeQuery();
					
					if(rset.next()) {
						qboard = new QnaBoard();
						
						qboard.setQnano(rset.getInt("QNA_NO"));
						qboard.setTitle(rset.getString("QNA_TITLE"));
						qboard.setQnawriter(rset.getString("QNA_WRITER"));
						qboard.setContent(rset.getString("QNA_CONTENT"));
						qboard.setQnaoriginalfilename(rset.getString("QNA_ORIGINAL_FILENAME"));
						qboard.setRename(rset.getString("QNA_RENAME"));
						qboard.setQnadate(rset.getDate("QNA_DATE"));
						qboard.setQnareadcount(rset.getInt("QNA_READCOUNT"));
						qboard.setQnalevel(rset.getInt("QNA_LEVEL"));
						qboard.setQnaref(rset.getInt("QNA_REF"));
						qboard.setQnareplyref(rset.getInt("QNA_REPLY_REF"));
						qboard.setQnareplyseq(rset.getInt("QNA_REPLY_SEQ"));
						
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
				return qboard;
	}

	public int insertBoad(Connection con, QnaBoard board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into qna values(default, "
				+ "  (select max(qna_no) + 1  from qna), ?, ?, ?, sysdate, ?,?, default, default,(select max(qna_no) + 1  from qna), default, default)";
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(2, board.getQnawriter());
			
			pstmt.setString(4, board.getQnaoriginalfilename());
			pstmt.setString(5, board.getRename());
			
			
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection con, QnaBoard board) {
	      int result =0;
	         PreparedStatement pstmt = null;
	         
	         String query = "update qna set"
	               + " QNA_TITLE = ?, QNA_CONTENT = ?, QNA_ORIGINAL_FILENAME = ?, QNA_RENAME = ? "
	               + " where QNA_NO = ?";
	         try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, board.getTitle());
	            pstmt.setString(2, board.getContent());
	            pstmt.setString(3, board.getQnaoriginalfilename());
	            pstmt.setString(4, board.getRename());
	            pstmt.setInt(5, board.getQnano());
	         
	            result = pstmt.executeUpdate();
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }finally {
	            close(pstmt);
	         }
	         
	         return result;
	}

	public ArrayList<QnaBoard> selectList(Connection con, int currentPage, int limit) {
		ArrayList<QnaBoard> list = new ArrayList<QnaBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		 String query = "SELECT * " + 
		            "FROM (SELECT ROWNUM RNUM, QNA_NO, QNA_TITLE, QNA_WRITER, " + 
		            "QNA_CONTENT, QNA_ORIGINAL_FILENAME, QNA_RENAME, " + 
		            "QNA_DATE, QNA_READCOUNT, QNA_LEVEL, QNA_REF, QNA_REPLY_REF,QNA_REPLY_SEQ " + 
		            "FROM (SELECT * FROM qna " + 
		            "ORDER BY QNA_REF desc ,  QNA_LEVEL asc,QNA_REPLY_REF DESC, " + 
		            " QNA_REPLY_SEQ ASC)) " + 
		            "WHERE RNUM BETWEEN ? AND ?";
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					QnaBoard b = new QnaBoard();
					b.setQnano(rset.getInt("QNA_NO"));
					b.setTitle(rset.getString("QNA_TITLE"));
					b.setQnawriter(rset.getString("QNA_WRITER"));
					b.setContent(rset.getString("QNA_CONTENT"));
					b.setQnaoriginalfilename(rset.getString("QNA_ORIGINAL_FILENAME"));
					b.setRename(rset.getString("QNA_RENAME"));
					b.setQnadate(rset.getDate("QNA_DATE"));
					b.setQnareadcount(rset.getInt("QNA_READCOUNT"));
					b.setQnalevel(rset.getInt("QNA_LEVEL"));
					b.setQnaref(rset.getInt("QNA_REF"));
					b.setQnareplyref(rset.getInt("QNA_REPLY_REF"));
					b.setQnareplyseq(rset.getInt("QNA_REPLY_SEQ"));
					
					
					
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

	public int updateReplySeq(Connection con, QnaBoard reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update qna set "
				+ "QNA_REPLY_SEQ = "
				+ "QNA_REPLY_SEQ + 1 "
				+ "where QNA_REF = ? and "
				+ "QNA_LEVEL = ? "
				+ "and QNA_REPLY_REF = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reply.getQnaref());
			pstmt.setInt(2, reply.getQnalevel());
			pstmt.setInt(3, reply.getQnareplyref());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReply(Connection con, QnaBoard origin, QnaBoard reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		if(reply.getQnalevel() == 1) {
			query = "insert into qna values (default, "
					+ "(select  max(QNA_NO) + 1 from qna), "
					+ "?, ?, ?,sysdate, NULL, NULL,default,  ?, ?, "
					+ "(select max(QNA_NO) +1 from qna), "
					+ "1 )";
		}
		
		if(reply.getQnalevel() == 2) {
			query = "insert into qna values (default,"
				+ "(select max(QNA_NO) + 1 from qna), "
				+ "?, ?, ?,sysdate, NULL, NULL, default, ?, ?, "
				+ "?, 1)";
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reply.getTitle());
			pstmt.setString(2, reply.getContent());
			pstmt.setString(3, reply.getQnawriter());
		
			pstmt.setInt(4, reply.getQnalevel());
			pstmt.setInt(5, origin.getQnaref());
			
			if(reply.getQnalevel() == 2)
				pstmt.setInt(6, reply.getQnareplyref());
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnaBoard> selectMyList(Connection con, String qmyId) {
		ArrayList<QnaBoard> list = new ArrayList<QnaBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from qna where qna_writer = ?";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, qmyId);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					QnaBoard b = new QnaBoard();
					b.setQnano(rset.getInt("QNA_NO"));
					b.setTitle(rset.getString("QNA_TITLE"));
					b.setQnawriter(rset.getString("QNA_WRITER"));
					b.setContent(rset.getString("QNA_CONTENT"));
					b.setQnaoriginalfilename(rset.getString("QNA_ORIGINAL_FILENAME"));
					b.setRename(rset.getString("QNA_RENAME"));
					b.setQnadate(rset.getDate("QNA_DATE"));
					b.setQnareadcount(rset.getInt("QNA_READCOUNT"));
					b.setQnalevel(rset.getInt("QNA_LEVEL"));
					b.setQnaref(rset.getInt("QNA_REF"));
					b.setQnareplyref(rset.getInt("QNA_REPLY_REF"));
					b.setQnareplyseq(rset.getInt("QNA_REPLY_SEQ"));
				
					list.add(b);
					
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
