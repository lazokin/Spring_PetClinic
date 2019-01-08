package com.lazokin.petclinic.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Owner;

@Service
public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
	Set<Owner> findAllByLastNameLike(String lastName);
	
}
