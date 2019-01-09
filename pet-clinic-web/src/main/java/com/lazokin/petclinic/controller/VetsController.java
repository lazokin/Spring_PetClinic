package com.lazokin.petclinic.controller;

import com.lazokin.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

	private final VetService vetService;

	public VetsController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping("vets.html")
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/list";
	}

}
