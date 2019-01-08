package com.lazokin.petclinic.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);
	
	Set<Owner> findAllByLastNameLike(String lastName);

}
