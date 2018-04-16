package com.kh.finalPro.black.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.black.model.vo.Black;

@Repository("blackDao")
public class BlackDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Black> blackReason(Black black) {
		List<Black> list = mybatis.selectList("blackMapper.blackReason",black);
		return list;
	}
}
