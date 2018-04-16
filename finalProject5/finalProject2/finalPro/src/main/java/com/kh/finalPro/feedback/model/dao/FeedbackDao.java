package com.kh.finalPro.feedback.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.feedback.model.vo.Feedback;
import com.kh.finalPro.feedback.model.vo.Feedbackreply;

@Repository("feedbackDao")
public class FeedbackDao {
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<Feedback> feedbackList() {
		// TODO Auto-generated method stub
		return mybatis.selectList("feedbackMapper.selectFeedbackList");
	}

	public List<Feedback> feedbackDetail(int no) {
		// TODO Auto-generated method stub
		return mybatis.selectList("feedbackMapper.selectFeedbackOneList",no);
	}

	public List<Feedbackreply> feedbackreplyList(int no) {
		// TODO Auto-generated method stub
		return mybatis.selectList("feedbackreplyMapper.selectFeedbackreplyList",no);
	}

	public void insertFeedbackReply(Feedbackreply reply) {
		// TODO Auto-generated method stub
		mybatis.insert("feedbackreplyMapper.insertFeedbackReply",reply);
		
	}

	public void deleteFeedbackReply(Feedbackreply reply) {
		// TODO Auto-generated method stub
		mybatis.insert("feedbackreplyMapper.deleteFeedbackReply",reply);
		
	}

	public Feedback selectdetailOne(String day, String ref) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("day", day);
		map.put("ref", ref);
		return mybatis.selectOne("feedbackMapper.selectdetailOne",map);

	}

	public void addRedacount(int no) {
		// TODO Auto-generated method stub
		mybatis.update("feedbackMapper.updateReadCount",no);
		
	}

	public void insertFeedback(Feedback feed) {
		// TODO Auto-generated method stub
		mybatis.update("feedbackMapper.insertFeedback",feed);

	}

	public int searchMaxNo() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("feedbackMapper.searchMaxNo");
	}

	public List<Feedback> myFeedbackList(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectList("feedbackMapper.myFeedbackList", id);
	}

	public void feedbackDelete(String id, String title) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("title", title);
		mybatis.selectList("feedbackMapper.feedbackDelete", map);
		
	}

}
