package com.kh.finalPro.spot.model.service;

import java.util.List;

import com.kh.finalPro.spot.model.vo.Spot;
import com.kh.finalPro.spot.model.vo.Spotreply;

public interface SpotService {
   List<Spot> spotList(String nation1);

   List<Spot> nationList();

   Spot spotDetail(int no);

   List<Spotreply> spotreplyList(int no);

   void insertSpotReply(Spotreply reply);

   List<Spot> spotReco(Spot spot);

   void spotInsert(Spot spot);

   void deleteSpot(Spot spot);

   void deleteSpotReply(Spotreply reply);

   void addLikecount(int like_place_no);

   void dellikecount(int like_place_no);


}