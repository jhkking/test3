package com.kh.finalPro.review.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalPro.member.model.service.MemberService;
import com.kh.finalPro.member.model.vo.Member;
import com.kh.finalPro.review.model.service.ReviewService;
import com.kh.finalPro.review.model.vo.Review;
import com.kh.finalPro.rootconsulting.model.service.RootconsultingService;
import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private RootconsultingService rootService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/rdetail.do")
	public String reviewDetail(HttpSession session, Review review) {
		List<Review> r =  reviewService.reviewDetail(review);
		reviewService.addReadcount(review.getR_no());
		session.setAttribute("reviewDetail",r); 
		int size =  reviewService.reviewDetail(review).size();
		String writer = r.get(0).getR_writer();
		System.out.println(writer);
		Member m = new Member();
		Member member = new Member();
		member.setMember_id(writer);
		m = memberService.idChk(member);
		session.setAttribute("writerImg", m.getImg_rename_filename() );
		session.setAttribute("arrsize", size);
		return "review/reviewDetail";
	}
	@RequestMapping("/rdetail2.do")
	public String reviewDetail2(HttpSession session, Review review) {
		session.setAttribute("reviewDetail", reviewService.reviewDetail2(review)); 
		int size =  reviewService.reviewDetail(review).size();
		session.setAttribute("arrsize", size);
		return "review/reviewDetail";
	}
	@RequestMapping("/rlist.do")
	public String reviewList(Model model) {
		model.addAttribute("reviewList", reviewService.reviewList());
		
		return "review/reviewList";
	}
	
	@RequestMapping("/rinsert.do")
	public String reviewInsert(Model model , String id,String title) {
		List<Rootconsulting> mrInsertList =  rootService.mrInsertList(id, title);
		int num = reviewService.searchNum();
		System.out.println(mrInsertList);
		Review review = new Review();
		for(Rootconsulting mr : mrInsertList) {
			review.setR_no(num+1);
			review.setR_day(mr.getMr_day());
			review.setR_nation1(mr.getMr_nation1());
			review.setR_nation2(mr.getMr_nation2());
			review.setR_content(mr.getMr_content());
			review.setR_original_filename(mr.getMr_original_filename());
			review.setR_rename_filename(mr.getMr_rename_filename());
			review.setR_title(mr.getMr_title());
			review.setR_writer(mr.getMr_writer());
			review.setR_date(mr.getMr_date());
			
			reviewService.reviewInsert(review);
		}
		rootService.mrDelete(id, title);
		return "redirect:rlist.do";
	}
	
	@RequestMapping("/rdelete.do")
	public String reviewDelete(Model model, String id, String title) {
		reviewService.reviewDelete(id,title);
		return "redirect:myrootlist.do?id="+id;
	}

}
