package com.kh.finalPro.qna.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.qna.model.dao.QnaDao;
import com.kh.finalPro.qna.model.vo.Qna;
import com.kh.finalPro.qna.model.vo.Qnareply;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
   @Autowired
   QnaDao qnaDao;
   
   @Override
   public List<Qna> qnaList(){
      return qnaDao.qnaList();
   }
   @Override
   public Qna qnaDetail(int q_no) {
      return qnaDao.qnaDetail(q_no);
   }
   @Override
   public void addReadcount(int q_no) {
      qnaDao.addReadcount(q_no);
   }
   @Override
   public void qnaInsert(Qna qna) {
      qnaDao.qnaInsert(qna);
   }
   @Override
   public void deleteQna(Qna qna) {
      qnaDao.deleteQna(qna);
   }
   @Override
   public Qna selectupview(Qna qna) {
      // TODO Auto-generated method stub
      return qnaDao.selectupview(qna);
   }
   @Override
   public Qna updateNotice(Qna qna) {
      // TODO Auto-generated method stub
      qnaDao.updateQna(qna);
      return qnaDao.selectupview(qna);
   }
   @Override
   public void insertqnaReply(Qnareply reply) {
      // TODO Auto-generated method stub
      qnaDao.insertQnaReply(reply);
      
   }
   @Override
   public void deleteqnaReply(Qnareply reply) {
      // TODO Auto-generated method stub
      qnaDao.deleteQnaReply(reply);
   }
   @Override
   public List<Qnareply> qnareplyList(int q_no) {
      // TODO Auto-generated method stub
      return qnaDao.qnareplyList(q_no);
   }

}