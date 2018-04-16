package com.kh.finalPro.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalPro.admin.model.service.AdminService;
import com.kh.finalPro.admin.model.vo.Admin;
import com.kh.finalPro.black.model.service.BlackService;

@Controller
public class AdminController {

   @Autowired
   private AdminService adminService;
   
   @Autowired
   private BlackService blackService;

   @RequestMapping("/admin.do")
   public String spotList(Model model, HttpServletRequest request) {

      int currentPage = (Integer.parseInt(request.getParameter("currentPage")));
      /*if(request.getParameter("currentPage") != null) {
            //int currentPage = Integer.parseInt(request.getParameter("currentPage"));
         }*/

      int limit = 5;   
      int listCount = adminService.listCount();
      int maxPage = (int)((double)listCount / limit + 0.9);
      int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
      int endPage = startPage + limit - 1;
      int startRow = (currentPage - 1) * limit + 1;
      int endRow = startRow + limit - 1;

      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("startRow", startRow);
      map.put("endRow", endRow);

      List<Admin> list = adminService.memberAll(map);

      if(maxPage < endPage)
         endPage = maxPage;

      model.addAttribute("memberList", list);
      model.addAttribute("limit", limit);
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("maxPage", maxPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);
      model.addAttribute("listCount", listCount);

      return "admin/adminPage";
   }

   @RequestMapping(value = "/blacklist.do")
   public String blacklist(Locale locale, Model model, HttpServletRequest request) {

      int currentPage = (Integer.parseInt(request.getParameter("currentPage")));
      /*if(request.getParameter("currentPage") != null) {
            //int currentPage = Integer.parseInt(request.getParameter("currentPage"));
         }*/

      int limit = 5;
      int listCount = adminService.blistCount();
      int maxPage = (int)((double)listCount / limit + 0.9);
      int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
      int endPage = startPage + limit - 1;
      int startRow = (currentPage - 1) * limit + 1;
      int endRow = startRow + limit - 1;

      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("startRow", startRow);
      map.put("endRow", endRow);

      List<Admin> blacklist = adminService.memberBlack(map);

      if(maxPage < endPage)
         endPage = maxPage;

      model.addAttribute("blacklist", blacklist);
      model.addAttribute("limit", limit);
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("maxPage", maxPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);
      model.addAttribute("listCount", listCount);
      return "admin/blacklistPage";
   }

   @RequestMapping(value = "/adminsearch.do")
   public String adminsearchlist(Locale locale, Model model, HttpServletRequest request) {
      String splag = request.getParameter("search");
      String scontent = request.getParameter("searchContent");
      System.out.println(splag + "," + scontent);
      List<Admin> searchlist = adminService.searchAdmin(splag, scontent);

      model.addAttribute("searchlist", searchlist);
      return "admin/adminPage";
   }

   @RequestMapping(value = "/admindelete.do")
   public String admindelete(HttpServletRequest request, Model model, Admin admin) {
      int result = adminService.memberDelete(admin);

      return "redirect:blacklist.do?currentPage=1";
   }

   @RequestMapping(value = "/adminblack.do")
   public String adminblack(HttpServletRequest request, Model model, Admin admin) {
      /*
       * String member_id = request.getParameter("member_id");
       * admin.setMember_id(member_id);
       */
      System.out.println(admin.getMember_id());
      int result = adminService.memberblack(admin);

      return "redirect:blacklist.do?currentPage=1";
   }

   @RequestMapping(value = "/blackcancle.do")
   public String blackcancle(HttpServletRequest request, Model model, Admin admin) {
      /*
       * String member_id = request.getParameter("member_id");
       * admin.setMember_id(member_id);
       */
      int result = adminService.blackCancle(admin);

      return "redirect:blacklist.do?currentPage=1";
   }

   /*@RequestMapping(value = "/blackreason.do")
   public String blackreason(HttpServletRequest request, Model model, Admin admin) {

      List<Admin> list = adminService.blackReason(admin);

      return "redirect:blacklist.do";
   }*/

   
}