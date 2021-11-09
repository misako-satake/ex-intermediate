package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.Ex02HotelService;
import com.example.domain.Ex02HotelDomain;
import com.example.form.Ex02HotelForm;

@Controller
@RequestMapping("/ex02")
public class Ex02HotelController {

	@Autowired
	private Ex02HotelService service;
	
	@ModelAttribute
	public Ex02HotelForm setUpForm() {
		return new Ex02HotelForm();
	}
	
	@RequestMapping("")
	public String index() {
		
		return "search-hotel";
	}
	
	@RequestMapping("/search")
	public String search(@Validated Ex02HotelForm ex02HotelForm,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return index();
		}
		model.addAttribute("ex02HotelForm", ex02HotelForm);
		
		if(ex02HotelForm.getPrice() != null) {
			List<Ex02HotelDomain> hotelList= service.searchByLessThanPrice(ex02HotelForm.getPrice());
			model.addAttribute("hotelList", hotelList);
			
			return "search-hotel";
		}
		List<Ex02HotelDomain> hotelList = service.showList();
		model.addAttribute("hotelList", hotelList);
		return "search-hotel";
			
	}
	
}
