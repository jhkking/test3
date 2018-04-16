package com.kh.finalPro.spot.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.spot.model.vo.Spot;
import com.kh.finalPro.spot.model.vo.Spotreply;

@Repository("spotDao")
public class SpotDao {

   @Autowired
   private SqlSessionTemplate mybatis;
   
   public List<Spot> spotList(String nation1){
      return mybatis.selectList("spotMapper.selectSpotList",nation1);
   }

   public List<Spot> nationList() {
      // TODO Auto-generated method stub
      return mybatis.selectList("spotMapper.selectNationList");
   }
   public Spot spotDetail(int no) {
      // TODO Auto-generated method stub
      return mybatis.selectOne("spotMapper.selectSpotOne", no);
   }


   public List<Spotreply> spotreplyList(int no) {
      // TODO Auto-generated method stub
      return mybatis.selectList("spotreplyMapper.selectSpotreplyList",no);
   }

   public void  insertSpotReply(Spotreply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("spotreplyMapper.insertSpotReply",reply);
   }

   public List<Spot> spotReco(Spot spot) {
      // TODO Auto-generated method stub
   System.out.println(spot);
      return mybatis.selectList("spotMapper.spotReco", spot);
   }


   public void deleteSpotReply(Spotreply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("spotreplyMapper.deleteSpotReply",reply);
      
   }

   public void spotInsert(Spot spot) {
      // TODO Auto-generated method stub
      mybatis.insert("spotMapper.spotInsert",spot);
   }

   public void deleteSpot(Spot spot) {
      // TODO Auto-generated method stub
      mybatis.delete("spotMapper.deleteSpot",spot);
      
   }

   public void addLikecount(int like_place_no) {
      // TODO Auto-generated method stub
      mybatis.update("spotMapper.addLikecount", like_place_no);
   }

public void dellikecount(int like_place_no) {
	mybatis.update("spotMapper.dellikecount", like_place_no);
	
}
}