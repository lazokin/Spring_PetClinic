package com.lazokin.petclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
	
	Owner owner;
	Set<Owner> owners;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void beforeEach() {
		owner = Owner.builder().id(1L).build();
		owners = Set.of(Owner.builder().id(1L).build(), Owner.builder().id(2L).build());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void showOwner() throws Exception {
		when(service.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
		mockMvc.perform(get("/owners/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/details"))
			.andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void findOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/find"))
			.andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void listMultipleOwners() throws Exception {
		when(service.findAllByLastNameLike(anyString())).thenReturn(owners);
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("/owners/list"))
			.andExpect(model().attribute("selections", hasSize(2)));
	}
	
	@Test
	void listSingleOwners() throws Exception {
		when(service.findAllByLastNameLike(anyString())).thenReturn(Set.of(Owner.builder().id(1L).build()));
		mockMvc.perform(get("/owners"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"))
			.andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void listNoOwners() throws Exception {
		when(service.findAllByLastNameLike(anyString())).thenReturn(Collections.emptySet());
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/find"));
	}
	
	@Test
	void getNewForm() throws Exception {
		mockMvc.perform(get("/owners/new"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/form"))
			.andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void getEditForm() throws Exception {
		when(service.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
		mockMvc.perform(get("/owners/1/edit"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/form"))
			.andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void postNewForm() throws Exception {
		when(service.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1L).build());
		mockMvc.perform(post("/owners/new"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"))
			.andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void postEditForm() throws Exception {
		when(service.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1L).build());
		mockMvc.perform(post("/owners/1/edit"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"))
			.andExpect(model().attributeExists("owner"));
	}

}
