package com.kh.finalPro.admin.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.kh.finalPro.admin.model.vo.Admin;

public interface AdminService {
	List<Admin> memberAll(HashMap<String, Object> map);
	List<Admin> memberBlack(HashMap<String, Object> map);
	List<Admin> searchAdmin(String splag, String scontent);
	int memberDelete(Admin admin);
	int memberblack(Admin admin);
	int blackCancle(Admin admin);
	int listCount();
	int blistCount();
	List<Admin> memberBlack();
}
