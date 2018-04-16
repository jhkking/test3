package com.kh.finalPro.likeplace.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.finalPro.food.model.service.FoodService;
import com.kh.finalPro.hotel.model.service.HotelService;
import com.kh.finalPro.likeplace.model.service.LikeplaceService;
import com.kh.finalPro.likeplace.model.vo.Likeplace;
import com.kh.finalPro.spot.model.service.SpotService;

@Controller
public class LikeplaceController {

   @Autowired
   LikeplaceService likeplaceService;
   @Autowired
   SpotService spotService;
   @Autowired
   FoodService foodService;
   @Autowired
   HotelService hotelService;

/*   @RequestMapping(value = "likelist.do", method = RequestMethod.POST)
   public List<Likeplace> likeList(HttpSession session, Likeplace like) {
      session.setAttribute("userlike", likeplaceService.likeList(like));
      return "";
   }*/
   @RequestMapping(value = "/likelist.do", method = RequestMethod.POST)
   @ResponseBody
   public void likeList(HttpServletResponse response, Likeplace like, String action1) throws IOException {
      response.setContentType("application.json; charset=utf-8");
      System.out.println(like +" -->" + action1) ;
      //입력판단
      if(action1.equals("insert")) {
         int in = likeplaceService.addLike(like);
         if(like.getLike_place_code().equals("관광지")) {
            spotService.addLikecount(like.getLike_place_no());
         }else if(like.getLike_place_code().equals("음식")) {
            foodService.addLikecount(like.getLike_place_no());
         }else if(like.getLike_place_code().equals("숙박")) {
            hotelService.addLikecount(like.getLike_place_no());
         }
      }else if(action1.equals("delete")){
         int del = likeplaceService.deleteLike(like);
         if(like.getLike_place_code().equals("관광지")) {
            spotService.dellikecount(like.getLike_place_no());
         }else if(like.getLike_place_code().equals("음식")) {
            foodService.dellikecount(like.getLike_place_no());
         }else if(like.getLike_place_code().equals("숙박")) {
            hotelService.dellikecount(like.getLike_place_no());
         }
      }
      
   
      
      //리스트추출
      List<Likeplace> list = likeplaceService.likeList(like);
      
      // 전송용 최종 json 객체
      JSONObject sendJson = new JSONObject();
      JSONArray jarr = new JSONArray();
      for (Likeplace lp : list) {
         // user 정보 저장할 json 객체 생성
         JSONObject lpobject = new JSONObject();

         lpobject.put("like_id", URLEncoder.encode(lp.getLike_member(), "utf-8"));
         lpobject.put("like_code", URLEncoder.encode(lp.getLike_place_code(), "utf-8"));
         lpobject.put("like_no", lp.getLike_place_no());

         jarr.add(lpobject);

      }
      sendJson.put("list", jarr);
      response.setContentType("application/json; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.println(sendJson.toJSONString());
      out.flush();
      out.close();
   }

/*   @RequestMapping(value = "addlike.do", method = RequestMethod.POST)
   @ResponseBody
   public String addLike(HttpServletResponse response, Likeplace like) {
      System.out.println(like);
      likeplaceService.addLike(like);
      return "redirect:likeList.do";
   }

   @RequestMapping(value = "deletelike.do", method = RequestMethod.POST)
   @ResponseBody
   public String deleteLike(Likeplace like) {
      System.out.println(like);
      likeplaceService.deleteLike(like);
      return "redirect:likeList.do";
   }   */

}