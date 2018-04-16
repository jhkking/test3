package com.kh.finalPro.feedback.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.feedback.model.dao.FeedbackDao;
import com.kh.finalPro.feedback.model.vo.Feedback;
import com.kh.finalPro.feedback.model.vo.Feedbackreply;


@Service("feedService")
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao feedbackDao;
	
	@Override
	public List<Feedback> feedbackList(){
		return feedbackDao.feedbackList();
	}

	@Override
	public List<Feedback> feedbackDetail(int no) {
		// TODO Auto-generated method stub
		return feedbackDao.feedbackDetail(no);
	}

	@Override
	public List<Feedbackreply> feedbackreplyList(int no) {
		// TODO Auto-generated method stub
		return feedbackDao.feedbackreplyList(no);
	}

	@Override
	public void insertFeedbackReply(Feedbackreply reply) {
		// TODO Auto-generated method stub
		feedbackDao.insertFeedbackReply(reply);
		
	}

	@Override
	public void deleteFeedbackReply(Feedbackreply reply) {
		// TODO Auto-generated method stub
		feedbackDao.deleteFeedbackReply(reply);
		
	}

	@Override
	public Feedback detailOne(String day, String ref) {
		return feedbackDao.selectdetailOne(day,ref);
		
	}

	@Override
	public void addReadcount(int no) {
		// TODO Auto-generated method stub
		feedbackDao.addRedacount(no);
		
	}

	@Override
	public void insertFeedback(Feedback feed) {
		feedbackDao.insertFeedback(feed);
		
	}

	@Override
	public int searchMaxNo() {
		// TODO Auto-generated method stub
		return feedbackDao.searchMaxNo();
	}

	@Override
	public List<Feedback> myFeedbackList(String id) {
		// TODO Auto-generated method stub
		return feedbackDao.myFeedbackList(id);
	}
	
	@Override
	public void feedbackDelete(String id, String title) {
		feedbackDao.feedbackDelete(id,title);
		
	}
}
