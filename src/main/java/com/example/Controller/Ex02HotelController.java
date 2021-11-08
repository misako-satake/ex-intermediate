package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.Ex02HotelService;
import com.example.domain.Ex02HotelDomain;

@Controller
@RequestMapping("/ex02")
public class Ex02HotelController {

	@Autowired
	private Ex02HotelService service;
	
	
	@RequestMapping("")
	public String index() {
		
		return "search-hotel";
	}
	
	@RequestMapping("/search")
	public String search(String price,Model model) {
		model.addAttribute("price", Integer.parseInt(price));
		
		if(price != null) {
			List<Ex02HotelDomain> hotelList= service.searchByLessThanPrice(Integer.parseInt(price));
			model.addAttribute("hotelList", hotelList);
			
			return "search-result";
		}
		List<Ex02HotelDomain> hotelList = service.showList();
		return "search-result";
			
	}
	
}
