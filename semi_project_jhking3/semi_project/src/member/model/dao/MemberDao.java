package member.model.dao;

import java.util.ArrayList;

import member.model.vo.Member;

import java.sql.*;
import java.util.*;
import static common.JDBCTemplate.*;

public class MemberDao {
	public MemberDao() {
	}

	public ArrayList<Member> selectList(Connection conn,int currentPage, int limit) {

		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from " + 
				" (SELECT ROWNUM RNUM, smember_id, smember_pwd, smember_pwdhint, smember_pwdans," + 
				" smember_name, smember_idnumber ,smember_address, smember_gender, smember_phone, smember_email,"+ 
				" smember_admin_yn, smember_worker_yn, smember_date " + 
				" from (select * from smember order by smember_date  desc)) WHERE RNUM BETWEEN ? AND ? ";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(currentPage +" , "+ limit);
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setSmemberId(rset.getString("smember_id"));
				member.setSmemberPwd(rset.getString("smember_pwd"));
				member.setSmemberPwdHint(rset.getString("smember_pwdhint"));
				member.setSmemberPwdAns(rset.getString("smember_pwdans"));
				member.setSmemberName(rset.getString("smember_name"));
				member.setSmemberIdNumber(rset.getInt("smember_idnumber"));
				member.setSmemberAddress(rset.getString("smember_address"));
				member.setSmemberGender(rset.getString("smember_gender"));
				member.setSmemberPhone(rset.getString("smember_phone"));
				member.setSmemberEmail(rset.getString("smember_email"));
				member.setSmemberAdminYN(rset.getString("smember_admin_yn"));
				member.setSmemberWorkerYN(rset.getString("smember_worker_yn"));
				member.setSmemberDate(rset.getDate("smember_date"));
				list.add(member);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> selectSearchId(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from smember where smember_id like  ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setSmemberId(rset.getString("smember_id"));
				member.setSmemberPwd(rset.getString("smember_pwd"));
				member.setSmemberPwdHint(rset.getString("smember_pwdhint"));
				member.setSmemberPwdAns(rset.getString("smember_pwdans"));
				member.setSmemberName(rset.getString("smember_name"));
				member.setSmemberIdNumber(rset.getInt("smember_idnumber"));
				member.setSmemberAddress(rset.getString("smember_address"));
				member.setSmemberGender(rset.getString("smember_gender"));
				member.setSmemberPhone(rset.getString("smember_phone"));
				member.setSmemberEmail(rset.getString("smember_email"));
				member.setSmemberAdminYN(rset.getString("smember_admin_yn"));
				member.setSmemberWorkerYN(rset.getString("smember_worker_yn"));
				member.setSmemberDate(rset.getDate("smember_date"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> selectSearchGender(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from smember where smember_gender like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setSmemberId(rset.getString("smember_id"));
				member.setSmemberPwd(rset.getString("smember_pwd"));
				member.setSmemberPwdHint(rset.getString("smember_pwdhint"));
				member.setSmemberPwdAns(rset.getString("smember_pwdans"));
				member.setSmemberName(rset.getString("smember_name"));
				member.setSmemberIdNumber(rset.getInt("smember_idnumber"));
				member.setSmemberAddress(rset.getString("smember_address"));
				member.setSmemberGender(rset.getString("smember_gender"));
				member.setSmemberPhone(rset.getString("smember_phone"));
				member.setSmemberEmail(rset.getString("smember_email"));
				member.setSmemberAdminYN(rset.getString("smember_admin_yn"));
				member.setSmemberWorkerYN(rset.getString("smember_worker_yn"));
				member.setSmemberDate(rset.getDate("smember_date"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Member selectMember(Connection conn, String userid, String userpwd) {

		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from smember where smember_id = ? and smember_pwd = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);

			System.out.println("userid : " + userid);
			System.out.println("userpwd : " + userpwd);
			rset = pstmt.executeQuery();
			System.out.println(rset);
			if (rset.next()) {
				member = new Member();

				member.setSmemberId(userid);
				member.setSmemberPwd(userpwd);
				member.setSmemberPwdHint(rset.getString("smember_pwdhint"));
				member.setSmemberPwdAns(rset.getString("smember_pwdans"));
				member.setSmemberName(rset.getString("smember_name"));
				member.setSmemberIdNumber(rset.getInt("smember_idnumber"));
				member.setSmemberAddress(rset.getString("smember_address"));
				member.setSmemberGender(rset.getString("smember_gender"));
				member.setSmemberPhone(rset.getString("smember_phone"));
				member.setSmemberEmail(rset.getString("smember_email"));
				member.setSmemberAdminYN(rset.getString("smember_admin_yn"));
				member.setSmemberWorkerYN(rset.getString("smember_worker_yn"));
				member.setSmemberDate(rset.getDate("smember_date"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update smember set smember_pwd=?,"
				+ " smember_email=?, smember_phone=?, smember_address=? where smember_id=?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getSmemberPwd());
			pstmt.setString(2, member.getSmemberEmail());
			pstmt.setString(3, member.getSmemberPhone());
			pstmt.setString(4, member.getSmemberAddress());
			pstmt.setString(5, member.getSmemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into smember values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getSmemberId());
			pstmt.setString(2, member.getSmemberPwd());
			pstmt.setString(3, member.getSmemberPwdHint());
			pstmt.setString(4, member.getSmemberPwdAns());
			pstmt.setString(5, member.getSmemberName());
			pstmt.setInt(6, member.getSmemberIdNumber());
			pstmt.setString(7, member.getSmemberAddress());
			pstmt.setString(8, member.getSmemberGender());
			pstmt.setString(9, member.getSmemberPhone());
			pstmt.setString(10, member.getSmemberEmail());
			pstmt.setString(11, member.getSmemberAdminYN());
			pstmt.setString(12, member.getSmemberWorkerYN());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Member selectMember(Connection conn, String userid) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from smember where smember_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			// ∇위 query문에 ? 자리에 들어갈 값을 userid, userpwd로 넣어줌
			pstmt.setString(1, userid);

			rset = pstmt.executeQuery();
			System.out.println("1111111");
			if (rset.next()) {
				member = new Member();
				System.out.println("222222");
				member.setSmemberId(userid);
				member.setSmemberPwd(rset.getString("smember_pwd"));
				member.setSmemberPwdHint(rset.getString("smember_pwdhint"));
				member.setSmemberPwdAns(rset.getString("smember_pwdans"));
				member.setSmemberName(rset.getString("smember_name"));
				member.setSmemberIdNumber(rset.getInt("smember_idnumber"));
				member.setSmemberAddress(rset.getString("smember_address"));
				member.setSmemberGender(rset.getString("smember_gender"));
				member.setSmemberPhone(rset.getString("smember_phone"));
				member.setSmemberEmail(rset.getString("smember_email"));
				member.setSmemberAdminYN(rset.getString("smember_admin_yn"));
				member.setSmemberWorkerYN(rset.getString("smember_worker_yn"));
				member.setSmemberDate(rset.getDate("smember_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return member;
	}

	public int deleteMember(Connection conn, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from smember where smember_id=?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, userid);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> searchId(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select smember_id from smember";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				/*
				 * member.setSmemberId(rset.getString("smember_id"));
				 * member.setSmemberPwd(rset.getString("smember_pwd"));
				 * member.setSmemberPwdHint(rset.getString("smember_pwdhint"));
				 * member.setSmemberPwdAns(rset.getString("smember_pwdans"));
				 * member.setSmemberName(rset.getString("smember_name"));
				 * member.setSmemberIdNumber(rset.getInt("smember_idnumber"));
				 * member.setSmemberAddress(rset.getString("smember_address"));
				 * member.setSmemberGender(rset.getString("smember_gender"));
				 * member.setSmemberPhone(rset.getString("smember_phone"));
				 * member.setSmemberEmail(rset.getString("smember_email"));
				 * member.setSmemberYN(rset.getString("smember_yn"));
				 * member.setSmemberDate(rset.getDate("smember_date"));
				 */

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int searchId(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int re = 0;
		String query = "select * from smember where smember_id=?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				re = 1;
			} else {
				re = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);

		}
		return re;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from smember";
		
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
}
