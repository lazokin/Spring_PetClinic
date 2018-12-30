package com.lazokin.petclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lazokin.petclinic.service.CrudService;

public abstract class AbstractMapCrudService<T, ID> implements CrudService<T, ID> {
	
	protected Map<ID, T> map = new HashMap<>();
	
	@Override
	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	@Override
	public T findById(ID id) {
		return map.get(id);
	}
	
	@Override
	public void deleteById(ID id) {
		map.remove(id);
	}
	
	@Override
	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	protected T save(ID id, T object) {
		map.put(id, object);
		return object;
	}

}
