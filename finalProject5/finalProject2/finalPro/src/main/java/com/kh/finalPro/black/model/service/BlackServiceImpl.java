package com.kh.finalPro.black.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.black.model.dao.BlackDao;
import com.kh.finalPro.black.model.vo.Black;

@Service("blackService")
public class BlackServiceImpl implements BlackService{

	@Autowired
	private BlackDao blackDao;

	@Override
	public List<Black> blackReason(Black black) {
		// TODO Auto-generated method stub
		return blackDao.blackReason(black);
	}

	
	

}
