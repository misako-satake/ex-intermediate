package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.Ex03ClothesService;
import com.example.domain.Ex03ClothesDomain;
import com.example.form.Ex03ClothesForm;

@Controller
@RequestMapping("/ex03")
public class Ex03ClothesController {

	@Autowired
	private Ex03ClothesService service;
	
	@ModelAttribute
	public Ex03ClothesForm setUpForm() {
		return new Ex03ClothesForm();
	};
	
	@RequestMapping("")
	public String index(Model model) {
		return "search-clothes";
	}
	
	@RequestMapping("/search")
	public String search(Ex03ClothesForm ex03ClothesForm,Model model) {
		List<Ex03ClothesDomain> clothesList 
		= service.searchByColorAndGender(ex03ClothesForm.getGender(), ex03ClothesForm.getColor());
		System.out.println(ex03ClothesForm.getGender());
		System.out.println(ex03ClothesForm.getColor());
		model.addAttribute("clothesList", clothesList);
		
		List<Ex03ClothesDomain> clothesList0 = new ArrayList<Ex03ClothesDomain>();
		model.addAttribute("clothesList0", clothesList0);
		
		return "search-clothes";
	}
}
