package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.PetTypeService;

import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
	
	private final PetTypeService petTypeService;

	public PetMapService(PetTypeService petTypeService) {
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