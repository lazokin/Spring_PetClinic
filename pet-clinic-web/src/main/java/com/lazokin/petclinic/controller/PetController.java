package com.lazokin.petclinic.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.Pet;
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
	
	@ModelAttribute("petTypes")
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
	
	@GetMapping("/pets/new")
	public String getNewPetForm(Owner owner, Model model) {
		Pet pet = Pet.builder().build();
		owner.addPet(pet);
		model.addAttribute("pet", pet);
		return "pets/form";
	}
	
	@PostMapping("/pets/new")
	public String postNewPetForm(@Valid Pet pet, Owner owner, BindingResult result, Model model) {
		if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
			result.rejectValue("name", "duplicate", "already exists");
		}
		owner.getPets().add(pet);
		if (result.hasErrors()) {
			model.addAttribute("pet", pet);
			return "pets/form";
		} else {
			petService.save(pet);
			return "redirect:/owners/" + owner.getId();
		}
	}
	
	@GetMapping("/pets/{petId}/edit")
	public String getUpdatePetForm(@PathVariable Long petId, Model model) {
		model.addAttribute("pet", petService.findById(petId));
		return "pets/form";
	}
	
	@PostMapping("/pets/{petId}/edit")
	public String postUpdatePetForm(@Valid Pet pet, Owner owner, BindingResult result, Model model) {
		if (result.hasErrors()) {
			pet.setOwner(owner);
			model.addAttribute("pet", pet);
			return "pets/form";
		} else {
			owner.getPets().add(pet);
			petService.save(pet);
			return "redirect:/owners/" + owner.getId();
		}
	}
	
}
