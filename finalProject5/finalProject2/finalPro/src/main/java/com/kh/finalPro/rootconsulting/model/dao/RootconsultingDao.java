package com.kh.finalPro.rootconsulting.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;


@Repository("rootDao")
public class RootconsultingDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int rootInsert(Rootconsulting root) {
		return mybatis.insert("rootMapper.rootInsert", root);
		
	}

	public List<Rootconsulting> myRootList(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectList("rootMapper.myRootList", id);
	}

	public int searchLastDay(String id, String title) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("title", title);
		return mybatis.selectOne("rootMapper.serchLastDay",map);
	}



	public List<Rootconsulting> mrInsertList(String id, String title) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("title", title);
	/*	map.put("nation2", nation2);*/

		return mybatis.selectList("rootMapper.mrInsertListSelect",map);
	}

	public List<Rootconsulting> mrDetail(String id, String title) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("title", title);
		return mybatis.selectList("rootMapper.selectOneRoot",map);
	}

	public void mrDelete(String id, String title) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("title", title);
		mybatis.delete("rootMapper.mrDelete", map);
		
	}

	public int rootModify(Rootconsulting root) {
		// TODO Auto-generated method stub
		return mybatis.update("rootMapper.rootModify",root);
	}

	public int rootModifyLast(Rootconsulting root) {
		// TODO Auto-generated method stub
		return mybatis.update("rootMapper.rootModifyLast",root);
	}

	public Rootconsulting mrDay(Rootconsulting root) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("rootMapper.mrDay",root);
	}


	
}
