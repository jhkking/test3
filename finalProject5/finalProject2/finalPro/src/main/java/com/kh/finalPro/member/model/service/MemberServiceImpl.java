package com.kh.finalPro.member.model.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.member.model.dao.MemberDao;
import com.kh.finalPro.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

   @Autowired
   private MemberDao memberDao;

   /*
    * @Override public Member loginCheck(Member member) { return
    * memberDao.loginCheck(member); }
    */

   @Override
   public int insertMember(Member member) {
      return memberDao.insertMember(member);
   }

   @Override
   public Member idChk(Member member) {
      return memberDao.idChk(member);
   }

   @Override
   public int updateMember(Member member) {
      return memberDao.updateMember(member);
   }

   @Override
   public int deleteMember(Member member) {
      return memberDao.deleteMember(member);
   }

   @Override
   public boolean loginCheck(Member member, HttpSession session) {
      boolean result = memberDao.loginCheck(member);
      if (result) { // true일 경우 세션에 등록
         Member mSession = viewMember(member);
         // 세션 변수 등록
         session.setAttribute("member_id", mSession.getMember_id());
      }
      return result;
   }

   // 01_02. 회원 로그인 정보
   @Override
   public Member viewMember(Member member) {
      return memberDao.viewMember(member);
   }

   @Override
   public Member findId(Member member) {
      return memberDao.findId(member);
   }

   @Override
   public Member findHint(String member_id) {
      return memberDao.findHint(member_id);
   }

   @Override
   public int updatePwd(Member member) {
      return memberDao.updatePwd(member);
   }

   @Override
   public int imgUpdate(Member member) {
      return memberDao.imgUpdate(member);
   }

   @Override
   public Member selectOne(String member_id) {
      // TODO Auto-generated method stub
      return memberDao.selectOne(member_id);
   }


}