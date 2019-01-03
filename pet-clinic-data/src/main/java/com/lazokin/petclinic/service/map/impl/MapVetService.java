package com.lazokin.petclinic.service.map.impl;

import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.service.SpecialtyService;
import com.lazokin.petclinic.service.VetService;
import com.lazokin.petclinic.service.map.MapService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class MapVetService extends MapService<Vet, Long> implements VetService {
	
	private final SpecialtyService specialtyService;
	
	public MapVetService(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet vet) {
		if (vet.getSpecialities() != null) {
			vet.getSpecialities().forEach(specialty -> {
				if (specialty.getId() == null) {
					Specialty savedSpecialty = this.specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(vet);
	}
	
}