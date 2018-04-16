package com.kh.finalPro.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {

   @Autowired
   private SqlSessionTemplate mybatis;

   /*
    * public Member loginCheck(Member member) { member =
    * mybatis.selectOne("memberMapper.loginMember", member); return member; }
    */

   public int insertMember(Member member) {
      int result = mybatis.insert("memberMapper.insertMember", member);
      return result;
   }

   public Member idChk(Member member) {
      member = mybatis.selectOne("memberMapper.idChk", member);
      return member;
   }

   public int updateMember(Member member) {
      int result = mybatis.update("memberMapper.updateMember", member);
      return result;
   }

   public int deleteMember(Member member) {

      int result = mybatis.delete("memberMapper.deleteMember", member);
      return result;
   }

   // 로그인 체크
   public boolean loginCheck(Member member) {
      String id = mybatis.selectOne("memberMapper.loginCheck", member);
      return (id == null) ? false : true;
   }

   public Member viewMember(Member member) {
      return mybatis.selectOne("memberMapper.viewMember", member);
   }

   public Member findId(Member member) {
      return mybatis.selectOne("memberMapper.findId", member);
   }

   public Member findHint(String member_id) {
      return mybatis.selectOne("memberMapper.findHint", member_id);
   }

   public int updatePwd(Member member) {
      return mybatis.update("memberMapper.updatePwd", member);
   }

   public int imgUpdate(Member member) {
      return mybatis.update("memberMapper.imgUpdate", member);
   }

   public Member selectOne(String member_id) {
      // TODO Auto-generated method stub
      return mybatis.selectOne("memberMapper.selectOne",member_id);
   }
   
}