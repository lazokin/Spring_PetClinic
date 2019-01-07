package com.lazokin.petclinic.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.lazokin.petclinic.service.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService service;
	
	@InjectMocks
	OwnerController controller;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void beforeEach() {
		owners = Set.of(Owner.builder().id(1L).build(), Owner.builder().id(2L).build());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void listOwners() throws Exception {
		when(service.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/index"))
			.andExpect(model().attributeExists("owners"));
	}
	
	@Test
	void showOwner() throws Exception {
		when(service.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
		mockMvc.perform(get("/owners/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/details"))
			.andExpect(model().attributeExists("owner"));
	}

}
