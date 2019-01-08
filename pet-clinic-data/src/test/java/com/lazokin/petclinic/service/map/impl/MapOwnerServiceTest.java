package com.lazokin.petclinic.service.map.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lazokin.petclinic.model.Owner;

class MapOwnerServiceTest {

	MapOwnerService service;
	
	private final Long ID_1 = 1L;
	private final Long ID_2 = 2L;
	private final Long ID_3 = 3L;
	private final Long ID_4 = 4L;
	private final String LAST_NAME_1 = "Stark";
	private final String LAST_NAME_2 = "Stark";
	private final String LAST_NAME_3 = "Lannister";
	private final String LAST_NAME_4 = "Baratheon";
	
	@BeforeEach
	void beforeEach() {
		service = new MapOwnerService(new MapPetService(new MapPetTypeService()));
		service.save(Owner.builder().id(ID_1).lastName(LAST_NAME_1).build());
		service.save(Owner.builder().id(ID_2).lastName(LAST_NAME_2).build());
		service.save(Owner.builder().id(ID_3).lastName(LAST_NAME_3).build());
	}
	
	@Test
	void finaAll() {
		assertEquals(3, service.findAll().size());
	}
	
	@Test
	void findById() {
		assertEquals(ID_1, service.findById(ID_1).getId());
	}
	
	@Test
	void saveWithId() {
		assertEquals(ID_4, service.save(Owner.builder().id(ID_4).build()).getId());
	}
	
	@Test
	void saveWithoutId() {
		Owner owner = service.save(Owner.builder().build());
		assertEquals(ID_4, owner.getId());
	}
	
	@Test
	void delete() {
		service.delete(service.findById(ID_3));
		assertEquals(2, service.findAll().size());
	}
	
	@Test
	void deleteById() {
		service.deleteById(ID_3);
		assertEquals(2, service.findAll().size());
	}
	
	@Test
	void findByLastNamePass() {
		assertEquals(LAST_NAME_1, service.findByLastName(LAST_NAME_1).getLastName());
	}
	
	@Test
	void findByLastNameFail() {
		assertNull(service.findByLastName(LAST_NAME_4));
	}
	
	@Test
	void findAllByLastNameMany() {
		assertEquals(2, service.findAllByLastNameLike(LAST_NAME_1).size());
	}
	
	@Test
	void findAllByLastNameOne() {
		assertEquals(1, service.findAllByLastNameLike(LAST_NAME_3).size());
	}
	
	@Test
	void findAllByLastNameNone() {
		assertTrue(service.findAllByLastNameLike(LAST_NAME_4).isEmpty());
	}
	

}
