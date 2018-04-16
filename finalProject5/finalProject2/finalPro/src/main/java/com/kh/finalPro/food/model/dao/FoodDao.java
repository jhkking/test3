package com.kh.finalPro.food.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.food.model.vo.Food;
import com.kh.finalPro.food.model.vo.Foodreply;
import com.kh.finalPro.spot.model.vo.Spot;

@Repository("foodDao")
public class FoodDao {

   @Autowired
   private SqlSessionTemplate mybatis;

   public List<Food> foodList(String nation1) {
      return mybatis.selectList("foodMapper.selectFoodList", nation1);
   }

   public Food foodDetail(int no) {
      // TODO Auto-generated method stub
      return mybatis.selectOne("foodMapper.selectFoodOne", no);
   }

   public List<Foodreply> foodreplyList(int no) {
      // TODO Auto-generated method stub
      System.out.println("daon:" + no);
      return mybatis.selectList("foodreplyMapper.selectFoodreplyList", no);
   }

   public void insertFoodReply(Foodreply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("foodreplyMapper.insertFoodReply", reply);

   }

   public void deleteFoodReply(Foodreply reply) {
      // TODO Auto-generated method stub
      mybatis.insert("foodreplyMapper.deleteFoodReply", reply);
   }

   public List<Food> foodReco(Food food) {
      // TODO Auto-generated method stub
      System.out.println(food);
      return mybatis.selectList("foodMapper.foodReco", food);
   }

   public void foodInsert(Food food) {
      // TODO Auto-generated method stub
      mybatis.insert("foodMapper.foodInsert", food);
   }

   public void deleteFood(Food food) {
      // TODO Auto-generated method stub
      mybatis.delete("foodMapper.deleteFood", food);

   }

   public List<Food> selectnationBest(String nationname) {
      // TODO Auto-generated method stub
      Food food = new Food();
      food.setFood_nation1(nationname);
      System.out.println("Dao"+nationname);
      return mybatis.selectList("foodMapper.selectnationBest", food);
   }
   public void addLikecount(int like_place_no) {
      // TODO Auto-generated method stub
      mybatis.update("foodMapper.addLikecount", like_place_no);
   }

public void dellikecount(int like_place_no) {
	mybatis.update("foodMapper.dellikecount", like_place_no);
	
}
}