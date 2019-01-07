package com.lazokin.petclinic.controller;

import com.lazokin.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"", "/", "/index", "index.html"})
	public String index(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String find(Model model) {
		return "todo";
	}
	
	@GetMapping("/{id}")
	public ModelAndView showOwner(@PathVariable("id") Long id ) {
		ModelAndView mav = new ModelAndView("owners/details");
		mav.addObject(ownerService.findById(id));
		return mav;
	}

}
