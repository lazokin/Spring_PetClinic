package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Pet;

public interface PetRespository extends CrudRepository<Pet, Long> {

}
