package com.lazokin.petclinic.controller;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.service.OwnerService;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private final OwnerService service;

	public OwnerController(OwnerService ownerService) {
		this.service = ownerService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
	
	@RequestMapping("/find")
	public String find(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/find";
	}
	
	@GetMapping("/{id}")
	public ModelAndView showOwner(@PathVariable Long id ) {
		ModelAndView mav = new ModelAndView("owners/details");
		mav.addObject(service.findById(id));
		return mav;
	}
	
	@GetMapping()
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (owner.getLastName() == null) {
			owner.setLastName("");
		}
		Set<Owner> owners = service.findAllByLastNameLike(owner.getLastName());
		if (owners.isEmpty()) {
			result.rejectValue("lastName", "notFound", "not found");
			return "owners/find";
		} else if (owners.size() == 1) {
			owner = owners.iterator().next();
			return "redirect:/owners/" + owner.getId();
		} else {
			model.addAttribute("selections", owners);
			return "/owners/list";
		}
	}
	
	@GetMapping("/new")
	public String returnEmptyOwnerForm(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/form";
	}
	
	@PostMapping("/new")
	public String postNewOwnerForm(@Valid Owner owner, BindingResult result) {
		if (result.hasErrors()) {
			return "Invalid Owner";
		} else {
			Owner savedOwner = service.save(owner);
			return "redirect:/owners/" + savedOwner.getId();
		}
	}
	
	@GetMapping("/{id}/edit")
	public String returnExistingOwnerForm(@PathVariable Long id, Model model) {
		model.addAttribute("owner", service.findById(id));
		return "owners/form";
	}
	
	@PostMapping("/{id}/edit")
	public String postnExistingOwnerForm(@PathVariable Long id, @Valid Owner owner, BindingResult result) {
		if (result.hasErrors()) {
			return "Invalid Owner";
		} else {
			owner.setId(id);
			service.save(owner);
			return "redirect:/owners/" + id;
		}
	}

}
