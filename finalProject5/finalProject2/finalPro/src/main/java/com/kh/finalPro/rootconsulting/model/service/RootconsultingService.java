package com.kh.finalPro.rootconsulting.model.service;

import java.util.List;

import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

public interface RootconsultingService {

	int rootInsert(Rootconsulting root);

	List<Rootconsulting> myRootList(String id);

	int searchLastDay(String id, String title);

	List<Rootconsulting> mrDetail(String id, String title);
	
	List<Rootconsulting> mrInsertList(String id, String title);

	void mrDelete(String id, String title);

	int rootModify(Rootconsulting root);

	int rootModifyLast(Rootconsulting root);

	Rootconsulting mrDay(Rootconsulting root);
}
