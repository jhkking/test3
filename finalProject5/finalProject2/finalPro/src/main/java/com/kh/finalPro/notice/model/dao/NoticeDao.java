package com.kh.finalPro.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.notice.model.vo.Notice;

@Repository("noticeDao")
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<Notice> noticeList() {
		// TODO Auto-generated method stub
		return mybatis.selectList("noticeMapper.selectNotcieList");
	}

	public Notice noticeDetail(int n_no) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("noticeMapper.selectNoticeOne", n_no);
	}

	public void addReadcount(int n_no) {
		mybatis.update("noticeMapper.updateReadCount", n_no);

	}

	public void noticeInsert(Notice notice) {
		mybatis.insert("noticeMapper.noticeInsert", notice);

	}
	
	public void deleteNotice(Notice notice) {
		mybatis.insert("noticeMapper.deleteNotice",notice);
		
	}

	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		mybatis.update("noticeMapper.updateNotice",notice);
		
	}

	public Notice selectupview(Notice notice) {
		Notice notice2 =mybatis.selectOne("noticeMapper.selectNoticeOne",notice);
		return notice2;
		
	}

}
