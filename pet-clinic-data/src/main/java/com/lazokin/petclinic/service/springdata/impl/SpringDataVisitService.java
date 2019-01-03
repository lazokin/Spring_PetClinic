package com.lazokin.petclinic.service.springdata.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Visit;
import com.lazokin.petclinic.repository.VisitRepository;
import com.lazokin.petclinic.service.VisitService;
import com.lazokin.petclinic.service.springdata.SpringDataService;

@Service
@Profile("springdata")
public class SpringDataVisitService extends SpringDataService<Visit, Long> implements VisitService {

	public SpringDataVisitService(VisitRepository repository) {
		this.repository = repository;
	}

}
