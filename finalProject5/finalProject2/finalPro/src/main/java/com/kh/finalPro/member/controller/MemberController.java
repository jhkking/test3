package com.kh.finalPro.member.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalPro.member.model.service.MemberService;
import com.kh.finalPro.member.model.vo.Member;
/*import com.kh.finalPro.util.MailSender;*/

@Controller
public class MemberController {

   @Autowired
   private MemberService memberService;
   
   /*
    * @Autowired private MailSender mailsender;
    */

   @RequestMapping("/loginForm.do")
   public String login(Model model) {
      return "member/login";
   }

   /*
    * @RequestMapping(value="login.do",method=RequestMethod.POST) public String
    * loginMethod(Member member, HttpSession session) { Member loginUser =
    * memberService.loginCheck(member);
    * 
    * session.setAttribute("loginUser", loginUser);
    * 
    * return "../../about"; }
    */

   // 02. 로그인 처리
   @RequestMapping("/loginCheck.do")
   public ModelAndView loginCheck(@ModelAttribute Member member, HttpSession session) {
      boolean result = memberService.loginCheck(member, session);
      ModelAndView mav = new ModelAndView();
      if(result == true) {
    	  Member loginUser = memberService.viewMember(member);
    	  if ( loginUser.getBlackuser() != 'Y') { // 로그인 성공
    	         // main.jsp로 이동
    	         mav.setViewName("../../about");
    	         mav.addObject("msg", "success");
    	         session.setAttribute("loginUser", loginUser);
    	      } else {
    	    	  mav.setViewName("member/login");
    	            mav.addObject("msg", "black");
    	      }
      }else {
    	  mav.setViewName("member/login");
          mav.addObject("msg", "failure");
      }
     
      return mav;
   }

   @RequestMapping("/logout.do")
   public String logoutMethod(HttpServletRequest request) {
      HttpSession session = request.getSession(false);

      if (session != null) {
         session.invalidate();
      }

      return "../../about";
   }

   @RequestMapping("/enrollForm.do")
   public String enrollFormMethod() {

      return "member/minsertForm";

   }

   @RequestMapping("/searchId.do")
   public String serchId() {

      return "member/searchId";

   }

   @RequestMapping(value = "/minsert.do", method = RequestMethod.POST)
   public String insertMember(Member member, Model model, HttpServletRequest request) throws IOException {

      // 파일 업로드 처리
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      MultipartFile uploadFile = multipartRequest.getFile("upFile");

      // 웹서버 컨테이너 경로 추출함
      String root = request.getSession().getServletContext().getRealPath("/");
      // 파일 저장 경로 정함
      String savePath = "C:/finalProject2/finalPro/src/main/webapp/img/mimg/";

      if (!uploadFile.isEmpty()) {
         String ofileName = uploadFile.getOriginalFilename();

         long currentTime = System.currentTimeMillis();
         SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
         String rfileName = simDf.format(new Date(currentTime)) + "."
               + ofileName.substring(ofileName.lastIndexOf(".") + 1);
         ;
         uploadFile.transferTo(new File(savePath + rfileName));

         member.setImg_original_filename(ofileName);
         member.setImg_rename_filename(rfileName);
      } else {
         member.setImg_original_filename("defaultImg.jsp");
         member.setImg_rename_filename("defaultImg.jsp");
      }
      
      

      int result = memberService.insertMember(member);

      String viewName = null;
      if (result > 0) {
         viewName = "member/login";

      } else {
         model.addAttribute("message", "회원가입 실패");
         viewName = "minsertFail";
      }
      return viewName;
   }

   @RequestMapping("/IdCheckForm.do")
   public String IdCheckForm() {

      return "member/IdCheckForm";

   }

   @RequestMapping(value = "/memberIdCheckAction.do", method = RequestMethod.POST)
   @ResponseBody
   public String memberIdCheckAction(@RequestParam(name = "id") String id, HttpServletResponse response, Model model)
         throws IOException {

      Member member = new Member();
      member.setMember_id(id);

      member = memberService.idChk(member);

      Member member2 = memberService.findHint(id);

      JSONObject job = new JSONObject();

      if (member == null) {
         job.put("code", "success");
      } else {
         job.put("code", "fail");
         job.put("pwd", URLEncoder.encode(member2.getPwd_hint(), "utf-8"));
      }
      return job.toString();
   }

   @RequestMapping("/mupdateForm.do")
   public String memberUpdateForm(@RequestParam("member_id")String member_id,Model model) {
      Member member = memberService.selectOne(member_id);
      
      model.addAttribute("member",member);
      return "member/mupdate";
   }

   @RequestMapping(value = "/mupdate.do", method = RequestMethod.POST)
   public String memberUpdate(Member member, Model model, HttpServletRequest request) throws Exception {

      int result = memberService.updateMember(member);
      // 파일 업로드 처리
      /*
       * MultipartHttpServletRequest multipartRequest =
       * (MultipartHttpServletRequest)request; MultipartFile uploadFile =
       * multipartRequest.getFile("upFile");
       */

      // 웹서버 컨테이너 경로 추출함
      // String root = request.getSession().getServletContext().getRealPath("/");
      // 파일 저장 경로 정함
      // String savePath = "C:/finalProject/finalPro/src/main/webapp/img/mimg/";

      /*
       * if(!uploadFile.isEmpty()){ String ofileName =
       * uploadFile.getOriginalFilename(); long currentTime =
       * System.currentTimeMillis(); SimpleDateFormat simDf = new
       * SimpleDateFormat("yyyyMMddHHmmss"); String rfileName = simDf.format(new
       * Date(currentTime)) +"." + ofileName.substring(ofileName.lastIndexOf(".")+1);;
       * uploadFile.transferTo(new File(savePath + rfileName));
       * 
       * member.setImg_original_filename(ofileName);
       * member.setImg_rename_filename(rfileName); } else {
       * member.setImg_original_filename("defaultImg.jsp");
       * member.setImg_rename_filename("defaultImg.jsp"); }
       */

      String viewName = null;

      if (result > 0) {
         
         viewName = "../../about";

      } else {
         model.addAttribute("message", "정보 수정 실패");
         viewName = "mupdateFail";
      }
      return viewName;
   }

   @RequestMapping("/mdelete.do")
   public String memberDelete(Member member, Model model, HttpServletRequest request) throws Exception {

      int result = memberService.deleteMember(member);

      String viewName = null;

      if (result > 0) {
         viewName = "../../about";

      } else {
         model.addAttribute("message", "회원탈퇴 실패 실패");
         viewName = "mdeleteFail";
      }
      HttpSession session = request.getSession(false);

      if (session != null) {
         session.invalidate();
      }
      return viewName;
   }

   @RequestMapping(value = "/findingId.do", method = { RequestMethod.POST, RequestMethod.GET })
   @ResponseBody
   public String findingId(@ModelAttribute Member member, Model model, HttpServletResponse response,
         @RequestParam("memberName") String memberName, @RequestParam("email") String email) throws IOException {
      response.setContentType("application/json; charset=utf-8");
      member.setMember_name(memberName);

      member = memberService.findId(member);

      JSONObject job = new JSONObject();
      job.put("userid", URLEncoder.encode(member.getMember_id(), "utf-8"));

      return job.toJSONString();
   }

   @RequestMapping(value = "/searchPwd.do")
   public String searchPwd(HttpServletRequest request) {

      return "member/searchPwd";

   }

   @RequestMapping("/mailForm.do")
   public String mailSend() {

      return "member/mailForm";

   }

   @RequestMapping("/updateImg.do")
   public String updateImg(Member member,Model model) {
	   Member member2=memberService.selectOne(member.getMember_id());
	   model.addAttribute("member", member2);
      return "member/updateProfileImg";

   }

   // 이미지 변경
   @RequestMapping(value = "/imgupdate.do", method = RequestMethod.POST)
   public String imgUpdate(Member member, Model model, HttpServletRequest request,@RequestParam("member_id")String member_id) throws Exception {
      
      member = memberService.selectOne(member_id);
      
      model.addAttribute("member",member);
      
      
      String oldori=request.getParameter("oldori");
      String oldre=request.getParameter("oldre");
      // 파일 업로드 처리
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      MultipartFile uploadFile = multipartRequest.getFile("upFile");

      // 웹서버 컨테이너 경로 추출함
      String root = request.getSession().getServletContext().getRealPath("/");
      // 파일 저장 경로 정함
      String savePath = "C:/finalProject2/finalPro/src/main/webapp/img/mimg/";
      File delfile = new File(savePath + "\\" + oldre);
      
      if (!uploadFile.isEmpty()) {
         String ofileName = uploadFile.getOriginalFilename();

         long currentTime = System.currentTimeMillis();
         SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
         String rfileName = simDf.format(new Date(currentTime)) + "."
               + ofileName.substring(ofileName.lastIndexOf(".") + 1);
         ;
         uploadFile.transferTo(new File(savePath + rfileName));

         member.setImg_original_filename(ofileName);
         member.setImg_rename_filename(rfileName);
         delfile.delete();
      } else {
         member.setImg_original_filename("defaultImg.jsp");
         member.setImg_rename_filename("defaultImg.jsp");
      }

      int result = memberService.imgUpdate(member);

      String viewName = null;

      if (result > 0) {
         viewName = "member/updateProfileImg";
      } else {
         model.addAttribute("message", "회원탈퇴 실패 실패");
         viewName = "mdeleteFail";
      }

      return viewName;
   }

   // 정보수정 페이지에서 비밀번호 수정 페이지 열기
   @RequestMapping("/updatePasswordForm.do")
   public String updatePasswordForm() {

      return "member/updatePassword";

   }

   // 이미지 변경
   @RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
   public String updatePassword(Member member, Model model, HttpServletRequest request) throws Exception {
      
      int result = memberService.updatePwd(member);

      String viewName = null;

      if (result > 0) {
         viewName = "member/updatePassword";
      } else {
         model.addAttribute("message", "회원탈퇴 실패 실패");
         viewName = "mupdateFail";
      }

      return viewName;
   }

}