package com.lazokin.petclinic.service.map.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

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
		Set<Owner> owners = service.findAll();
		assertEquals(1, owners.size());
	}
	
	@Test
	void findById() {
		Owner owner = service.findById(1L);
		assertEquals(ID_1, owner.getId());
	}
	
	@Test
	void saveWithId() {
		Owner owner = service.save(Owner.builder().id(ID_2).build());
		assertEquals(ID_2, owner.getId());
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
		Owner owner = service.findByLastName(LAST_NAME);
		assertNotNull(owner);
		assertEquals(LAST_NAME, owner.getLastName());
	}
	
	@Test
	void findByLastNameFail() {
		Owner owner = service.findByLastName("foobar");
		assertNull(owner);
	}

}
