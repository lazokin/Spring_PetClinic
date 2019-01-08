package com.lazokin.petclinic.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.PetTypeService;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {
	
	@Mock
	PetService petService;
	
	@Mock
	PetTypeService petTypeService;
	
	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	PetController controller;
	
	Pet pet;
	Owner owner;
	Set<PetType> petTypes;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void beforeEach() {
		pet = Pet.builder().id(1L).build();
		owner = Owner.builder().id(1L).build();
		petTypes = Set.of(PetType.builder().id(1L).name("Dog").build(), PetType.builder().id(2L).name("Cat").build());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void getNewForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		mockMvc.perform(get("/owners/1/pets/new"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("owner"))
			.andExpect(model().attributeExists("pet"))
			.andExpect(view().name("pets/form"));
	}
	
	@Test
	void getEditForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);
		mockMvc.perform(get("/owners/1/pets/1/edit"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("pet"))
			.andExpect(view().name("pets/form"));
	}
	
	@Test
	void postNewForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		mockMvc.perform(post("/owners/1/pets/new"))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().attributeExists("pet"))
			.andExpect(view().name("redirect:/owners/1"));
	}
	
	@Test
	void postUpdateForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		mockMvc.perform(post("/owners/1/pets/1/edit"))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().attributeExists("pet"))
			.andExpect(view().name("redirect:/owners/1"));
	}

}
