package com.lazokin.petclinic.service.map.impl;

import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.PetTypeService;
import com.lazokin.petclinic.service.map.MapService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class MapPetTypeService extends MapService<PetType, Long> implements PetTypeService {

	@Override
	public PetType findByName(String name) {
		return this.map.values().stream()
				.filter(petType -> petType.getName().equals(name))
				.findFirst()
				.orElse(null);
	}

}