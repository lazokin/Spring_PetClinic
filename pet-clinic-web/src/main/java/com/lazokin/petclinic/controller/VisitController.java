package com.lazokin.petclinic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.model.Visit;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.VisitService;

@Controller
public class VisitController {
	
	private final VisitService visitService;
	private final PetService petService;
	
	public VisitController(VisitService visitService, PetService petService) {
		this.visitService = visitService;
		this.petService = petService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable Long petId, Model model) {
		Pet pet = petService.findById(petId);
		model.addAttribute("pet", pet);
		Visit visit = Visit.builder().build();
		pet.addVisit(visit);
		return visit;
	}
	
	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable Long petId, Model model) {
		return "visits/form";
	}
	
	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid Visit visit, @PathVariable Long ownerId, BindingResult result) {
		if (result.hasErrors()) {
			return "visits/form";
		} else {
			visitService.save(visit);
			return "redirect:/owners/" + ownerId;
		}
	}

}
