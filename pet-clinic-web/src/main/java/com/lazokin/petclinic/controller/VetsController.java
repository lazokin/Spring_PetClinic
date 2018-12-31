package com.lazokin.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vets"})
public class VetsController {
	
	@RequestMapping({"", "/", "/index", "index.html"})
	public String index() {
		return "vets/index";
	}

}
