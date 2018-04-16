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
 
  // mailSending �ڵ�
  @RequestMapping(value = "/mailSending.do", method = RequestMethod.POST)
  public void mailSending(HttpServletRequest request, Member member, String email,@RequestParam("pwdAnswer") String pwdAnswer,@RequestParam("id") String id,
        HttpServletResponse response) throws IOException{
     
     //�ӽ� ��й�ȣ ����
           String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -�� ������ �־���. 
           uuid = uuid.substring(0, 10); //uuid�� �տ������� 10�ڸ� �߶���. 

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
          String tomail  = member.getEmail(); // �޴� ��� �̸���
          String title   = "TravelStargram ��й�ȣ ã��";      // ����
          String content = "ã���ô� ȸ������ ��й�ȣ�� [" + uuid + "] �Դϴ�";    // ����
         
          try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper 
                              = new MimeMessageHelper(message, true, "UTF-8");
       
            messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
            messageHelper.setTo(tomail);     // �޴»�� �̸���
            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
            messageHelper.setText(content);  // ���� ����
           
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