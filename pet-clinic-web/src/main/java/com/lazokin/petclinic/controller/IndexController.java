package com.lazokin.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/oups")
	public String oups(Model model) {
		return "todo";
	}

}
