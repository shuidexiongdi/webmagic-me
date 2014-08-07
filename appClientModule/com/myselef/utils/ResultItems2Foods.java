package com.myselef.utils;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.ResultItems;

import com.myselef.constants.Constant;
import com.myselef.model.Food;
import com.myselef.model.RestarantFoods;

public final class ResultItems2Foods {
	
	public static RestarantFoods meituanFoods(ResultItems resultItems) {
		if(resultItems == null) {return null;}
		List<String> restarants = resultItems.get(Constant.RESTAURANT);//有且仅有1个
		List<String> foodtypes = resultItems.get(Constant.FOODTYPES);//每个类型后面都跟着数量：xxx(n)
		List<String> foods = resultItems.get(Constant.FOOD);//菜品名称
		List<String> prices = resultItems.get(Constant.PRICE);//菜品价格: ￥10/份
		RestarantFoods restarantFood = null;
		List<Food> foodlists = null;
		if(restarants == null || restarants.size() != 1) {
			System.out.println("信息为空");
		}else {
			int maxSize = foods.size();
			restarantFood = new RestarantFoods();
			foodlists = new ArrayList<Food>(maxSize); //新建列表
			
			//解析商家
			restarantFood.setRestaurant(restarants.get(0));
			//解析菜品类型
			/*
			Map<String,Integer> foodtypesMap= new LinkedHashMap<String,Integer>();
			for(int i = 0; i < foodtypes.size(); i++) {
				String foodtype = foodtypes.get(i);
				String foodtypeName = foodtype.substring(0, foodtype.lastIndexOf("("));
				String foodnum = foodtype.substring(foodtype.lastIndexOf("("), foodtype.lastIndexOf(")"));
				foodtypesMap.put(foodtypeName, Integer.valueOf(foodnum));
			}
			*/
			List<String> foodtypeList = new ArrayList<String>(maxSize); 
			for(int i = 0; i < foodtypes.size(); i++) {
				String foodtype = foodtypes.get(i);
				String foodtypeName = foodtype.substring(0, foodtype.lastIndexOf("("));
				int foodnum = Integer.valueOf(foodtype.substring(foodtype.lastIndexOf("(")+1, foodtype.lastIndexOf(")")));
				for(int j = 0; j < foodnum; j++) {
					foodtypeList.add(foodtypeName);
				}
			}
			
			//转为Food,i为菜品的序号，j为菜品类型的需要
			for(int i = 0; i < maxSize; i++) {
				Food newFood =  new Food();
				newFood.setFood(foods.get(i));
				newFood.setPrice(RegexUtil.getIntFromString(prices.get(i)));
				newFood.setFoodtypes(foodtypeList.get(i));//如果长度不一样，就会报错
				foodlists.add(newFood);
			}
			restarantFood.setFoods(foodlists);
			
		}
		return restarantFood;
	}
	
	public static RestarantFoods elemeFoods(ResultItems resultItems) {
		return null;
	}
	
}
