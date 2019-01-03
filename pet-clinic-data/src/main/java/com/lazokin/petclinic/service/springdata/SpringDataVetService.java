package com.lazokin.petclinic.service.springdata;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.repository.VetRepository;
import com.lazokin.petclinic.service.VetService;

@Service
@Profile("springdata")
public class SpringDataVetService implements VetService {
	
	private VetRepository repository;

	public SpringDataVetService(VetRepository repository) {
		this.repository = repository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		this.repository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet vet) {
		return this.repository.save(vet);
	}

	@Override
	public void deleteById(Long id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public void delete(Vet vet) {
		this.repository.delete(vet);
	}

}
