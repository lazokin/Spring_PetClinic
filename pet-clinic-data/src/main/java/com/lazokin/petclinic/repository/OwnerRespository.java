package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Owner;

public interface OwnerRespository extends CrudRepository<Owner, Long> {

}
