package com.kh.finalPro.letter.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalPro.admin.model.service.AdminService;
import com.kh.finalPro.admin.model.vo.Admin;
import com.kh.finalPro.letter.model.service.LetterService;
import com.kh.finalPro.letter.model.vo.Letter;

@Controller
public class LetterController {
   
   @Autowired
   private LetterService letterService;
   @Autowired
   private AdminService adminService;
   
   @RequestMapping("/letterlist.do")
   public String letterList(Model model, HttpServletRequest request) {
      
      int currentPage = (Integer.parseInt(request.getParameter("currentPage")));
      if(request.getParameter("currentPage") != null) {
         //int currentPage = Integer.parseInt(request.getParameter("currentPage"));
      }
            
      int limit = 5;   
      int listCount = letterService.listCount();
      int maxPage = (int)((double)listCount / limit + 0.9);
      int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
      int endPage = startPage + limit - 1;
      int startRow = (currentPage - 1) * limit + 1;
      int endRow = startRow + limit - 1;
      
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("startRow", startRow);
      map.put("endRow", endRow);
      
      List<Letter> list = letterService.blackLetter(map);
      
      if(maxPage < endPage)
         endPage = maxPage;
      
      model.addAttribute("letterList", list);
      model.addAttribute("limit", limit);
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("maxPage", maxPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);
      model.addAttribute("listCount", listCount);
      
      return "admin/heartLetter";
   }
   
   @RequestMapping("/letterDetail.do")
   public String letterDetail(Model model, HttpServletRequest request,Letter letter) {
      
      int currentPage = (Integer.parseInt(request.getParameter("currentPage")));
            
      letter = letterService.letterSelect(letter.getB_no());
      System.out.println("블랙아이디 : "+letter.getBlack_id());
      
      List<Admin> blackList = adminService.memberBlack();
      
      for(Admin a : blackList) {
         System.out.println(a.getMember_id());
      }
      
      model.addAttribute("blackList",blackList);
      model.addAttribute("letter", letter);
      model.addAttribute("currentPage", currentPage);
      
      return "admin/letterDetail";
   }
   
   @RequestMapping("/block.do")
   public String blockView(Model model, HttpServletRequest request,Letter letter) {
            
      return "block/blockForm";
   }
   
   @RequestMapping("/blockWrite.do")
   public String blockWrite(Model model, HttpServletRequest request,Letter letter) {
      int result = letterService.insertLetter(letter);
      
      return "../../about";
   }
   
}