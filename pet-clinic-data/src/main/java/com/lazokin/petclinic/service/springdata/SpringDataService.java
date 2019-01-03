package com.lazokin.petclinic.service.springdata;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.service.CrudService;

public abstract class SpringDataService<T, ID> implements CrudService<T, ID> {
	
	protected CrudRepository<T, ID> repository;

	@Override
	public Set<T> findAll() {
		Set<T> set = new HashSet<>();
		this.repository.findAll().forEach(set::add);
		return set;
	}

	@Override
	public T findById(ID id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public T save(T object) {
		return this.repository.save(object);
	}

	@Override
	public void deleteById(ID id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public void delete(T object) {
		this.repository.delete(object);
	}

}
