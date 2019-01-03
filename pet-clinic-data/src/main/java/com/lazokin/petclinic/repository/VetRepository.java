package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
