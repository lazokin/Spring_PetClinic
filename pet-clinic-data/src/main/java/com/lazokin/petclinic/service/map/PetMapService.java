package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.service.PetService;

public class PetMapService extends AbstractMapCrudService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet pet) {
		return super.save(pet.getId(), pet);
	}

}