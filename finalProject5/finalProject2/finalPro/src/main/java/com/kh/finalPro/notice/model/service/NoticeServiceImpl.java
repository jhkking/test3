package com.kh.finalPro.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.notice.model.dao.NoticeDao;
import com.kh.finalPro.notice.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeDao noticeDao;

	@Override
	public List<Notice> noticeList() {
		// TODO Auto-generated method stub
		return noticeDao.noticeList();
	}

	@Override
	public Notice noticeDetail(int n_no) {
		// TODO Auto-generated method stub
		return noticeDao.noticeDetail(n_no);
	}

	@Override
	public void addReadcount(int n_no) {
		noticeDao.addReadcount(n_no);
		
	}

	@Override
	public void noticeInsert(Notice notice) {
		noticeDao.noticeInsert(notice);
		
	}
	
	@Override
	public void deleteNotice(Notice notice) {
		noticeDao.deleteNotice(notice);
		
	}

	@Override
	public Notice updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.updateNotice(notice);
		return noticeDao.selectupview(notice);
	}

	@Override
	public Notice selectupview(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.selectupview(notice);
	}


}
