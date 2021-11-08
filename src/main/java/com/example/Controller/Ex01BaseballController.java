package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.Ex01BaseBallService;
import com.example.domain.Ex01BaseballDomain;

@Controller
@RequestMapping("/ex01")
public class Ex01BaseballController {

	@Autowired
	private Ex01BaseBallService service;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("baseballList",service.showList());
		
		for(Ex01BaseballDomain ball:service.showList()) {
			System.out.println(ball);
		}
		return "baseball-list";
	}
	
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		Ex01BaseballDomain baseball = service.showDetail(id);
		model.addAttribute("ex01BaseballDomain", baseball);
		
		return "baseball-detail";
	}
	
}
