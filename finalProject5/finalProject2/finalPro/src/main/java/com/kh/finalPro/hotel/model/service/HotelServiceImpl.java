package com.kh.finalPro.hotel.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.food.model.vo.Food;
import com.kh.finalPro.hotel.model.dao.HotelDao;
import com.kh.finalPro.hotel.model.vo.Hotel;
import com.kh.finalPro.hotel.model.vo.Hotelreply;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
   @Autowired
   private HotelDao hotelDao;



   @Override
   public Hotel hotelDetail(int no) {
      // TODO Auto-generated method stub
      return hotelDao.hotelDetail(no);
   }

   @Override
   public List<Hotelreply> hotelreplyList(int no) {
      // TODO Auto-generated method stub
      return hotelDao.hotelreplyList(no);
   }
   public void hotelInsert(Hotel hotel) {
      // TODO Auto-generated method stub
      hotelDao.hotelInsert(hotel);
   }

   @Override
   public void deleteHotel(Hotel hotel) {
      // TODO Auto-generated method stub
      hotelDao.deleteHotel(hotel);
   }



   @Override
   public Object hotelList(String nation1) {
      // TODO Auto-generated method stub
      return hotelDao.hotelList(nation1);
   }

   @Override
   public void insertHotelReply(Hotelreply reply) {
      // TODO Auto-generated method stub
      hotelDao.insertHotelReply(reply);
      
   }
   @Override
   public void deleteHotelReply(Hotelreply reply) {
      hotelDao.deleteHotelReply(reply);
   }

   @Override
   public List<Hotel> hotelReco(Hotel hotel) {
      // TODO Auto-generated method stub
      return hotelDao.hotelReco(hotel);
   }

   @Override
   public void addLikecount(int like_place_no) {
      hotelDao.addLikecount(like_place_no);
      
   }

   @Override
   public void dellikecount(int like_place_no) {
	   hotelDao.dellikecount(like_place_no);
      
   }



}