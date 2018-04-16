package com.kh.finalPro.admin.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.admin.model.dao.AdminDao;
import com.kh.finalPro.admin.model.vo.Admin;

@Service("adminService")
public class AdminServicelmpl implements AdminService{

	@Autowired
	private AdminDao adminDao;

	

	

	@Override
	public List<Admin> searchAdmin(String splag,String scontent) {
		// TODO Auto-generated method stub
		return adminDao.searchAdmin(splag,scontent);
	}

	@Override
	public int memberDelete(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.memberDelete(admin);
	}

	@Override
	public int memberblack(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.memberblack(admin);
	}

	@Override
	public int blackCancle(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.blackCancle(admin);
	}

	@Override
	public List<Admin> memberAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.selectAll(map);
	}

	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return adminDao.listCount();
	}
	
	@Override
	public List<Admin> memberBlack(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.selectBlack(map);
	}

	@Override
	public int blistCount() {
		// TODO Auto-generated method stub
		return adminDao.blistCount();
	}

	@Override
	public List<Admin> memberBlack() {
		// TODO Auto-generated method stub
		return adminDao.blackList();
	}

	
	
}
