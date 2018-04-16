package com.kh.finalPro.letter.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.letter.model.dao.LetterDao;
import com.kh.finalPro.letter.model.vo.Letter;

@Service("letterService")
public class LetterServiceImpl implements LetterService{
	
	@Autowired
	private LetterDao letterDao;

	@Override
	public int listCount() {
		return letterDao.listCount();
	}

	@Override
	public List<Letter> blackLetter(HashMap<String, Object> map) {
		return letterDao.letterAll(map);
	}

	@Override
	public Letter letterSelect(int no) {
		return letterDao.letterSelect(no);
	}

	@Override
	public int insertLetter(Letter letter) {
		return letterDao.insertLetter(letter);
	}
}
