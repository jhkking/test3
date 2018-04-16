package com.kh.finalPro.likeplace.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.likeplace.model.dao.LikeplaceDao;
import com.kh.finalPro.likeplace.model.vo.Likeplace;

@Service("likeplaceService")
public class LikeplaceServiceImpl implements LikeplaceService{
	
	@Autowired
	LikeplaceDao likeplaceDao;

	@Override
	public List<Likeplace>likeList(Likeplace like) {
		// TODO Auto-generated method stub
		return likeplaceDao.likeList(like);
	}
	
	@Override
	public int addLike(Likeplace like) {
		// TODO Auto-generated method stub
		return likeplaceDao.addLike(like);
	}

	@Override
	public int deleteLike(Likeplace like) {
		// TODO Auto-generated method stub
		return likeplaceDao.deleteLike(like);
	}

	
	

}
