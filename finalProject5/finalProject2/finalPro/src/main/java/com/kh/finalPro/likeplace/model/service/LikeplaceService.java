package com.kh.finalPro.likeplace.model.service;

import java.util.List;

import com.kh.finalPro.likeplace.model.vo.Likeplace;

public interface LikeplaceService  {

	int addLike(Likeplace like);

	List<Likeplace> likeList(Likeplace like);

	int  deleteLike(Likeplace like);

}
