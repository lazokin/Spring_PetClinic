package com.lazokin.petclinic.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final OwnerService ownerService;
	
	public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
	}
	
	@ModelAttribute("types")
	public Collection<PetType> getPetTypes() {
		return petTypeService.findAll();
	}
	
	@ModelAttribute("owner")
	public Owner getOwner(@PathVariable Long ownerId) {
		return ownerService.findById(ownerId);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
	
}
