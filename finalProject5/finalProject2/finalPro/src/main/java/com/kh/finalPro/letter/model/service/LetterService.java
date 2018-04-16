package com.kh.finalPro.letter.model.service;

import java.util.HashMap;
import java.util.List;

import com.kh.finalPro.admin.model.vo.Admin;
import com.kh.finalPro.letter.model.vo.Letter;

public interface LetterService {

	int listCount();
	List<Letter> blackLetter(HashMap<String, Object> map);
	Letter letterSelect(int no);
	int insertLetter(Letter letter);

}
