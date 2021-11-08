package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.Ex02HotelRepository;
import com.example.domain.Ex02HotelDomain;

@Service
public class Ex02HotelService {

	@Autowired
	private Ex02HotelRepository repository;
	
	public List<Ex02HotelDomain> showList(){
		List<Ex02HotelDomain> hotelList = repository.findAll();
		return hotelList;
	}
	
	public List<Ex02HotelDomain> searchByLessThanPrice(Integer price){
		List<Ex02HotelDomain> hotelList = repository.loadByLessThanPrice(price);
		return hotelList;
	}
	
	
}
