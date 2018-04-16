package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import reviewBoard.model.dao.ReviewBoardDao;

//관리자를 위한 회원 전체 정보 조회용
public class MemberService {
	public MemberService() {
	}

	public ArrayList<Member> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectList(conn,currentPage, limit);
		close(conn);
		return list;
	}

	// 로그인 처리 및 한사람의 회원 정보 조회용
	public Member selectMember(String userid, String userpwd) {
		Connection conn = getConnection();
		Member member = new MemberDao().selectMember(conn, userid, userpwd);
		close(conn);
		return member;
	}

	// 회원 아이디로 검색
	public ArrayList<Member> selectSearchId(String keyword) {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectSearchId(conn, keyword);
		close(conn);
		return list;
	}

	// 회원성별
	public ArrayList<Member> selectSearchGender(String keyword) {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectSearchGender(conn, keyword);
		close(conn);
		return list;
	}

	public int deleteMember(String userid) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userid);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public Member updateMember(String userid, String userpwd) {
		Connection conn = getConnection();
		Member member = new MemberDao().selectMember(conn, userid, userpwd);
		close(conn);
		return member;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member member = new MemberDao().selectMember(conn, userId);
		return member;
	}
	
	public int searchId(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().searchId(conn, userId);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new MemberDao().getListCount(con);
		close(con);
		return listCount;
	}



}
