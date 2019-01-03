package com.lazokin.petclinic.service.springdata.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.repository.PetRepository;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.springdata.SpringDataService;

@Service
@Profile("springdata")
public class SpringDataPetService extends SpringDataService<Pet, Long> implements PetService {

	public SpringDataPetService(PetRepository repository) {
		this.repository = repository;
	}

}
