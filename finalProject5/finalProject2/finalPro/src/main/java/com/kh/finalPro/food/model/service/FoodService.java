package com.kh.finalPro.food.model.service;

import java.util.List;

import com.kh.finalPro.food.model.vo.Food;
import com.kh.finalPro.food.model.vo.Foodreply;

public interface FoodService {
   

   Food foodDetail(int no);

   

   List<Food> foodList(String nation1);



   List<Foodreply> foodreplyList(int no);



   void insertFoodReply(Foodreply reply);



   void deleteFoodReply(Foodreply reply);


   List<Food> foodReco(Food food);

   void foodInsert(Food food);



   void deleteFood(Food food);



   List<Food> selectnationBest(String nationname);



   void addLikecount(int like_place_no);



   void dellikecount(int like_place_no);

}