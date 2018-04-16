package com.kh.finalPro.review.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.review.model.dao.ReviewDao;
import com.kh.finalPro.review.model.vo.Review;
import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;

	
	@Override
	public List<Review>reviewDetail(Review review) {
		return reviewDao.reviewDetail(review);
		
	}
	@Override
	public List<Review>reviewDetail2(Review review) {
		return reviewDao.reviewDetail2(review);
		
	}
	@Override
	public List<Review> reviewList() {
		return reviewDao.reviewList();
	}
	@Override
	public void reviewInsert(Review review) {
		reviewDao.reviewInsert(review);
		
	}
	@Override
	public int searchNum() {
		// TODO Auto-generated method stub
		return reviewDao.searchNum();
	}
	@Override
	public List<Review> myReviewList(String id) {
		// TODO Auto-generated method stub
		return reviewDao.myReviewList(id);
	}
	@Override
	public void reviewDelete(String id, String title) {
		reviewDao.reviewDelete(id,title);
		
	}
	@Override
	public void addReadcount(int n_no) {
		reviewDao.addReadcount(n_no);
		
	}
	

	
}
