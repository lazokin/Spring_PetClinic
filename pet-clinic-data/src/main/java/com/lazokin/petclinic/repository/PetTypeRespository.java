package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.PetType;

public interface PetTypeRespository extends CrudRepository<PetType, Long> {

}
