package com.kh.finalPro.letter.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.letter.model.vo.Letter;

@Repository("letterDao")
public class LetterDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<Letter> letterAll(HashMap<String, Object> map) {
		return mybatis.selectList("letterMapper.selectAll",map);
	}

	public int listCount() {
		return mybatis.selectOne("letterMapper.listCount");
	}

	public Letter letterSelect(int no) {
		return mybatis.selectOne("letterMapper.selectOne",no);
	}

	public int insertLetter(Letter letter) {
		return mybatis.insert("letterMapper.insertLetter",letter);
	}

}
