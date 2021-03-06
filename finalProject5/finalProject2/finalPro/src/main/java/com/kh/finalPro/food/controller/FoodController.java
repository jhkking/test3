package com.kh.finalPro.food.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalPro.food.model.service.FoodService;
import com.kh.finalPro.food.model.vo.Food;
import com.kh.finalPro.food.model.vo.Foodreply;

@Controller
public class FoodController {

	@Autowired
	private FoodService foodService;

	@RequestMapping("/foodlist.do")
	public String foodList(Model model, String nation1) {
		model.addAttribute("foodList", foodService.foodList(nation1));
		return "food/foodListView";
	}

	@RequestMapping("/foodpage.do")
	public String FoodDetail(Model model, @RequestParam(value = "no") int no) {
		System.out.println("aa:" + no);
		model.addAttribute("foodOne", foodService.foodDetail(no));
		model.addAttribute("replyList", foodService.foodreplyList(no));
		System.out.println(foodService.foodDetail(no));
		return "food/foodpage";
	}

	@RequestMapping("/insertfoodreply.do")
	public String insertFoodReply(HttpServletRequest request, Foodreply reply) {
		System.out.println("aaa  :" + reply);

		foodService.insertFoodReply(reply);
		int no = reply.getFo_ref_no();
		return "redirect:foodpage.do?no=" + no;
	}

	@RequestMapping("/deletefoodreply.do")
	public String deleteFoodReply(HttpServletRequest request, Foodreply reply) {
		foodService.deleteFoodReply(reply);
		int no = reply.getFo_ref_no();
		return "redirect:foodpage.do?no=" + no;
	}

	@RequestMapping(value = "foodReco.do", method = RequestMethod.POST)
	@ResponseBody
	public void foodReco(HttpServletResponse response, Food food) throws IOException {
		response.setContentType("application.json; charset=utf-8");
		System.out.println("foodReco : " + food);
		if (food.getFood_nation1() != "") {
			List<Food> foodRecoList = foodService.foodReco(food);

			System.out.println("foodReco2 : " + foodRecoList);
			// �쟾�넚�슜 理쒖쥌 json 媛앹껜
			JSONObject sendJson = new JSONObject();
			JSONArray jarr = new JSONArray();

			for (Food fo : foodRecoList) {
				// user �젙蹂� ���옣�븷 json 媛앹껜 �깮�꽦
				JSONObject foodReco = new JSONObject();

				foodReco.put("foodreco_title", URLEncoder.encode(fo.getFood_title(), "utf-8"));
				foodReco.put("foodreco_nation", URLEncoder.encode(fo.getFood_nation1(), "utf-8") + " - "
						+ URLEncoder.encode(fo.getFood_nation2(), "utf-8"));

				if (fo.getFood_original_filename() != null) {
					foodReco.put("foodreco_origin_filename",
							URLEncoder.encode(fo.getFood_original_filename(), "utf-8"));
				} else {
					foodReco.put("foodreco_origin_filename", "basic.jpg");
				}
				jarr.add(foodReco);

			}

			sendJson.put("list", jarr);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(sendJson.toJSONString());
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/foodinsert.do")
	public String foodInsert(HttpServletRequest request, Food food) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		/* String root = request.getSession().getServletContext().getRealPath("/"); */
		String savePath = "c:/finalProject5/finalProject2/finalPro/src/main/webapp/images/";
		if (!uploadFile.isEmpty()) {
			String ofileName = uploadFile.getOriginalFilename();

			long currentTime = System.currentTimeMillis();
			SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) + "."
					+ ofileName.substring(ofileName.lastIndexOf(".") + 1);
			uploadFile.transferTo(new File(savePath + rfileName));

			food.setFood_original_filename(rfileName);
			food.setFood_rename_filename(ofileName);
		}
		System.out.println(food);
		String nation1 = food.getFood_nation1();
		System.out.println(nation1);
		String title="[음식]"+food.getFood_title();
		food.setFood_title(title);
		foodService.foodInsert(food);
		System.out.println(nation1);

		String parameter01 = URLEncoder.encode(nation1, "UTF-8");
		return "redirect:foodlist.do?nation1=" + parameter01;

	}

	@RequestMapping("foodinsertview.do")
	public String foodinsertview() {
		return "food/foodinsertform";
	}

	@RequestMapping("/deletefood.do")
	public ModelAndView deleteFood(@RequestParam("no") int no, @RequestParam("nation1") String nation1)
			throws Exception {
		String parameter02 = URLEncoder.encode(nation1, "UTF-8");
		ModelAndView mv = new ModelAndView("redirect:/foodlist.do?nation1=" + parameter02);
		Food food = new Food();
		food.setFood_no(no);

		foodService.deleteFood(food);
		return mv;
	}

	@RequestMapping("aboutbest.do")
	public void aboutbest(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("application.json; charset=utf-8");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		String dot=lat+","+lng;
		String nationname="";
		switch(dot) {
		case "37,139":nationname="일본";break;
		case "35,104":nationname="중국";break;
		case "40,-101":nationname="미국";break;
		case "47,2":nationname="프랑스";break;
		case "15,108":nationname="베트남";break;
		case "56,-3":nationname="영국";break;
		default:nationname="";break; 
		}
		/*var japanLatlng = new google.maps.LatLng(37,139);
		var chinaLatlng = new google.maps.LatLng(35,104);
		var usaLatlng = new google.maps.LatLng(40,-101);
		var franchLatlng = new google.maps.LatLng(47,2);
		var vetnamLatlng = new google.maps.LatLng(15,108);
		var ukLatlng = new google.maps.LatLng(56,-3);*/
		
		List<Food> list=foodService.selectnationBest(nationname);
		JSONObject sendJson= new JSONObject();
		JSONArray jarr= new JSONArray();
		for(Food f : list) {
			JSONObject jobject= new JSONObject();
			jobject.put("food_address", URLEncoder.encode(f.getFood_address(),"UTF-8"));
			jobject.put("food_content",  URLEncoder.encode(f.getFood_content(),"UTF-8"));
			jobject.put("food_like_count", f.getFood_like_count());
			jobject.put("food_nation1", URLEncoder.encode(f.getFood_nation1(),"UTF-8"));
			jobject.put("food_nation2", URLEncoder.encode(f.getFood_nation2(),"UTF-8"));
			jobject.put("food_no", f.getFood_no());
			jobject.put("food_original_filename", URLEncoder.encode(f.getFood_original_filename(),"UTF-8"));
			jobject.put("food_phone", f.getFood_phone());
			jobject.put("food_rename_filename", f.getFood_rename_filename());
			jobject.put("food_title", URLEncoder.encode(f.getFood_title(),"UTF-8"));
			jobject.put("food_writer", f.getFood_writer());
			jarr.add(jobject);
		}
		sendJson.put("list", jarr);
	      response.setContentType("application/json; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println(sendJson.toJSONString());
	      out.flush();
	      out.close();
	}

}
