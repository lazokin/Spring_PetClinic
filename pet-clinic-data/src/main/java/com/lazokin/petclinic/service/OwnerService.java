package com.lazokin.petclinic.service;

import java.util.Set;

import com.lazokin.petclinic.model.Owner;

public interface OwnerService {

	Owner findById(long id);
	
	Owner findByLastName(long lastName);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	
}
