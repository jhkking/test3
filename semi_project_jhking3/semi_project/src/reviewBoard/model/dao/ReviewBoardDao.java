/**
 * 
 */
package reviewBoard.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import reviewBoard.model.vo.ReviewBoard;
import reviewBoard.model.vo.ReviewComment;

/**
 * @author daye
 *
 */
public class ReviewBoardDao {
	
	public ReviewBoardDao() {}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from review_board";
		
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

	public ArrayList<ReviewBoard> selectList(Connection con, int currentPage, int limit) {
		ArrayList<ReviewBoard> list = new ArrayList<ReviewBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, review_NUM, review_TITLE, review_WRITER, " + 
				"review_CONTENT, review_ORIGINAL_FILENAME, review_RE_FILENAME, " + 
				"review_DATE, review_readcount, review_level, review_ref, review_reply_ref,review_reply_turn " + 
				"FROM (SELECT * FROM review_board " + 
				"ORDER BY review_REF DESC, review_REPLY_REF DESC, " + 
				"review_LEVEL ASC, review_REPLY_turn ASC,review_NUM desc)) " + 
				"WHERE RNUM BETWEEN ? AND ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReviewBoard rboard = new ReviewBoard();
				
				rboard.setReviewNum(rset.getInt("REVIEW_NUM"));
				rboard.setReviewTitle(rset.getString("REVIEW_TITLE"));
				rboard.setReviewWriter(rset.getString("REVIEW_WRITER"));
				rboard.setReviewContent(rset.getString("REVIEW_CONTENT"));
				rboard.setReviewOriginalFilename(rset.getString("REVIEW_ORIGINAL_FILENAME"));
				rboard.setReviewReFilename(rset.getString("REVIEW_RE_FILENAME"));
				rboard.setReviewDate(rset.getDate("REVIEW_DATE"));
				rboard.setReviewReadcount(rset.getInt("REVIEW_READCOUNT"));
				rboard.setReviewLevel(rset.getInt("REVIEW_LEVEL"));
				rboard.setReviewRef(rset.getInt("REVIEW_REF"));
				rboard.setReviewReplyRef(rset.getInt("REVIEW_REPLY_REF"));
				rboard.setReviewReplyTurn(rset.getInt("REVIEW_REPLY_TURN"));
				
				list.add(rboard);
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

	public int deleteBoard(Connection con, int boardNum) {
		ReviewBoard rboard = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from review_board where review_num = ?";
	
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	
			close(pstmt);
		}
		
		return result;
	}

	public int addReadCount(Connection con, int boardNum) {
		// 조회수 1증가 처리용
				int result =0;
				PreparedStatement pstmt = null;
				String query = "update review_board set review_readcount = review_readcount + 1 where review_num = ?";
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, boardNum);
					
					result = pstmt.executeUpdate();
					
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
				return result;
	}

	public ReviewBoard selectOne(Connection con, int boardNum) {
	//  글번호에 대한 게시글 정보 조회용
			ReviewBoard rboard  = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from review_board where REVIEW_NUM = ?";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, boardNum);
				
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					rboard = new ReviewBoard();
					
					rboard.setReviewNum(rset.getInt("REVIEW_NUM"));
					rboard.setReviewTitle(rset.getString("REVIEW_TITLE"));
					rboard.setReviewWriter(rset.getString("REVIEW_WRITER"));
					rboard.setReviewContent(rset.getString("REVIEW_CONTENT"));
					rboard.setReviewOriginalFilename(rset.getString("REVIEW_ORIGINAL_FILENAME"));
					rboard.setReviewReFilename(rset.getString("REVIEW_RE_FILENAME"));
					rboard.setReviewDate(rset.getDate("REVIEW_DATE"));
					rboard.setReviewReadcount(rset.getInt("REVIEW_READCOUNT"));
					rboard.setReviewLevel(rset.getInt("REVIEW_LEVEL"));
					rboard.setReviewRef(rset.getInt("REVIEW_REF"));
					rboard.setReviewReplyRef(rset.getInt("REVIEW_REPLY_REF"));
					rboard.setReviewReplyTurn(rset.getInt("REVIEW_REPLY_TURN"));
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return rboard;
	}

	public int insertBoard(Connection con, ReviewBoard board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into review_board values((select max(review_num) + 1  from review_board), "
				+ "  ?, ?, ?, ?, ?, sysdate, 0, default, null, default, default)";
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, board.getReviewTitle());
			pstmt.setString(2, board.getReviewWriter());
			pstmt.setString(3, board.getReviewContent());
			pstmt.setString(4, board.getReviewOriginalFilename());
			pstmt.setString(5, board.getReviewReFilename());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection con, ReviewBoard board) {
		int result =0;
	      PreparedStatement pstmt = null;
	      
	      String query = "update review_board set"
	            + " review_title = ?, review_content = ?, REVIEW_ORIGINAL_FILENAME = ?, REVIEW_RE_FILENAME = ? "
	            + " where review_num = ?";
	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, board.getReviewTitle());
	         pstmt.setString(2, board.getReviewContent());
	         pstmt.setString(3, board.getReviewOriginalFilename());
	         pstmt.setString(4, board.getReviewReFilename());
	         pstmt.setInt(5, board.getReviewNum());
	      
	         result = pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	}

	public int insertComment(Connection con, ReviewComment comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into review_comment values((select max(cno) + 1  from review_comment), "
				+ "  ?, ?, ?, sysdate)";
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setInt(1, comment.getBno());
			pstmt.setString(2, comment.getCwriter());
			pstmt.setString(3, comment.getCcontent());

			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<ReviewComment> selectReplyList(Connection con, int bnum) {
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM,cno, bno, WRITER, " + 
				"CONTENT, re_date from review_comment " + 
				"ORDER BY cno desc) where bno = ? "; 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bnum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReviewComment comment = new ReviewComment();
				comment.setBno(rset.getInt("bno"));
				comment.setCno(rset.getInt("cno"));
				comment.setCwriter(rset.getString("writer"));
				comment.setCcontent(rset.getString("content"));
				comment.setRe_date(rset.getDate("re_date"));
				
				list.add(comment);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int getReplyListCount(Connection con, int bnum) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from review_comment where bno = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bnum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int deleteReply(Connection con, int cNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from review_comment where cno = ?";
	
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	
			close(pstmt);
		}
		
		return result;
	}

	public int updateReply(Connection con, int cNum, String content) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update  review_comment  set  content = ?  where cno = ?";
	
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setInt(2, cNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	
			close(pstmt);
		}
		
		return result;
	}
	public ArrayList<ReviewBoard> selectMyList(Connection con, String myId) {
		ArrayList<ReviewBoard> mylist = new ArrayList<ReviewBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String query = "select * from review_board where review_writer = ?";
		System.out.print(myId);
//		int startRow = (currentPage - 1) * limit + 1;
//		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, myId);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReviewBoard rboard = new ReviewBoard();
				
				rboard.setReviewNum(rset.getInt("REVIEW_NUM"));
				rboard.setReviewTitle(rset.getString("REVIEW_TITLE"));
				rboard.setReviewWriter(rset.getString("REVIEW_WRITER"));
				rboard.setReviewContent(rset.getString("REVIEW_CONTENT"));
				rboard.setReviewOriginalFilename(rset.getString("REVIEW_ORIGINAL_FILENAME"));
				rboard.setReviewReFilename(rset.getString("REVIEW_RE_FILENAME"));
				rboard.setReviewDate(rset.getDate("REVIEW_DATE"));
				rboard.setReviewReadcount(rset.getInt("REVIEW_READCOUNT"));
				rboard.setReviewLevel(rset.getInt("REVIEW_LEVEL"));
				rboard.setReviewRef(rset.getInt("REVIEW_REF"));
				rboard.setReviewReplyRef(rset.getInt("REVIEW_REPLY_REF"));
				rboard.setReviewReplyTurn(rset.getInt("REVIEW_REPLY_TURN"));
				
				mylist.add(rboard);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mylist;
	}

}
