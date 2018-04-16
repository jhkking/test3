package com.kh.finalPro.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.finalPro.member.model.service.MemberService;
import com.kh.finalPro.member.model.vo.Member;

@Controller
public class MailController {
 
  @Autowired
  private JavaMailSender mailSender;
  
  @Autowired
   private MemberService memberService;
 
  // mailForm
  @RequestMapping(value = "/mailForm")
  public String mailForm() {
   
    return "/mailForm";
  }  
 
  // mailSending 코드
  @RequestMapping(value = "/mailSending.do", method = RequestMethod.POST)
  public void mailSending(HttpServletRequest request, Member member, String email,@RequestParam("pwdAnswer") String pwdAnswer,@RequestParam("id") String id,
        HttpServletResponse response) throws IOException{
     
     //임시 비밀번호 생성
           String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다. 
           uuid = uuid.substring(0, 10); //uuid를 앞에서부터 10자리 잘라줌. 

    member.setMember_pwd(uuid);
     
     response.setContentType("text/html; charset=utf-8");
     PrintWriter out = response.getWriter();
     
    
     
    member = memberService.findHint(id);
    
    if(member.getPwd_answer().equals(pwdAnswer)) {
       member.setMember_pwd(uuid);
       memberService.updatePwd(member);
       
       out.append("ok");
         out.flush();
       String setfrom = "gkrwp135@gmail.com";
          String tomail  = member.getEmail(); // 받는 사람 이메일
          String title   = "TravelStargram 비밀번호 찾기";      // 제목
          String content = "찾으시는 회원님의 비밀번호는 [" + uuid + "] 입니다";    // 내용
         
          try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper 
                              = new MimeMessageHelper(message, true, "UTF-8");
       
            messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
            messageHelper.setTo(tomail);     // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content);  // 메일 내용
           
            mailSender.send(message);
          } catch(Exception e){
            System.out.println(e);
          }
    }else {
         out.append("fail");
         out.flush();
      }out.close();
    
   
    
   
    /*return "member/searchPwd";*/
  }
} 