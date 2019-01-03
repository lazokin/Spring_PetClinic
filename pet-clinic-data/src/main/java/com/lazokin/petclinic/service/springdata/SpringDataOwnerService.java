package com.lazokin.petclinic.service.springdata;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.repository.OwnerRepository;
import com.lazokin.petclinic.service.OwnerService;

@Service
@Profile("springdata")
public class SpringDataOwnerService implements OwnerService {
	
	private OwnerRepository repository;

	public SpringDataOwnerService(OwnerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		this.repository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		return this.repository.save(owner);
	}

	@Override
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public void delete(Owner owner) {
		this.repository.delete(owner);
		
	}

	@Override
	public Owner findByLastName(Long lastName) {
		return this.repository.findByLastName(lastName);
	}


}
