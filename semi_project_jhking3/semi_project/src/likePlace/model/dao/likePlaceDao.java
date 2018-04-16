package likePlace.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import likePlace.model.vo.likePlace;
import member.model.vo.Member;
import vrBoard.model.vo.vrBoard;

public class likePlaceDao {

	public int likevrBoardCount(Connection conn, vrBoard board) {
		int result = 0;
	      PreparedStatement pstmt = null;

	      String query = "update vr_board set vr_likecount = vr_likecount + 1 where vr_board_num = ?";
	      
	      try{
	         pstmt = conn.prepareStatement(query);

	         
	         pstmt.setInt(1, board.getVrboardnum());


	         System.out.println("dao");
	   
	         result = pstmt.executeUpdate();

	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	   
	      return result;
	}

		public int likevrBoard(Connection conn, String userId, int vrboardnum) {
		 int result = 0;
	      PreparedStatement pstmt = null;

	      String query = "insert into LIKE_PLACE values(?, ?)";
	      
	      System.out.println("like place dao : " + userId);
	      System.out.println("like place dao : " + vrboardnum);
	      
	      try{
	         pstmt = conn.prepareStatement(query);

	         
	         pstmt.setString(1, userId);
	         pstmt.setInt(2, vrboardnum);
	      
	   
	         result = pstmt.executeUpdate();
	
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	   System.out.println("result : " + result);
	      return result;
	}



		public int unlikevrBoard(Connection conn, String userId, int vrboardnum) {
			int result = 0;
		      PreparedStatement pstmt = null;

		      String query = "delete from like_place where like_user = ? and like_place_num = ?";

		      try{
		         pstmt = conn.prepareStatement(query);

		         
		         pstmt.setString(1, userId);
		         pstmt.setInt(2, vrboardnum);
		      
		   
		         result = pstmt.executeUpdate();
		
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   System.out.println(result);
		      return result;
		}

		public int unlikevrBoardCount(Connection conn, vrBoard board) {
			int result = 0;
		      PreparedStatement pstmt = null;

		      String query = "update vr_board set vr_likecount = vr_likecount - 1 where vr_board_num = ?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);

		         
		         pstmt.setInt(1, board.getVrboardnum());

		   
		         result = pstmt.executeUpdate();

		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}

		public ArrayList<likePlace> selectList(Connection conn, String userId) {
			ArrayList<likePlace> list = new ArrayList<likePlace>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			

			String query = "delete from like_place where like_user = ?";
			try {
				pstmt = conn.prepareStatement(query);

		         
		         pstmt.setString(1, userId);

		   

				rset =pstmt.executeQuery(query);
			
				while (rset.next()) {
					likePlace like = new likePlace();

					like.setLikePlaceNum(rset.getInt("like_place_num"));

					list.add(like);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

		public ArrayList<likePlace> selectListUser(Connection conn, String userId) {
			ArrayList<likePlace> list = new ArrayList<likePlace>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			

			String query = "select * from like_place where like_user = ?";
			 System.out.println("dao도달");
			try {
				pstmt = conn.prepareStatement(query);

		        
		         pstmt.setString(1, userId);

		   

				rset =pstmt.executeQuery();
			
				while (rset.next()) {
					likePlace like = new likePlace();
					like.setLikeUser(rset.getString("like_user"));
					like.setLikePlaceNum(rset.getInt("like_place_num"));
					System.out.println("list : " + list);
					list.add(like);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

		public ArrayList<likePlace> selectLikeAll(Connection conn) {
			ArrayList<likePlace> list = new ArrayList<likePlace>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			

			String query = "select * from like_place";
			
			try {
				pstmt = conn.prepareStatement(query);
				rset =pstmt.executeQuery();
			
				while (rset.next()) {
					likePlace like = new likePlace();
					like.setLikePlaceNum(rset.getInt("like_place_num"));
					like.setLikeUser(rset.getString("like_user"));
					//System.out.println("list : " + list);
					list.add(like);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}
		public int likevrBoardCount(Connection conn, int boardNum) {
			int result = 0;
		      PreparedStatement pstmt = null;

		      String query = "update vr_board set vr_likecount = vr_likecount + 1 where vr_board_num = ?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);

		         
		         pstmt.setInt(1, boardNum);


		         System.out.println("dao 좋아요+1");
		   
		         result = pstmt.executeUpdate();

		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}

		public int unLikevrBoardCount(Connection conn, int vrboardnum) {
			int result = 0;
		      PreparedStatement pstmt = null;

		      String query = "update vr_board set vr_likecount = vr_likecount - 1 where vr_board_num = ?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);

		         
		         pstmt.setInt(1, vrboardnum);


		         System.out.println("dao좋아요-1");
		   
		         result = pstmt.executeUpdate();

		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}

		public int unLikevrBoard(Connection conn,String userId, int vrboardnum) {
			PreparedStatement pstmt = null;
			int result = 0;
			

			String query = "delete from like_place where like_user = ? and like_place_num = ? ";
			try {
				pstmt = conn.prepareStatement(query);

		         
		         pstmt.setString(1, userId);
		         pstmt.setInt(2, vrboardnum);
		         System.out.println("id : "+userId+",  bnum : "+vrboardnum);
		   

		         result = pstmt.executeUpdate();
			

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
		   public ArrayList<likePlace> selectHotelUser(Connection conn, String userId) {
		         ArrayList<likePlace> list = new ArrayList<likePlace>();
		         PreparedStatement pstmt = null;
		         ResultSet rset = null;
		         

		         String query = "select LIKE_PLACE_NUM from LIKE_PLACE  where like_user = ? and LIKE_PLACE_NUM in (select vr_board_num from VR_BOARD where vr_code = '숙소')";
		          System.out.println("dao도달");
		         try {
		            pstmt = conn.prepareStatement(query);

		              
		               pstmt.setString(1, userId);

		         

		            rset =pstmt.executeQuery();
		         
		            while (rset.next()) {
		               likePlace like = new likePlace();

		               like.setLikePlaceNum(rset.getInt("like_place_num"));
		               System.out.println("list : " + list);
		               list.add(like);

		            }

		         } catch (Exception e) {
		            e.printStackTrace();
		         } finally {
		            close(rset);
		            close(pstmt);
		         }
		         return list;
		      }

		      public ArrayList<likePlace> selectResUser(Connection conn, String userId) {
		         ArrayList<likePlace> list = new ArrayList<likePlace>();
		         PreparedStatement pstmt = null;
		         ResultSet rset = null;
		         

		         String query = "select LIKE_PLACE_NUM from LIKE_PLACE  where like_user = ? and LIKE_PLACE_NUM in (select vr_board_num from VR_BOARD where vr_code = '편의시설')";
		          System.out.println("dao도달");
		         try {
		            pstmt = conn.prepareStatement(query);

		              
		               pstmt.setString(1, userId);

		         

		            rset =pstmt.executeQuery();
		         
		            while (rset.next()) {
		               likePlace like = new likePlace();

		               like.setLikePlaceNum(rset.getInt("like_place_num"));
		               System.out.println("list : " + list);
		               list.add(like);

		            }

		         } catch (Exception e) {
		            e.printStackTrace();
		         } finally {
		            close(rset);
		            close(pstmt);
		         }
		         return list;
		      }

		      public ArrayList<likePlace> selectPlaceUser(Connection conn, String userId) {
		         ArrayList<likePlace> list = new ArrayList<likePlace>();
		         PreparedStatement pstmt = null;
		         ResultSet rset = null;
		         

		         String query = "select LIKE_PLACE_NUM from LIKE_PLACE  where like_user = ? and LIKE_PLACE_NUM in (select vr_board_num from VR_BOARD where vr_code = '명소')";
		          System.out.println("dao도달");
		         try {
		            pstmt = conn.prepareStatement(query);

		              
		               pstmt.setString(1, userId);

		         

		            rset =pstmt.executeQuery();
		         
		            while (rset.next()) {
		               likePlace like = new likePlace();

		               like.setLikePlaceNum(rset.getInt("like_place_num"));
		               System.out.println("list : " + list);
		               list.add(like);

		            }

		         } catch (Exception e) {
		            e.printStackTrace();
		         } finally {
		            close(rset);
		            close(pstmt);
		         }
		         return list;
		      }



}