package com.example.form;

public class Ex03ClothesForm {

	private Integer gender;
	private String color;
	
	
	
	@Override
	public String toString() {
		return "Ex03ClothesForm [gender=" + gender + ", color=" + color + "]";
	}
	
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
