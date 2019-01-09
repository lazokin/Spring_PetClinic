package com.lazokin.petclinic.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.VisitService;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
	
	@Mock
	VisitService visitService;
	
	@Mock
	PetService petService;
	
	@InjectMocks
	VisitController controller;
	
	Pet pet;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void beforeEach() {
		pet = Pet.builder().build();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void getNewForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);
		mockMvc.perform(get("/owners/1/pets/1/visits/new"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("visit"))
			.andExpect(view().name("visits/form"));
	}
	
	@Test
	void postNewForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);
		mockMvc.perform(post("/owners/1/pets/1/visits/new")
				.param("date", "2018-01-01")
				.param("desciption", "my pet is sick"))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().attributeExists("visit"))
			.andExpect(view().name("redirect:/owners/1"));
	}

}
