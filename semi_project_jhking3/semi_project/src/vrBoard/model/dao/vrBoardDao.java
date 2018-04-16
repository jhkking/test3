package vrBoard.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vrBoard.model.vo.DetailComment;
import vrBoard.model.vo.Maplocation;
import vrBoard.model.vo.VrBoardDetail;
import vrBoard.model.vo.vrBoard;

public class vrBoardDao {

	public vrBoardDao() {
	}

	public vrBoard selectOne(Connection con, int bnum) {
		// 글번호에 대한 게시글 정보 조회용
		vrBoard board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from vr_board where vr_board_num = ?";

		try {
			System.out.println(bnum);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bnum);
			System.out.println(bnum);

			System.out.println(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new vrBoard();

				board.setVrboardnum(rset.getInt("vr_board_num"));
				board.setVrboardtitle(rset.getString("vr_board_title"));
				board.setVrboardwriter(rset.getString("vr_board_writer"));
				board.setVrboardcontent(rset.getString("vr_board_content"));
				board.setVrboarddate(rset.getDate("vr_board_date"));
				board.setVrboardoriginalfilename(rset.getString("vr_board_original_filename"));
				board.setVrboardrenamefilename(rset.getString("vr_board_rename_filename"));
				board.setVrboardreadcount(rset.getInt("vr_board_readcount"));
				board.setVrlikecount(rset.getInt("vr_likecount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
	}

	public vrBoard selectList(Connection con, String title) {
		vrBoard vrboard = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from vr_board where vr_board_title = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrboard = new vrBoard();

				vrboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				vrboard.setVrcode(rset.getString("vr_code"));
				vrboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				vrboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				vrboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				vrboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				vrboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				vrboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				vrboard.setVrlikecount(rset.getInt("vr_likecount"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return vrboard;
	}

	public int getListCount(Connection con, String placeName) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from vr_board where VR_BOARD_TITLE like ?  ";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + placeName + "%");
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from VR_BOARD";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public ArrayList<vrBoard> selectListAll(Connection con) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from vr_board where vr_code = ? ";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "명소");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard vrboard = new vrBoard();

				vrboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				vrboard.setVrcode(rset.getString("vr_code"));
				vrboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				vrboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				vrboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				vrboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				vrboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				vrboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				vrboard.setVrlikecount(rset.getInt("vr_likecount"));

				list.add(vrboard);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Maplocation selectListAll(Connection con, int vrboardnum) {
		Maplocation maplo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from maplocation where map_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vrboardnum);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				maplo = new Maplocation();

				maplo.setMapnum(rset.getInt("map_no"));
				maplo.setMapname(rset.getString("map_name"));
				maplo.setMapwi(rset.getDouble("map_wi"));
				maplo.setMapkung(rset.getDouble("map_kung"));
				maplo.setImagename(rset.getString("map_imagename"));
				maplo.setMetro(rset.getString("map_metro"));
				maplo.setGbus(rset.getString("map_gbus"));
				maplo.setMbus(rset.getString("map_mbus"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return maplo;
	}

	public ArrayList<vrBoard> searchLikePlace(Connection con, String userid) {
		ArrayList<vrBoard> likeBoard = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from vr_board v, like_place p where v.VR_BOARD_NUM=p.like_place_num and like_user = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userid);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard vrboard = new vrBoard();

				vrboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				vrboard.setVrcode(rset.getString("vr_code"));
				vrboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				vrboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				vrboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				vrboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				vrboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				vrboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				vrboard.setVrlikecount(rset.getInt("vr_likecount"));

				likeBoard.add(vrboard);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return likeBoard;
	}

	public int addReadCount(Connection con, int vrboardnum) {
		// 조회수 1증가 처리용
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update vr_board set VR_BOARD_READCOUNT = VR_BOARD_READCOUNT + 1 where VR_BOARD_NUM = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vrboardnum);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public VrBoardDetail selectDetail(Connection con, int vrboardnum) {
		VrBoardDetail vbd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from VRBOARD_DETAIL where vr_board_num = ?";
		try {
			System.out.println(1 + " " + vrboardnum);
			pstmt = con.prepareStatement(query);
			System.out.println(2 + " " + vrboardnum);
			pstmt.setInt(1, vrboardnum);
			System.out.println(3 + " " + vrboardnum);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				vbd = new VrBoardDetail();

				vbd.setVrdetailnum(rset.getInt("VR_BOARD_NUM"));
				vbd.setVrdetailaddress(rset.getString("VR_ADDRESS"));
				vbd.setVropentime(rset.getString("VR_OPENTIME"));
				vbd.setVrphone(rset.getString("VR_PHONE"));
				vbd.setVrhomepage(rset.getString("VR_HOMEPAGE"));
			}
			System.out.println(vbd);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return vbd;
	}

	public ArrayList<vrBoard> PlaceList(Connection con) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from VR_BOARD where vr_code='명소' order by vr_likecount desc, vr_board_num asc ";

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard rboard = new vrBoard();

				rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				rboard.setVrcode(rset.getString("VR_CODE"));
				rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				
				list.add(rboard);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<vrBoard> HotelList(Connection con) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from VR_BOARD where vr_code='숙소' order by vr_likecount desc, vr_board_num asc ";

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard rboard = new vrBoard();

				rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				rboard.setVrcode(rset.getString("VR_CODE"));
				rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				list.add(rboard);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<vrBoard> ResList(Connection con) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from VR_BOARD where vr_code='편의시설' order by vr_likecount desc, vr_board_num asc ";

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard rboard = new vrBoard();

				rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				rboard.setVrcode(rset.getString("VR_CODE"));
				rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				list.add(rboard);
				// System.out.println(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<vrBoard> PlaceList(Connection con, int currentPage, int limit) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, "
				+ "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, "
				+ "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT "
				+ "FROM (SELECT * FROM vr_board where vr_code='명소' "
				+ "ORDER BY VR_LIKECOUNT DESC)) WHERE RNUM BETWEEN ? AND ?";
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			System.out.println("rset = " + rset);
			while (rset.next()) {
				vrBoard v = new vrBoard();
				v.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				v.setVrcode(rset.getString("VR_CODE"));
				v.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				v.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				v.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				v.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				v.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				v.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				v.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				v.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				list.add(v);
				// System.out.println(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<vrBoard> ResList(Connection con, int currentPage, int limit) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, "
				+ "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, "
				+ "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT "
				+ "FROM (SELECT * FROM vr_board where vr_code='편의시설' "
				+ "ORDER BY VR_LIKECOUNT DESC)) WHERE RNUM BETWEEN ? AND ?";
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard v = new vrBoard();
				v.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				v.setVrcode(rset.getString("VR_CODE"));
				v.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				v.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				v.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				v.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				v.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				v.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				v.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				v.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				list.add(v);
				// System.out.println(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<vrBoard> HotelList(Connection con, int currentPage, int limit) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, "
				+ "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, "
				+ "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT "
				+ "FROM (SELECT * FROM vr_board where vr_code='숙소' "
				+ "ORDER BY VR_LIKECOUNT DESC)) WHERE RNUM BETWEEN ? AND ?";
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard v = new vrBoard();
				v.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				v.setVrcode(rset.getString("VR_CODE"));
				v.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				v.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				v.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				v.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				v.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				v.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				v.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				v.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				list.add(v);
				// System.out.println(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public vrBoard selectTopLikeCount(Connection con) {
		vrBoard rboard = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from VR_BOARD order by vr_likecount desc";

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				rboard = new vrBoard();

				rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				rboard.setVrcode(rset.getString("VR_CODE"));
				rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rboard;
	}

	public ArrayList<vrBoard> selectList(Connection con, int currentPage, int limit) {
		ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, "
				+ "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, "
				+ "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT " + "FROM (SELECT * FROM vr_board "
				+ "ORDER BY VR_LIKECOUNT DESC)) WHERE RNUM BETWEEN ? AND ?";
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				vrBoard v = new vrBoard();
				v.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
				v.setVrcode(rset.getString("VR_CODE"));
				v.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
				v.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
				v.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
				v.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
				v.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
				v.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
				v.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
				v.setVrlikecount(rset.getInt("VR_LIKECOUNT"));

				list.add(v);
				// System.out.println(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<vrBoard> searchList(Connection con, int sclimit, int currentPage, String keyword, String searchoption) {
		      ArrayList<vrBoard> list = new ArrayList<vrBoard>();
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      if(searchoption.equals("all")) {
		      String query = "SELECT * " + 
		               "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, " + 
		               "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, " + 
		               "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT " + 
		               "FROM (SELECT * FROM vr_board where VR_CODE = ? and VR_BOARD_TITLE like ?" + 
		               "ORDER BY VR_BOARD_TITLE ASC)) WHERE RNUM BETWEEN ? AND ?";
		      int startRow = (currentPage - 1) * sclimit + 1;
		      int endRow = startRow + sclimit - 1;

		      try {
		         pstmt = con.prepareStatement(query);
		         pstmt.setString(1, searchoption);
		         pstmt.setString(2, "%" + keyword + "%");
		         pstmt.setInt(3, startRow);
		         pstmt.setInt(4, endRow);

		         rset = pstmt.executeQuery();
		         while(rset.next()) {
		            vrBoard rboard = new vrBoard();
		            
		            rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
		            rboard.setVrcode(rset.getString("VR_CODE"));
		            rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
		            rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
		            rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
		            rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
		            rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
		            rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
		            rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
		            rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
		            
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
		      } else {
		         String query ="SELECT * " + 
		                  "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, " + 
		                  "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, " + 
		                  "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT " + 
		                  "FROM (SELECT * FROM vr_board where VR_BOARD_TITLE like ? and VR_CODE = ?" + 
		                  "ORDER BY VR_BOARD_TITLE ASC)) WHERE RNUM BETWEEN ? AND ?";
		         int startRow = (currentPage - 1) * sclimit + 1;
		         int endRow = startRow + sclimit - 1;
		         try {
		            pstmt = con.prepareStatement(query);
		            
		            pstmt.setString(1, "%" + keyword + "%");
		            pstmt.setString(2, searchoption);
		            pstmt.setInt(3, startRow);
		            pstmt.setInt(4, endRow);
		            rset = pstmt.executeQuery();
		            while(rset.next()) {
		               vrBoard rboard = new vrBoard();
		               
		               rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
		               rboard.setVrcode(rset.getString("VR_CODE"));
		               rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
		               rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
		               rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
		               rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
		               rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
		               rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
		               rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
		               rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
		               
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
	}
	  public ArrayList<vrBoard> selectPlaceList(Connection con) {
	      ArrayList<vrBoard> list = new ArrayList<vrBoard>();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select * from VR_BOARD where VR_CODE ='명소' order by vr_likecount desc";

	      try {
	         pstmt = con.prepareStatement(query);
	         
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	            vrBoard rboard = new vrBoard();
	            
	            rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
	            rboard.setVrcode(rset.getString("VR_CODE"));
	            rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
	            rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
	            rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
	            rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
	            rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
	            rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
	            rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
	            rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
	            
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

	public ArrayList<vrBoard> selectResBoard(Connection con, String placeName) {
		ArrayList<vrBoard> resBoard = new ArrayList<vrBoard>();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select * from VR_BOARD where (VR_CODE ='편의시설'or vr_code='숙소') and VR_BOARD_TITLE like ? "
		      		+ "order by vr_likecount desc"; 

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,"%"+placeName+"%");
	         
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	            vrBoard rboard = new vrBoard();
	            
	            rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
	            rboard.setVrcode(rset.getString("VR_CODE"));
	            rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
	            rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
	            rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
	            rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
	            rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
	            rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
	            rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
	            rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
	            
	            resBoard.add(rboard);
	            System.out.println(resBoard);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return resBoard;
	}

	public ArrayList<VrBoardDetail> selectResBoardDetail(Connection con, String placeName) {
		ArrayList<VrBoardDetail> resBoardDetail = new ArrayList<VrBoardDetail>();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select d.VR_BOARD_NUM, vr_address, vr_opentime,vr_phone, vr_homepage from  VR_BOARD v ,vrboard_detail d where v.VR_BOARD_NUM = d.VR_BOARD_NUM and v.VR_CODE ='편의시설' and v.VR_BOARD_TITLE like ? order by v.vr_likecount desc";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,"%"+placeName+"%");
	         
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	        	 VrBoardDetail rboard = new VrBoardDetail();
	            
	           rboard.setVrdetailnum(rset.getInt("vr_board_num"));
	           rboard.setVrdetailaddress(rset.getString("vr_address"));
	           rboard.setVropentime(rset.getString("vr_opentime"));
	           rboard.setVrphone(rset.getString("vr_phone"));
	           rboard.setVrhomepage(rset.getString("vr_homepage"));
	            
	            resBoardDetail.add(rboard);
	            System.out.println(resBoardDetail);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return resBoardDetail;
	}
	public int addvrdetail(int boardnum, String address, String opentime, String phone, String homepageadd,
	         Connection con) {
	      int result = 0;
	         PreparedStatement pstmt = null;

	         String query = "insert into vrboard_detail values(?, ?, ?, ?, ?)";
	         try{
	            pstmt = con.prepareStatement(query);

	            
	            pstmt.setInt(1, boardnum);
	            pstmt.setString(2, address);
	            pstmt.setString(3, opentime);
	            pstmt.setString(4, phone);
	            pstmt.setString(5, homepageadd);
	         
	      
	            result = pstmt.executeUpdate();
	   
	         }catch (Exception e) {
	            e.printStackTrace();
	         }finally {
	            close(pstmt);
	         }
	         return result;
	         
	   }
	public ArrayList<vrBoard> getvrBoard(Connection con, String title) {
	      ArrayList<vrBoard> list = new ArrayList<vrBoard>();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select * from VR_BOARD where vr_board_title = ?";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, title);
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	            vrBoard rboard = new vrBoard();
	            
	            rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
	            rboard.setVrcode(rset.getString("VR_CODE"));
	            rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
	            rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
	            rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
	            rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
	            rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
	            rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
	            rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
	            rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
	            
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
	
	public int addvrBoard(String vrcode, String title, String writer, String address, String img, Connection con) {
	       int result = 0;
	         PreparedStatement pstmt = null;
	         System.out.println(vrcode + "," + title+ "," + writer+ "," + address+ "," + img);
	         String query = "insert into vr_board values((select max(vr_board_num) + 1  from vr_board),?,?,?,?,?,null,sysdate,0,0)";

	         try{
	            pstmt = con.prepareStatement(query);

	            
	            pstmt.setString(1, vrcode);
	            pstmt.setString(2, title);
	            pstmt.setString(3, writer);
	            pstmt.setString(4, address);
	            pstmt.setString(5, img);
	         
	            result = pstmt.executeUpdate();
	   
	         }catch (Exception e) {
	            e.printStackTrace();
	         }finally {
	            close(pstmt);
	         }
	         return result;
	   }
	   
		public int insertComment(Connection con, DetailComment comment) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "insert into detail_comment values((select max(cno) + 1  from detail_comment), "
					+ "  ?, ?, ?, sysdate)";
			
			try {
				pstmt =con.prepareStatement(query);
				pstmt.setInt(1, comment.getBno());
				pstmt.setString(2, comment.getDwriter());
				pstmt.setString(3, comment.getDcontent());

				result = pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
	   
		public ArrayList<DetailComment> selectReplyList(Connection con, int bnum) {
			ArrayList<DetailComment> list = new ArrayList<DetailComment>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "SELECT * from detail_comment  where bno = ? order by cno desc ";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, bnum);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					DetailComment comment = new DetailComment();
					comment.setBno(rset.getInt("bno"));
					comment.setCno(rset.getInt("cno"));
					comment.setDwriter(rset.getString("writer"));
					comment.setDcontent(rset.getString("content"));
					comment.setRe_date(rset.getDate("cdate"));
					
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
	   
		public int deleteReply(Connection con, int cnum) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = "delete from detail_comment where cno = ?";
		
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, cnum);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
		
				close(pstmt);
			}
			
			return result;
		}

		public vrBoard VrBoardModify(Connection con, int boardnum) {
			vrBoard rboard = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = "select * from VR_BOARD where vr_board_num = ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, boardnum);
				rset = pstmt.executeQuery();

				if (rset.next()) {
					rboard = new vrBoard();

					rboard.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
					rboard.setVrcode(rset.getString("VR_CODE"));
					rboard.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
					rboard.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
					rboard.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
					rboard.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
					rboard.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
					rboard.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
					rboard.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
					rboard.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return rboard;
		}
		public int updatevrBoard(int boardnum, String vrcode, String title, String writer, String address, String img, Connection conn) {
			int result = 0;
		      PreparedStatement pstmt = null;
		      String query = "update vr_board set vr_code = ?, vr_board_title = ?, vr_board_content = ?, "
		      		+ "VR_BOARD_ORIGINAL_FILENAME = ? where VR_BOARD_NUM =?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);
		         
		         pstmt.setString(1, vrcode);
		         pstmt.setString(2, title);
		         pstmt.setString(3, address);
		         pstmt.setString(4, img);
		         pstmt.setInt(5, boardnum);
		      
		         result = pstmt.executeUpdate();
		         
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}

		public int updatevrDetail(int boardnum, String address, String opentime, String phone, String homepageadd,
				Connection conn) {
			int result = 0;
		      PreparedStatement pstmt = null;
		      String query = "update vrboard_detail set vr_address = ?, vr_opentime = ?, vr_phone = ?, vr_homepage = ? "
		      		+ "where vr_board_num = ?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);
		         
		         pstmt.setString(1, address);
		         pstmt.setString(2, opentime);
		         pstmt.setString(3, phone);
		         pstmt.setString(4, homepageadd);
		         pstmt.setInt(5, boardnum);
		      
		         result = pstmt.executeUpdate();
		         
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}
		public ArrayList<vrBoard> selectListnum(Connection con, int currentPage, int limit) {
			ArrayList<vrBoard> list = new ArrayList<vrBoard>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			 String query = "SELECT * " + 
			            "FROM (SELECT ROWNUM RNUM, VR_BOARD_NUM, VR_CODE, VR_BOARD_TITLE, VR_BOARD_WRITER, " + 
			            "VR_BOARD_CONTENT, VR_BOARD_ORIGINAL_FILENAME, VR_BOARD_RENAME_FILENAME, " + 
			            "VR_BOARD_DATE, VR_BOARD_READCOUNT, VR_LIKECOUNT " + 
			            "FROM (SELECT * FROM vr_board " + 
			            "ORDER BY vr_board_num DESC)) WHERE RNUM BETWEEN ? AND ?";
				int startRow = (currentPage - 1) * limit + 1;
				int endRow = startRow + limit - 1;
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
					rset = pstmt.executeQuery();
					while(rset.next()) {
						vrBoard v = new vrBoard();
						v.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
						v.setVrcode(rset.getString("VR_CODE"));
						v.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
						v.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
						v.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
						v.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
						v.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
						v.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
						v.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
						v.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
						
						
						
						list.add(v);
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

		public VrBoardDetail detailselectOne(Connection con, int num) {
			VrBoardDetail rboard = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = "select * from vrboard_detail where vr_board_num = ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, num);
				rset = pstmt.executeQuery();

				if (rset.next()) {
					rboard = new VrBoardDetail();

					rboard.setVrdetailnum(num);
					rboard.setVrdetailaddress(rset.getString("VR_ADDRESS"));
					rboard.setVropentime(rset.getString("VR_OPENTIME"));
					rboard.setVrphone(rset.getString("VR_PHONE"));
					rboard.setVrhomepage(rset.getString("VR_HOMEPAGE"));
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return rboard;
		}

		public VrBoardDetail VrDetailModify(Connection con, int boardnum) {
			VrBoardDetail rboard = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = "select * from vrboard_detail where vr_board_num = ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, boardnum);
				rset = pstmt.executeQuery();

				if (rset.next()) {
					rboard = new VrBoardDetail();

					rboard.setVrdetailnum(boardnum);
					rboard.setVrdetailaddress(rset.getString("VR_ADDRESS"));
					rboard.setVropentime(rset.getString("VR_OPENTIME"));
					rboard.setVrphone(rset.getString("VR_PHONE"));
					rboard.setVrhomepage(rset.getString("VR_HOMEPAGE"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return rboard;
		}
		
		public ArrayList<DetailComment> selectReplyList(Connection con) {
			ArrayList<DetailComment> list = new ArrayList<DetailComment>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "SELECT * FROM detail_comment";
			
			try {
				pstmt = con.prepareStatement(query);

				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					DetailComment comment = new DetailComment();
					comment.setBno(rset.getInt("bno"));
					comment.setCno(rset.getInt("cno"));
					comment.setDwriter(rset.getString("writer"));
					comment.setDcontent(rset.getString("content"));
					comment.setRe_date(rset.getDate("cdate"));
					
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
		

		public int vrBoardDelete2(int boardnum, Connection conn) {
			int result = 0;
		      PreparedStatement pstmt = null;
		      String query = "delete vr_board where VR_BOARD_NUM = ?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);
		         
		         pstmt.setInt(1, boardnum);
		      
		         result = pstmt.executeUpdate();
		         
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}

		public ArrayList<VrBoardDetail> DetailList(Connection con) {
			ArrayList<VrBoardDetail> list = new ArrayList<VrBoardDetail>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			 String query = "SELECT * from vrboard_detail";

				
				try {
					pstmt = con.prepareStatement(query);
					
					rset = pstmt.executeQuery();
					while(rset.next()) {
						VrBoardDetail rboard = new VrBoardDetail();
						rboard.setVrdetailnum(rset.getInt("VR_BOARD_NUM"));
						rboard.setVrdetailaddress(rset.getString("VR_ADDRESS"));
						rboard.setVropentime(rset.getString("VR_OPENTIME"));
						rboard.setVrphone(rset.getString("VR_PHONE"));
						rboard.setVrhomepage(rset.getString("VR_HOMEPAGE"));
						
						
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

		public ArrayList<Maplocation> MapList(Connection con) {
			ArrayList<Maplocation> list = new ArrayList<Maplocation>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			 String query = "SELECT * from maplocation";

				
				try {
					pstmt = con.prepareStatement(query);
					
					rset = pstmt.executeQuery();
					while(rset.next()) {
						Maplocation rboard = new Maplocation();
						rboard.setMapnum(rset.getInt("MAP_NO"));
						rboard.setMapname(rset.getString("MAP_NAME"));
						rboard.setMapwi(rset.getInt("MAP_WI"));
						rboard.setMapkung(rset.getInt("MAP_KUNG"));
						rboard.setImagename(rset.getString("MAP_IMAGENAME"));
						rboard.setMetro(rset.getString("MAP_METRO"));
						rboard.setGbus(rset.getString("MAP_GBUS"));
						rboard.setMbus(rset.getString("MAP_MBUS"));
						
						
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

		public ArrayList<Maplocation> BestMapList(Connection con) {
			ArrayList<Maplocation> list = new ArrayList<Maplocation>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			 String query = "SELECT * from maplocation";

				
				try {
					pstmt = con.prepareStatement(query);
					
					rset = pstmt.executeQuery();
					while(rset.next()) {
						Maplocation rboard = new Maplocation();
						rboard.setMapnum(rset.getInt("MAP_NO"));
						rboard.setMapname(rset.getString("MAP_NAME"));
						rboard.setMapwi(rset.getInt("MAP_WI"));
						rboard.setMapkung(rset.getInt("MAP_KUNG"));
						rboard.setImagename(rset.getString("MAP_IMAGENAME"));
						rboard.setMetro(rset.getString("MAP_METRO"));
						rboard.setGbus(rset.getString("MAP_GBUS"));
						rboard.setMbus(rset.getString("MAP_MBUS"));
						
						
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

		public int getPlaceListCount(Connection con) {
			int listCount = 0;
			Statement stmt = null;
			ResultSet rset = null;

			String query = "select count(*) from VR_BOARD where vr_code = '명소'";

			try {
				stmt = con.createStatement();
				rset = stmt.executeQuery(query);

				if (rset.next()) {
					listCount = rset.getInt(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}

			return listCount;
		}
		public int VrBoardDelete(int boardnum, Connection conn) {
			int result = 0;
		      PreparedStatement pstmt = null;
		      String query = "delete vrboard_detail where VR_BOARD_NUM = ?";
		      
		      try{
		         pstmt = conn.prepareStatement(query);
		         
		         pstmt.setInt(1, boardnum);
		      
		         result = pstmt.executeUpdate();
		         
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         close(pstmt);
		      }
		   
		      return result;
		}
		


		   public int getHotelListCount(Connection con) {
		      int listCount = 0;
		      Statement stmt = null;
		      ResultSet rset = null;

		      String query = "select count(*) from VR_BOARD where vr_code = '숙소'";

		      try {
		         stmt = con.createStatement();
		         rset = stmt.executeQuery(query);

		         if (rset.next()) {
		            listCount = rset.getInt(1);
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(stmt);
		      }

		      return listCount;
		   }

		   public int getResListCount(Connection con) {
		      int listCount = 0;
		      Statement stmt = null;
		      ResultSet rset = null;

		      String query = "select count(*) from VR_BOARD where vr_code = '편의시설'";

		      try {
		         stmt = con.createStatement();
		         rset = stmt.executeQuery(query);

		         if (rset.next()) {
		            listCount = rset.getInt(1);
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(stmt);
		      }

		      return listCount;
		   }
			public ArrayList<vrBoard> selectMyList(Connection con, String myId) {
				ArrayList<vrBoard> mylist = new ArrayList<vrBoard>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				

				String query = "select * from vr_board where vr_board_writer = ?"
						+ "order by vr_board_num asc";
				System.out.print(myId);
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, myId);
					
					
					rset = pstmt.executeQuery();
					while(rset.next()) {
						vrBoard v = new vrBoard();
						
						v.setVrboardnum(rset.getInt("VR_BOARD_NUM"));
						v.setVrcode(rset.getString("VR_CODE"));
						v.setVrboardtitle(rset.getString("VR_BOARD_TITLE"));
						v.setVrboardwriter(rset.getString("VR_BOARD_WRITER"));
						v.setVrboardcontent(rset.getString("VR_BOARD_CONTENT"));
						v.setVrboardoriginalfilename(rset.getString("VR_BOARD_ORIGINAL_FILENAME"));
						v.setVrboardrenamefilename(rset.getString("VR_BOARD_RENAME_FILENAME"));
						v.setVrboarddate(rset.getDate("VR_BOARD_DATE"));
						v.setVrboardreadcount(rset.getInt("VR_BOARD_READCOUNT"));
						v.setVrlikecount(rset.getInt("VR_LIKECOUNT"));
						
						mylist.add(v);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
				return mylist;
			}

			
			public ArrayList<VrBoardDetail> selectDetailRes(Connection con) {
				ArrayList<VrBoardDetail> listD = new ArrayList<VrBoardDetail>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;

				String query = "select * from vrboard_detail where vr_board_num in ( select vr_board_num from vr_board where vr_code = '편의시설') ";
				try {
					
					pstmt = con.prepareStatement(query);
					
					rset = pstmt.executeQuery();
					
					
					while (rset.next()) {
						VrBoardDetail vbd = new VrBoardDetail();

						vbd.setVrdetailnum(rset.getInt("VR_BOARD_NUM"));
						vbd.setVrdetailaddress(rset.getString("VR_ADDRESS"));
						vbd.setVropentime(rset.getString("VR_OPENTIME"));
						vbd.setVrphone(rset.getString("VR_PHONE"));
						vbd.setVrhomepage(rset.getString("VR_HOMEPAGE"));
						listD.add(vbd);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}

				return listD;
			}

			public ArrayList<VrBoardDetail> selectDetailHotel(Connection con) {
				ArrayList<VrBoardDetail> listD = new ArrayList<VrBoardDetail>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;

				String query = "select * from vrboard_detail where vr_board_num in ( select vr_board_num from vr_board where vr_code = '숙소') ";
				try {
					
					pstmt = con.prepareStatement(query);
					
					rset = pstmt.executeQuery();
					
					
					while (rset.next()) {
						VrBoardDetail vbd = new VrBoardDetail();

						vbd.setVrdetailnum(rset.getInt("VR_BOARD_NUM"));
						vbd.setVrdetailaddress(rset.getString("VR_ADDRESS"));
						vbd.setVropentime(rset.getString("VR_OPENTIME"));
						vbd.setVrphone(rset.getString("VR_PHONE"));
						vbd.setVrhomepage(rset.getString("VR_HOMEPAGE"));
						listD.add(vbd);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}

				return listD;
			}

}
