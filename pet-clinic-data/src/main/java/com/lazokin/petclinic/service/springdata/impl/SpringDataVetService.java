package com.lazokin.petclinic.service.springdata.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.repository.VetRepository;
import com.lazokin.petclinic.service.VetService;
import com.lazokin.petclinic.service.springdata.SpringDataService;

@Service
@Profile("springdata")
public class SpringDataVetService extends SpringDataService<Vet, Long> implements VetService {

	public SpringDataVetService(VetRepository repository) {
		this.repository = repository;
	}

}
