package com.kh.finalPro.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.kh.finalPro.admin.model.vo.Admin;

@Repository("adminDao")
public class AdminDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Admin> selectAll(HashMap<String, Object> map) {
		List<Admin> list = mybatis.selectList("adminMapper.selectAll",map);
		return list;
	}
	public List<Admin> selectBlack(HashMap<String, Object> map) {
	      List<Admin> list = mybatis.selectList("adminMapper.selectBlack",map);
	      return list;
	   }
	public List<Admin> searchAdmin(String splag, String scontent) {
		List<Admin> list=null;
		if(splag.equals("ids")) {
			list = mybatis.selectList("adminMapper.searchId",scontent);
		}else {
			list = mybatis.selectList("adminMapper.searchName",scontent);
		}
		
		return list;
	}
	public int memberDelete(Admin admin) {
		int result = mybatis.delete("adminMapper.memberDelete", admin);
	      return result;
	}
	public int memberblack(Admin admin) {
		int result = mybatis.update("adminMapper.memberBlack", admin);
	      return result;
	}
	public int blackCancle(Admin admin) {
		int result = mybatis.update("adminMapper.blackCancle", admin);
	      return result;
	}
	public int listCount() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("adminMapper.listCount");
	}
	public int blistCount() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("adminMapper.blistCount");
	}
	public List<Admin> blackList() {
	      // TODO Auto-generated method stub
	      return mybatis.selectList("adminMapper.blackList");
	   }
	

}
