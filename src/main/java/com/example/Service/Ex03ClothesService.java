package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.Ex03ClothesRepository;
import com.example.domain.Ex03ClothesDomain;

@Service
public class Ex03ClothesService {

	@Autowired
	private Ex03ClothesRepository repository;
	
	public List<Ex03ClothesDomain> searchByColorAndGender(Integer gender,String color){
		List<Ex03ClothesDomain> clothesList = repository.loadByColorAndGender(gender, color);
		return clothesList;
	}
	
	
}
