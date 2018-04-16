package com.kh.finalPro.hotel.controller;

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

import com.kh.finalPro.hotel.model.service.HotelService;
import com.kh.finalPro.hotel.model.vo.Hotel;
import com.kh.finalPro.hotel.model.vo.Hotelreply;

@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;
	@RequestMapping("/hotellist.do")
	public String hotelList(Model model,String nation1) {
		model.addAttribute("hotelList",hotelService.hotelList(nation1));
		return "hotel/hotelListView";
	}

	@RequestMapping("/hotelpage.do")
	public String HotelDetail(Model model, @RequestParam(value = "no") int no) {
		System.out.println("aa:" + no);
		model.addAttribute("hotelOne", hotelService.hotelDetail(no));
		model.addAttribute("replyList", hotelService.hotelreplyList(no));
		System.out.println( hotelService.hotelDetail(no));
		return "hotel/hotelpage";
	}
	@RequestMapping("/inserthotelreply.do")
	public String insertHotelReply(HttpServletRequest request,Hotelreply reply) {
		System.out.println("aaa  :" + reply);

		hotelService.insertHotelReply(reply);
		int no = reply.getHo_ref_no();
		return "redirect:hotelpage.do?no="+no;
	}
	@RequestMapping("/deletehotelreply.do")
	public String deleteHotelReply(HttpServletRequest request,Hotelreply reply) {
		hotelService.deleteHotelReply(reply);
		int no =reply.getHo_ref_no();
		return "redirect:hotelpage.do?no="+no;
	}
	
	@RequestMapping(value="hotelReco.do", method=RequestMethod.POST)
	@ResponseBody
	public void hotelReco(HttpServletResponse response, Hotel hotel) throws IOException{ 
		response.setContentType("application.json; charset=utf-8");
		System.out.println("foodReco : "+ hotel);
		if(hotel.getH_nation1() != "") {
		List<Hotel> hotelRecoList = hotelService.hotelReco(hotel);
		
		System.out.println("foodReco2 : "+ hotelRecoList);
		// �쟾�넚�슜 理쒖쥌 json 媛앹껜
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for (Hotel ho : hotelRecoList) {
			// user �젙蹂� ���옣�븷 json 媛앹껜 �깮�꽦
			JSONObject hotelReco = new JSONObject();
			
			hotelReco.put("hotelreco_title", URLEncoder.encode(ho.getH_title(), "utf-8"));
			hotelReco.put("hotelreco_nation", URLEncoder.encode(ho.getH_nation1(), "utf-8")+" - "+URLEncoder.encode(ho.getH_nation2() ,"utf-8"));

			if(ho.getH_original_filename() != null) {
				hotelReco.put("hotelreco_origin_filename", URLEncoder.encode(ho.getH_original_filename(), "utf-8"));
			}else {
				hotelReco.put("hotelreco_origin_filename", "basic.jpg");
			}
			jarr.add(hotelReco);

		}
		
		sendJson.put("list", jarr);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendJson.toJSONString());
		out.flush();
		out.close();
		}
	}
	
	@RequestMapping("/hotelinsert.do")
	public String hotelInsert(HttpServletRequest request, Hotel hotel)throws IOException{
		MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest)request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		/* String root = request.getSession().getServletContext().getRealPath("/");*/
		 String savePath = "c:/finalProject/finalPro/src/main/webapp/images/";
		 if(!uploadFile.isEmpty()){
				String ofileName = uploadFile.getOriginalFilename();
				
				long currentTime = System.currentTimeMillis();  
			    SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
				String rfileName = simDf.format(new Date(currentTime)) +"."+ ofileName.substring(ofileName.lastIndexOf(".")+1);
				uploadFile.transferTo(new File(savePath + rfileName));
							
				hotel.setH_original_filename(rfileName);
				hotel.setH_rename_filename(ofileName);
			}
		 System.out.println(hotel);
		 String nation1 = hotel.getH_nation1();
		 System.out.println(nation1);
		 String title="[호텔]"+hotel.getH_title();
		 hotel.setH_title(title);
		 hotelService.hotelInsert(hotel);
		 System.out.println(nation1);
		 
		 
		 String parameter01 = URLEncoder.encode(nation1, "UTF-8");
		 return "redirect:hotellist.do?nation1="+parameter01;
		 
	}
	
	@RequestMapping("hotelinsertview.do")
	   public String hotelinsertview() {
	      return "hotel/hotelinsertform";
	   }
	@RequestMapping("/deletehotel.do")
	public ModelAndView deleteHotel(@RequestParam("no")int no,@RequestParam("nation1")String nation1)throws Exception{
		String parameter02 = URLEncoder.encode(nation1, "UTF-8");
		ModelAndView mv = new ModelAndView("redirect:/hotellist.do?nation1="+parameter02);
		Hotel hotel = new Hotel();
		hotel.setH_no(no);
		
		hotelService.deleteHotel(hotel);
		return mv;
	}

	
	
}
