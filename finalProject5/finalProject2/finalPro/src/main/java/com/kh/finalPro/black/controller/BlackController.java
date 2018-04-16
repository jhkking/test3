package com.kh.finalPro.black.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalPro.black.model.service.BlackService;
import com.kh.finalPro.black.model.vo.Black;

@Controller
public class BlackController {

	@Autowired
	private BlackService blackService;
	
	@RequestMapping(value = "/blackreason.do")
	public void blackreason(HttpServletRequest request, Model model, Black black,HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		String bid=request.getParameter("id");
		System.out.println("1"+bid);
		black.setBlack_id(bid);
		List<Black> list = blackService.blackReason(black);
		System.out.println(list);
		
		

		
		//전송용 최종 json 객체 생성
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		//list를  jarr로 복사하기
		for(Black b: list) {
			//user 정보 저장할 json 객체 생성
			JSONObject juser = new JSONObject();
			juser.put("white_id", URLEncoder.encode(b.getWhite_id(), "utf-8"));
			juser.put("black_id", URLEncoder.encode(b.getBlack_id(), "utf-8"));
			juser.put("b_title", URLEncoder.encode(b.getB_title(), "utf-8"));
			juser.put("b_content", URLEncoder.encode(b.getB_content(), "utf-8"));
			jarr.add(juser);
		}
		
		sendJson.put("list", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendJson.toJSONString());
		out.flush();
	}
}
