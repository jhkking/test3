package com.kh.finalPro.spot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.spot.model.dao.SpotDao;
import com.kh.finalPro.spot.model.vo.Spot;
import com.kh.finalPro.spot.model.vo.Spotreply;

@Service("spotService")
public class SpotServiceImpl implements SpotService {

   @Autowired
   private SpotDao spotDao;
   @Override
   public List<Spot> spotList(String nation1) {
      // TODO Auto-generated method stub
      return spotDao.spotList(nation1);
   }
   @Override
   public List<Spot> nationList() {
      // TODO Auto-generated method stub
      return spotDao.nationList();
   }
   
   @Override
   public Spot spotDetail(int no) {
      // TODO Auto-generated method stub
      return spotDao.spotDetail(no);
   }
   
   @Override
   public List<Spotreply> spotreplyList(int no){
      return spotDao.spotreplyList(no);
   }
   @Override
   public void insertSpotReply(Spotreply reply) {
      // TODO Auto-generated method stub
      spotDao.insertSpotReply(reply);
   }
   @Override
   public List<Spot> spotReco(Spot spot) {
      // TODO Auto-generated method stub
      return spotDao.spotReco(spot);
   }

   @Override
   public void spotInsert(Spot spot) {
      // TODO Auto-generated method stub
      spotDao.spotInsert(spot);
      
   }
   @Override
   public void deleteSpot(Spot spot) {
      // TODO Auto-generated method stub
      spotDao.deleteSpot(spot);
   }
   @Override
   public void deleteSpotReply(Spotreply reply) {
      // TODO Auto-generated method stub
      spotDao.deleteSpotReply(reply);
   }
   @Override
   public void addLikecount(int like_place_no) {
      spotDao.addLikecount(like_place_no);
      
   }
   @Override
   public void dellikecount(int like_place_no) {
	   spotDao.dellikecount(like_place_no);
      
   }
   
}