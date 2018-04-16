package com.kh.finalPro.notice.model.service;

import java.util.List;
import com.kh.finalPro.notice.model.vo.Notice;

public interface NoticeService {
	
	List<Notice> noticeList() ;

	Notice noticeDetail(int n_no);

	void addReadcount(int n_no);

	void noticeInsert(Notice notice);

	void deleteNotice(Notice notice);

	Notice updateNotice(Notice notice);

	Notice selectupview(Notice notice);
}
