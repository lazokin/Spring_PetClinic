package com.lazokin.petclinic.service.springdata.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.repository.PetTypeRepository;
import com.lazokin.petclinic.service.PetTypeService;
import com.lazokin.petclinic.service.springdata.SpringDataService;

@Service
@Profile("springdata")
public class SpringDataPetTypeService extends SpringDataService<PetType, Long> implements PetTypeService {

	public SpringDataPetTypeService(PetTypeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public PetType findByName(String name) {
		return ((PetTypeRepository) this.repository).findByName(name);
	}

}
