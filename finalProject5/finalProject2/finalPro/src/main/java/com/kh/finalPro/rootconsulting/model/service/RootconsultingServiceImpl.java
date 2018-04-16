package com.kh.finalPro.rootconsulting.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.rootconsulting.model.dao.RootconsultingDao;
import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

@Service("rootService")
public class RootconsultingServiceImpl implements RootconsultingService {

	@Autowired
	RootconsultingDao rootDao;

	@Override
	public int rootInsert(Rootconsulting root) {
		return rootDao.rootInsert(root);
	}

	@Override
	public List<Rootconsulting> myRootList(String id) {
		// TODO Auto-generated method stub
		return rootDao.myRootList(id);
	}

	@Override
	public int searchLastDay(String id, String title) {
		// TODO Auto-generated method stub
		return rootDao.searchLastDay(id, title);
	}

	@Override
	public List<Rootconsulting> mrDetail(String id, String title) {
		// TODO Auto-generated method stub
		return  rootDao.mrDetail(id, title);
	}

	@Override
	public List<Rootconsulting> mrInsertList(String id, String title) {
		// TODO Auto-generated method stub
		return rootDao.mrInsertList(id, title);
	}

	@Override
	public void mrDelete(String id, String title) {
		// TODO Auto-generated method stub
		rootDao.mrDelete(id, title);
		
	}

	@Override
	public int rootModify(Rootconsulting root) {
		// TODO Auto-generated method stub
		return rootDao.rootModify(root);
	}

	@Override
	public int rootModifyLast(Rootconsulting root) {
		// TODO Auto-generated method stub
		return rootDao.rootModifyLast(root);
	}

	@Override
	public Rootconsulting mrDay(Rootconsulting root) {
		// TODO Auto-generated method stub
		return rootDao.mrDay(root);
	}


}
