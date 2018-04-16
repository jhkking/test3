package com.kh.finalPro.member.model.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.finalPro.member.model.vo.Member;

public interface MemberService {
   /* Member loginCheck(Member member); */

   int insertMember(Member member);

   Member idChk(Member member);

   int updateMember(Member member);

   int deleteMember(Member member);

   // 로그인 체크
   boolean loginCheck(Member member, HttpSession session);

   public Member viewMember(Member member);

   Member findId(Member member);

   Member findHint(String member_id);

   int updatePwd(Member member);

   int imgUpdate(Member member);

   Member selectOne(String member_id);

}