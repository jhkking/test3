package com.kh.finalPro.spot.controller;

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

import com.kh.finalPro.spot.model.service.SpotService;
import com.kh.finalPro.spot.model.vo.Spot;
import com.kh.finalPro.spot.model.vo.Spotreply;

@Controller
public class SpotController {

	@Autowired
	private SpotService spotService;

	@RequestMapping("/slist.do")
	public String spotList(Model model, String nation1) {

		model.addAttribute("spotList", spotService.spotList(nation1));

		return "spot/spotListView2";
	}

	@RequestMapping(value = "/nationlist.do", method = RequestMethod.POST)
	@ResponseBody
	public void nationList(HttpServletResponse response) throws IOException {
		response.setContentType("application.json; charset=utf-8");
		List<Spot> nationList = spotService.nationList();
		// �쟾�넚�슜 理쒖쥌 json 媛앹껜
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		for (Spot na : nationList) {
			// user �젙蹂� ���옣�븷 json 媛앹껜 �깮�꽦
			JSONObject nation = new JSONObject();

			nation.put("nation1", URLEncoder.encode(na.getS_nation1(), "utf-8"));

			jarr.add(nation);

		}
		sendJson.put("list", jarr);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendJson.toJSONString());
		out.flush();
		out.close();
	}

	@RequestMapping("/spotpage.do")
	public String spotDetail(Model model, @RequestParam(value = "no") int no) {
		System.out.println("aa:" + no);
		model.addAttribute("spotOne", spotService.spotDetail(no));
		model.addAttribute("replyList", spotService.spotreplyList(no));
		return "spot/spotpage";
	}


	@RequestMapping("/insertspotreply.do")
	public String insertSpotReply(HttpServletRequest request,Spotreply reply) {
		System.out.println("insertR1  :" + reply);

		spotService.insertSpotReply(reply);
		int no = reply.getSp_ref_no();
		return "redirect:spotpage.do?no="+no;
	}
	
	@RequestMapping(value="spotReco.do", method=RequestMethod.POST)
	@ResponseBody
	public void spotReco(HttpServletResponse response, Spot spot) throws IOException{ 
		response.setContentType("application.json; charset=utf-8");
		System.out.println("spotReco : "+ spot);
		if(spot.getS_nation1() != "") {
		List<Spot> spotRecoList = spotService.spotReco(spot);
		
		System.out.println("spotReco2 : "+ spotRecoList);
		// �쟾�넚�슜 理쒖쥌 json 媛앹껜
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for (Spot sp : spotRecoList) {
			// user �젙蹂� ���옣�븷 json 媛앹껜 �깮�꽦
			JSONObject spotReco = new JSONObject();
			
			spotReco.put("spreco_title", URLEncoder.encode(sp.getS_title(), "utf-8"));
			spotReco.put("spreco_nation", URLEncoder.encode(sp.getS_nation1(), "utf-8")+" - "+URLEncoder.encode(sp.getS_nation2() ,"utf-8"));

			if(sp.getS_original_filename() != null) {
			spotReco.put("spreco_origin_filename", URLEncoder.encode(sp.getS_original_filename(), "utf-8"));
			}else {
				spotReco.put("spreco_origin_filename", "basic.jpg");
			}
			jarr.add(spotReco);

		}
		
		sendJson.put("list", jarr);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendJson.toJSONString());
		out.flush();
		out.close();
		}
	}
	@RequestMapping("/spotinsert.do")
	public String spotInsert(HttpServletRequest request, Spot spot)throws IOException{
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
							
				spot.setS_original_filename(rfileName);
				spot.setS_rename_filename(ofileName);
			}
		 System.out.println(spot);
		 String nation1 = spot.getS_nation1();
		 System.out.println(nation1);
		 String title="[장소]"+spot.getS_title();
		 spot.setS_title(title);
		 spotService.spotInsert(spot);
		 System.out.println(nation1);
		 
		 
		 String parameter01 = URLEncoder.encode(nation1, "UTF-8");
		 return "redirect:slist.do?nation1="+parameter01;
		 
	}
	@RequestMapping("spotinsertview.do")
	   public String spotinsertview() {
	      return "spot/spotinsertform";
	   }
	
	@RequestMapping("deletespotreply.do")
	public String deleteSpotReply(HttpServletRequest request,Spotreply reply) {
		spotService.deleteSpotReply(reply);
		int no = reply.getSp_ref_no();
		return "redirect:spotpage.do?no="+no;
	}
	@RequestMapping("/deletespot.do")
	public ModelAndView deleteSpot(@RequestParam("no")int no,@RequestParam("nation1")String nation1)throws Exception{
		String parameter02 = URLEncoder.encode(nation1, "UTF-8");
		ModelAndView mv = new ModelAndView("redirect:/slist.do?nation1="+parameter02);
		Spot spot = new Spot();
		spot.setS_no(no);
		
		spotService.deleteSpot(spot);
		return mv;
	}
	
	


}
