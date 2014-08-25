package com.myselef.model;

public class Food {

	private String foodtypes;

	private String food;

	private int price;
	
	private Image image;

	public void setFoodtypes(String foodtypes) {
		this.foodtypes = foodtypes;
	}

	public String getFoodtypes() {
		return foodtypes;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getFood() {
		return food;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		return "Foods{" + "foodtypes="
				+ foodtypes + ", food=" + food + ", price=" + price + '}';
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

}
