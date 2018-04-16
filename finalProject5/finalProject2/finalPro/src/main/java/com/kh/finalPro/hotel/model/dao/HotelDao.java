package com.kh.finalPro.hotel.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.food.model.vo.Food;
import com.kh.finalPro.hotel.model.vo.Hotel;
import com.kh.finalPro.hotel.model.vo.Hotelreply;

@Repository("hotelDao")
public class HotelDao {

   @Autowired
   private SqlSessionTemplate mybatis;

   public List<Hotel> hotelList(String nation1) {
      // TODO Auto-generated method stub
      return mybatis.selectList("hotelMapper.selectHotelList", nation1);
   }

   public Hotel hotelDetail(int no) {
      // TODO Auto-generated method stub
      return mybatis.selectOne("hotelMapper.selectHotelOne", no);
   }

   public List<Hotelreply> hotelreplyList(int no) {
      // TODO Auto-generated method stub
      return mybatis.selectList("hotelreplyMapper.selectHotelreplyList", no);
   }

   public void insertHotelReply(Hotelreply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("hotelreplyMapper.insertHotelReply", reply);
   }

   public void deleteHotelReply(Hotelreply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("hotelreplyMapper.deleteHotelReply", reply);
   }
   
   public List<Hotel> hotelReco(Hotel hotel) {
      // TODO Auto-generated method stub
      System.out.println(hotel);
      return mybatis.selectList("hotelMapper.hotelReco", hotel);
   }

   public void hotelInsert(Hotel hotel) {
      // TODO Auto-generated method stub
      mybatis.insert("hotelMapper.hotelInsert",hotel);
   }

   public void deleteHotel(Hotel hotel) {
      // TODO Auto-generated method stub
      mybatis.delete("hotelMapper.deleteHotel",hotel);
      
   }

   public void addLikecount(int like_place_no) {
      // TODO Auto-generated method stub
      mybatis.update("hotelMapper.addLikecount", like_place_no);
   }

public void dellikecount(int like_place_no) {
	 mybatis.update("hotelMapper.dellikecount", like_place_no);
	
}
   
}