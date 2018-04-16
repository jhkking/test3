package com.kh.finalPro.food.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.food.model.dao.FoodDao;
import com.kh.finalPro.food.model.vo.Food;
import com.kh.finalPro.food.model.vo.Foodreply;
import com.kh.finalPro.spot.model.vo.Spot;

@Service("foodService")
public class FoodServiceImpl implements FoodService {

   @Autowired
   private FoodDao foodDao;

   @Override
   public Food foodDetail(int no) {
      // TODO Auto-generated method stub
      return foodDao.foodDetail(no);
   }

   @Override
   public List<Food> foodList(String nation1) {
      // TODO Auto-generated method stub
      return foodDao.foodList(nation1);
   }

   @Override
   public List<Foodreply> foodreplyList(int no) {
      // TODO Auto-generated method stub
      return foodDao.foodreplyList(no);
   }

   @Override
   public void insertFoodReply(Foodreply reply) {
      // TODO Auto-generated method stub
      foodDao.insertFoodReply(reply);

   }

   @Override
   public void deleteFoodReply(Foodreply reply) {
      // TODO Auto-generated method stub
      foodDao.deleteFoodReply(reply);

   }

   @Override
   public List<Food> foodReco(Food food) {
      // TODO Auto-generated method stub
      return foodDao.foodReco(food);
   }

   @Override
   public void foodInsert(Food food) {
      // TODO Auto-generated method stub
      foodDao.foodInsert(food);
   }

   @Override
   public void deleteFood(Food food) {
      // TODO Auto-generated method stub
      foodDao.deleteFood(food);

   }

   @Override
   public List<Food> selectnationBest(String nationname) {
      // TODO Auto-generated method stub
      return foodDao.selectnationBest(nationname);
   }


   @Override
   public void addLikecount(int like_place_no) {
      foodDao.addLikecount(like_place_no);
      
   }

   @Override
   public void dellikecount(int like_place_no) {
	   foodDao.dellikecount(like_place_no);
      
   }

}