package com.lazokin.petclinic.service.springdata.impl;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.repository.OwnerRepository;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.springdata.SpringDataService;

@Service
@Profile("springdata")
public class SpringDataOwnerService extends SpringDataService<Owner, Long> implements OwnerService {

	public SpringDataOwnerService(OwnerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ((OwnerRepository) this.repository).findByLastName(lastName);
	}

	@Override
	public Set<Owner> findAllByLastNameLike(String lastName) {
		return ((OwnerRepository) this.repository).findAllByLastNameLike("%" + lastName + "%");
	}

}
