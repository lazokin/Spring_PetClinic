package com.lazokin.petclinic.service.springdata;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.repository.PetRepository;
import com.lazokin.petclinic.service.PetService;

@Service
@Profile("springdata")
public class SpringDataPetService extends SpringDataService<Pet, Long> implements PetService {

	public SpringDataPetService(PetRepository repository) {
		this.repository = repository;
	}

}
