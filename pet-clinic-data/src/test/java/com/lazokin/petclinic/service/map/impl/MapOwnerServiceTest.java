package com.lazokin.petclinic.service.map.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lazokin.petclinic.model.Owner;

class MapOwnerServiceTest {

	MapOwnerService service;
	
	private final Long ID_1 = 1L;
	private final Long ID_2 = 2L;
	private final String LAST_NAME = "Stark";
	
	@BeforeEach
	void beforeEach() {
		service = new MapOwnerService(new MapPetService(new MapPetTypeService()));
		service.save(Owner.builder().id(ID_1).lastName(LAST_NAME).build());
	}
	
	@Test
	void finaAll() {
		assertEquals(1, service.findAll().size());
	}
	
	@Test
	void findById() {
		assertEquals(ID_1, service.findById(ID_1).getId());
	}
	
	@Test
	void saveWithId() {
		assertEquals(ID_2, service.save(Owner.builder().id(ID_2).build()).getId());
	}
	
	@Test
	void saveWithoutId() {
		Owner owner = service.save(Owner.builder().build());
		assertEquals(ID_2, owner.getId());
	}
	
	@Test
	void delete() {
		service.delete(service.findById(ID_1));
		assertEquals(0, service.findAll().size());
	}
	
	@Test
	void deleteById() {
		service.deleteById(ID_1);
		assertEquals(0, service.findAll().size());
	}
	
	@Test
	void findByLastNamePass() {
		assertEquals(LAST_NAME, service.findByLastName(LAST_NAME).getLastName());
	}
	
	@Test
	void findByLastNameFail() {
		assertNull(service.findByLastName("foobar"));
	}

}
