package com.lazokin.petclinic.service;

import java.util.Set;

import com.lazokin.petclinic.model.Pet;

public interface PetService {

	Pet findById(long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
	
}
