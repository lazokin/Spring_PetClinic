package com.lazokin.petclinic.service.springdata;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.repository.PetTypeRepository;
import com.lazokin.petclinic.service.PetTypeService;

@Service
@Profile("springdata")
public class SpringDataPetTypeService extends SpringDataService<PetType, Long> implements PetTypeService {

	public SpringDataPetTypeService(PetTypeRepository repository) {
		this.repository = repository;
	}

}
