package com.lazokin.petclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.lazokin.petclinic.model.BaseEntity;
import com.lazokin.petclinic.service.CrudService;

public abstract class MapService<T extends BaseEntity, ID> implements CrudService<T, ID> {
	
	protected Map<Long, T> map = new HashMap<>();
	
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

	@Override
	public T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		map.put(object.getId(), object);
		return object;
	}

	private Long getNextId() {
		Long nextId = null;
		try {
			nextId = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			nextId = 1L;
		}
		return nextId;
	}

}
