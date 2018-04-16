package com.kh.finalPro.hotel.model.service;

import java.util.List;

import com.kh.finalPro.hotel.model.vo.Hotel;
import com.kh.finalPro.hotel.model.vo.Hotelreply;

public interface HotelService {

   Hotel hotelDetail(int no);

   List<Hotelreply> hotelreplyList(int no);

   Object hotelList(String nation1);

   void insertHotelReply(Hotelreply reply);

   void deleteHotelReply(Hotelreply reply);

   List<Hotel> hotelReco(Hotel hotel);
   
   void hotelInsert(Hotel hotel);

   void deleteHotel(Hotel hotel);

   void addLikecount(int like_place_no);

   void dellikecount(int like_place_no);
}