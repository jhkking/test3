package com.kh.finalPro.review.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.review.model.vo.Review;

@Repository("reviewDao")
public class ReviewDao {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Review> reviewDetail(Review review) {
		return mybatis.selectList("reviewMapper.selectOneReview", review);
	}


	public List<Review> reviewDetail2(Review review) {
		// TODO Auto-generated method stub
		return mybatis.selectList("reviewMapper.selectOneReview2", review);
	}
	
	public List<Review> reviewList() {
		return mybatis.selectList("reviewMapper.selectReviewList");
	}

	public void reviewInsert(Review review) {
		mybatis.insert("reviewMapper.reviewInsert", review);
		
	}

	public int searchNum() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("reviewMapper.searchNum");
	}

	public List<Review> myReviewList(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectList("reviewMapper.myReviewList",id);
	}

	public void reviewDelete(String id, String title) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("title", title);
		mybatis.delete("reviewMapper.reviewDelete",map);
		
	}


	public void addReadcount(int r_no) {
		mybatis.update("reviewMapper.addReadcount",r_no);
		
	}

}
