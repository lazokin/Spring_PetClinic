package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Vet;

public interface VetRespository extends CrudRepository<Vet, Long> {

}
