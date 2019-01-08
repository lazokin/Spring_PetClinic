package com.lazokin.petclinic.controller;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.service.OwnerService;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	public ModelAndView showOwner(@PathVariable("id") Long id ) {
		ModelAndView mav = new ModelAndView("owners/details");
		mav.addObject(ownerService.findById(id));
		return mav;
	}
	
	@GetMapping()
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (owner.getLastName() == null) {
			owner.setLastName("");
		}
		Set<Owner> owners = this.ownerService.findAllByLastNameLike(owner.getLastName());
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

}
