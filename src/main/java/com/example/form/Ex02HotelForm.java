package com.example.form;

import org.hibernate.validator.constraints.Range;

public class Ex02HotelForm {

	@Range(min=0, max=300000, message="値段の検索値が不正です")
	private Integer price;

	
	
	@Override
	public String toString() {
		return "Ex02HotelForm [price=" + price + "]";
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
