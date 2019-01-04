package com.lazokin.petclinic.service.springdata.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.repository.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class SpringDataOwnerServiceTest {
	
	@Mock
	private OwnerRepository repository;
	
	@InjectMocks
	private SpringDataOwnerService service;
	
	private final Long ID_1 = 1L;
	private final Long ID_2 = 2L;
	private final String LAST_NAME = "Stark";
	
	@BeforeEach
	void behoreEach() {
		
	}

	@Test
	void findAll() {
		when(repository.findAll()).thenReturn(Set.of(Owner.builder().build()));
		assertEquals(1, service.findAll().size());
	}

	@Test
	void findById() {
		when(repository.findById(eq(ID_1))).thenReturn(Optional.of(Owner.builder().id(ID_1).build()));
		assertEquals(ID_1, service.findById(ID_1).getId());
	}
	
	@Test
	void saveWithId() {
		Owner owner = Owner.builder().id(ID_2).build();
		when(repository.save(eq(owner))).thenReturn(owner);
		assertEquals(ID_2, service.save(owner).getId());
	}
	
	@Test
	void saveWithoutId() {
		Owner owner = Owner.builder().build();
		when(repository.save(eq(owner))).thenReturn(Owner.builder().id(ID_2).build());
		assertEquals(ID_2, service.save(owner).getId());
	}
	
	@Test
	void delete() {
		service.delete(Owner.builder().id(ID_1).build());
		verify(repository).delete(any());
	}
	
	@Test
	void deleteById() {
		service.deleteById(ID_1);
		verify(repository).deleteById(eq(ID_1));
	}
	
	@Test
	void findByLastNamePass() {
		when(repository.findByLastName(eq(LAST_NAME))).thenReturn(Owner.builder().lastName(LAST_NAME).build());
		assertEquals(LAST_NAME, service.findByLastName(LAST_NAME).getLastName());
	}
	
	@Test
	void findByLastNameFail() {
		when(repository.findByLastName(not(eq(LAST_NAME)))).thenReturn(null);
		assertNull(service.findByLastName("foobar"));
	}

}
