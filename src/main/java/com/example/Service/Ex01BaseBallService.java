package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.Ex01BaseballRepository;
import com.example.domain.Ex01BaseballDomain;

@Service
public class Ex01BaseBallService {

	@Autowired
	private Ex01BaseballRepository repository;
	
	public List<Ex01BaseballDomain> showList(){
		
		List<Ex01BaseballDomain> baseballList = repository.findAll();
		return baseballList;
	}
	
	public Ex01BaseballDomain showDetail(Integer id) {
		Ex01BaseballDomain baseballDomain = repository.load(id);
		return baseballDomain;
	}
	
}
