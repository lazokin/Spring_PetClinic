package com.lazokin.petclinic.service;

import java.util.Set;

import com.lazokin.petclinic.model.Vet;

public interface VetService {

	Vet findById(long id);
		
	Vet save(Vet vet);
	
	Set<Vet> findAll();
	
}
