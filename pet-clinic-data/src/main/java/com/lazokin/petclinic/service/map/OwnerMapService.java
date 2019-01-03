package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.PetService;

import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private final PetService petService;
	
	public OwnerMapService(PetService petService) {
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(Long lastName) {
		return null;
	}

	@Override
	public Owner save(Owner owner) {
		if (owner.getPets() != null) {
			owner.getPets().forEach(pet -> {
				if (pet.getId() == null) {
					Pet savedPet = this.petService.save(pet);
					pet.setId(savedPet.getId());
				}
			});
		}
		return super.save(owner);
	}
}