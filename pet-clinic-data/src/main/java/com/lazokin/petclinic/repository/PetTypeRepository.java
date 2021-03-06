package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
	
	PetType findByName(String name);

}
