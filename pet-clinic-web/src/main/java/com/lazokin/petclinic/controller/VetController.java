package com.lazokin.petclinic.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.service.VetService;

@Controller
public class VetController {

	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping("vets.html")
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/list";
	}
	
	@GetMapping("/api/vets")
	public @ResponseBody Set<Vet> getVets() {
		return vetService.findAll();
	}

}
