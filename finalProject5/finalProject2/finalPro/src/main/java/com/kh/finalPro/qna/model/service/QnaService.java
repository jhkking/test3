package com.kh.finalPro.qna.model.service;

import java.util.List;

import com.kh.finalPro.qna.model.vo.Qna;
import com.kh.finalPro.qna.model.vo.Qnareply;

public interface QnaService {

   List<Qna> qnaList();

   void addReadcount(int q_no);

   Qna qnaDetail(int q_no);

   void qnaInsert(Qna qna);

   void deleteQna(Qna qna);

   Qna selectupview(Qna qna);



   Qna updateNotice(Qna qna);

   void insertqnaReply(Qnareply reply);

   void deleteqnaReply(Qnareply reply);

   List<Qnareply> qnareplyList(int q_no);

   

}