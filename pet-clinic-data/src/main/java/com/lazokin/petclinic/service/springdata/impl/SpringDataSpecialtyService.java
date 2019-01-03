package com.lazokin.petclinic.service.springdata.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.repository.SpecialtyRepository;
import com.lazokin.petclinic.service.SpecialtyService;
import com.lazokin.petclinic.service.springdata.SpringDataService;

@Service
@Profile("springdata")
public class SpringDataSpecialtyService extends SpringDataService<Specialty, Long> implements SpecialtyService {

	public SpringDataSpecialtyService(SpecialtyRepository repository) {
		this.repository = repository;
	}

}
