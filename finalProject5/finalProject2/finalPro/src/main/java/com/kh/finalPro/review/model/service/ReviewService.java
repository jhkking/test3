package com.kh.finalPro.review.model.service;

import java.util.List;

import com.kh.finalPro.review.model.vo.Review;
import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

public interface ReviewService {
	List<Review> reviewDetail(Review review);
	
	List<Review> reviewList();

	void reviewInsert(Review review);

	int searchNum();

	List<Review> myReviewList(String id);

	void reviewDelete(String id, String title);

	List<Review> reviewDetail2(Review review);
	
	void addReadcount(int n_no);
}
