package com.lazokin.petclinic.service.map.impl;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.PetService;
import com.lazokin.petclinic.service.map.MapService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class MapOwnerService extends MapService<Owner, Long> implements OwnerService {
	
	private final PetService petService;
	
	public MapOwnerService(PetService petService) {
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.map.values().stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
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