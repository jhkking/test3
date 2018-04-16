package com.kh.finalPro.feedback.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.finalPro.feedback.model.service.FeedbackService;
import com.kh.finalPro.feedback.model.vo.Feedback;
import com.kh.finalPro.feedback.model.vo.Feedbackreply;
import com.kh.finalPro.rootconsulting.model.service.RootconsultingService;
import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@Autowired
	RootconsultingService rootService;
	
	@RequestMapping("flist.do")
	public String feedbackList(Model model) {
		model.addAttribute("feedbacklist",feedbackService.feedbackList());
		return "feedback/feedbackListView";
	}
	@RequestMapping("fdetail.do")
	public String feedbackDetail(Model model,@RequestParam(value="no")int no) {
		feedbackService.addReadcount(no);
		 List<Feedback> fe = feedbackService.feedbackDetail(no);
		 List<Feedbackreply> fe1 = feedbackService.feedbackreplyList(no);
	
		model.addAttribute("feedbackOneList", fe);
		model.addAttribute("freplyList",fe1);
		model.addAttribute("feedNo",no);
		
		return "feedback/feedback";
	}
	
	@RequestMapping("/insertfeedbackreply.do")
	public String insertFeedbackReply(HttpServletRequest request,Feedbackreply reply) {
		System.out.println("댓글1  :  "+reply);
		feedbackService.insertFeedbackReply(reply);
		System.out.println("댓글 2 :  "+reply);
		int no = reply.getFr_ref_no();
		return "redirect:fdetail.do?no="+no;
	}
	@RequestMapping("/deletefeedbackreply.do")
	public String deleteFeedbackReply(HttpServletRequest request,Feedbackreply reply) {
		feedbackService.deleteFeedbackReply(reply);
		int no = reply.getFr_ref_no();
		return "redirect:fdetail.do?no="+no;
	}
	
		@RequestMapping("/feedinsert.do")
		public String insertFeedback(HttpServletRequest request, String id, String title) {
			Feedback feed = new Feedback();
			System.out.println("feedinsert"+id +",  "+title);
			List<Rootconsulting> rootList = rootService.mrInsertList(id,title);
			int maxNo = feedbackService.searchMaxNo();
			System.out.println(maxNo+1);
			
			for(Rootconsulting f : rootList) {
				
				feed.setF_no(maxNo+1);
				feed.setF_content(f.getMr_content());
				feed.setF_day(f.getMr_day());
				feed.setF_date(f.getMr_date());
				feed.setF_nation1(f.getMr_nation1());
				feed.setF_nation2(f.getMr_nation2());
				feed.setF_original_filename(f.getMr_original_filename());
				feed.setF_rename_filename(f.getMr_rename_filename());
				feed.setF_title(f.getMr_title());
				feed.setF_writer(f.getMr_writer());
				
				feedbackService.insertFeedback(feed);
			}
		
			return "redirect:flist.do";
		}
		@RequestMapping("/fdelete.do")
		public String reviewDelete(Model model, String id, String title) {
			feedbackService.feedbackDelete(id,title);
			return "redirect:myrootlist.do?id="+id;
		}

	
}
