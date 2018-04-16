package com.kh.finalPro.likeplace.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.likeplace.model.vo.Likeplace;

@Repository("likeplaceDao")
public class LikeplaceDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	public int addLike(Likeplace like) {
		// TODO Auto-generated method stub
		return mybatis.insert("likeplaceMapper.addLike",like);
	}

	public List<Likeplace> likeList(Likeplace like) {
		// TODO Auto-generated method stub
		return mybatis.selectList("likeplaceMapper.selectLikeplaceList", like);
	}

	public int deleteLike(Likeplace like) {
		// TODO Auto-generated method stub
		return mybatis.delete("likeplaceMapper.deleteLike", like);
	}

}
