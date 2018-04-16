package com.kh.finalPro.qna.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalPro.qna.model.service.QnaService;
import com.kh.finalPro.qna.model.vo.Qna;
import com.kh.finalPro.qna.model.vo.Qnareply;

@Controller
public class QnaController {

   @Autowired
   QnaService qnaService;
   
   @RequestMapping("qlist.do")
   public String qnaList(Model model) {
      model.addAttribute("qnalist",qnaService.qnaList());
      return "qna/qnaListView";
   }
   @RequestMapping("qdetail.do")
   public String qnaDetail(Model model, int q_no) {
      System.out.println(q_no);
      qnaService.addReadcount(q_no);
      List<Qnareply> q1= qnaService.qnareplyList(q_no);
      
      model.addAttribute("qreplyList",q1);
      model.addAttribute("qnaNo",q_no);
      
      model.addAttribute("qnadetail",qnaService.qnaDetail(q_no));
      return "qna/qnaDetailView";
   }
   @RequestMapping("qinsert.do")
   public String qnaInsert(HttpServletRequest request,Qna qna)throws IOException{
      qnaService.qnaInsert(qna);
      return "redirect:qlist.do";
   }
   @RequestMapping("qinsertform.do")
   public String qnaDetail() {
      return "qna/qnaInsertView";
   }
   @RequestMapping("qdelete.do")
   public ModelAndView deleteQna(@RequestParam("no") int no)throws Exception{
      ModelAndView mv =new ModelAndView("redirect:/qlist.do");
      Qna qna =new Qna();
      qna.setQ_no(no);
      qnaService.deleteQna(qna);
      return mv;
   }
   @RequestMapping(value="/qupdate.do")
   public ModelAndView openBoardUpadte(Qna qna ,@RequestParam("no")int no)throws Exception{
      ModelAndView mv= new ModelAndView("/qna/qnaupdateView");
      qna.setQ_no(no);
      System.out.println(qna);
      Qna qna2 = qnaService.selectupview(qna);
      mv.addObject("qnadetail",qna2);
      System.out.println(qna2);
      return mv;
   }
   @RequestMapping(value="/qupdateView.do",method=RequestMethod.POST)
   public ModelAndView updateBoard(Qna qna) throws Exception{
      ModelAndView mv = new ModelAndView("redirect:qlist.do");
   
      System.out.println(qna);
      Qna qna2 =qnaService.updateNotice(qna);

      return mv;
      }
   
   @RequestMapping("/insertqnareply.do")
   public String insertqnaReply(Qnareply reply) {
      System.out.println("  :  "+reply);
      qnaService.insertqnaReply(reply);
      System.out.println(" :    "+reply);
      int q_no = reply.getQr_ref_no();
      
      return "redirect:qdetail.do?q_no="+q_no;
   }
   @RequestMapping("/deleteqnareply.do")
   public String deleteqnaReply(HttpServletRequest request,Qnareply reply) {
      qnaService.deleteqnaReply(reply);
      int q_no = reply.getQr_ref_no();
      return "redirect:qdetail.do?q_no="+q_no;
   }
}