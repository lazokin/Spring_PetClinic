package com.lazokin.petclinic.service.map.impl;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.PetTypeService;
import com.lazokin.petclinic.service.map.MapService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class MapPetService extends MapService<Pet, Long> implements PetService {
	
	private final PetTypeService petTypeService;

	public MapPetService(PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
	}

	@Override
	public Pet save(Pet pet) {
		if (pet.getPetType() != null) {
			if (pet.getPetType().getId() == null) {
				PetType savedPetType = this.petTypeService.save(pet.getPetType());
				pet.setPetType(savedPetType);
			}
		}
		return super.save(pet);
	}
	
}