package com.myselef.model;

import java.util.List;

public class RestarantFoods {
	
	private String restaurant;
	
	private String restaurantImage;
	
	private List<Food> foods;
	
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setRestaurantImage(String restaurantImage) {
		this.restaurantImage = restaurantImage;
	}
	public String getRestaurantImage() {
		return restaurantImage;
	}
}
