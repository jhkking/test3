package com.kh.finalPro.feedback.model.service;

import java.util.List;

import com.kh.finalPro.feedback.model.vo.Feedback;
import com.kh.finalPro.feedback.model.vo.Feedbackreply;

public interface FeedbackService {

	List<Feedback> feedbackList();

	List<Feedback> feedbackDetail(int no);

	List <Feedbackreply> feedbackreplyList(int no);

	void insertFeedbackReply(Feedbackreply reply);

	void deleteFeedbackReply(Feedbackreply reply);

	Feedback detailOne(String day, String ref);

	void addReadcount(int no);

	void insertFeedback(Feedback feed);

	int searchMaxNo();

	List<Feedback> myFeedbackList(String id);

	void feedbackDelete(String id, String title);
	
}
