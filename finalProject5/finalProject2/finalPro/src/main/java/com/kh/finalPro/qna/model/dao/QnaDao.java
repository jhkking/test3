package com.kh.finalPro.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.qna.model.vo.Qna;
import com.kh.finalPro.qna.model.vo.Qnareply;

@Repository("qnaDao")
public class QnaDao {
   @Autowired
   private SqlSessionTemplate mybatis;
   
   public List<Qna> qnaList(){
      return mybatis.selectList("qnaMapper.selectQnaList");
   }
   public Qna qnaDetail(int q_no) {
      return mybatis.selectOne("qnaMapper.selectQnaOne",q_no);
   }
   public void addReadcount(int q_no) {
      mybatis.update("qnaMapper.updateReadCount",q_no);
      
   }
   public  void qnaInsert(Qna qna) {
      mybatis.insert("qnaMapper.qnaInsert",qna);
   }
   public void deleteQna(Qna qna) {
      mybatis.delete("qnaMapper.deleteQna",qna);
      
   }
   public void updateQna(Qna qna) {
      // TODO Auto-generated method stub
      mybatis.update("qnaMapper.updateQna",qna);
      
   }
   public Qna selectupview(Qna qna) {
      // TODO Auto-generated method stub
      Qna qna2= mybatis.selectOne("qnaMapper.selectQnaOne",qna);
      return qna2;
   }
   public void insertQnaReply(Qnareply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("qnareplyMapper.insertQnaReply",reply);
      
   }
   public void deleteQnaReply(Qnareply reply) {
      // TODO Auto-generated method stub
      mybatis.delete("qnareplyMapper.deleteQnaReply",reply);
      
   }
   public List<Qnareply> qnareplyList(int q_no) {
      // TODO Auto-generated method stub
      return mybatis.selectList("qnareplyMapper.selectQnareplyList",q_no);
   }

}