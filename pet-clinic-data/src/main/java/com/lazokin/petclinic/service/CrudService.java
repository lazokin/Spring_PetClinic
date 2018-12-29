package com.lazokin.petclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {

	Set<T> findAll();
	
	T findById(ID id);
	
	T save(T object);
	
	void delete(ID id);
	
}
