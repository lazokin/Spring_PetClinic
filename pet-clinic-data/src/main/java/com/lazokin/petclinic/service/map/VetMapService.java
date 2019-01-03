package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.service.SpecialtyService;
import com.lazokin.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
	
	private final SpecialtyService specialtyService;
	
	public VetMapService(SpecialtyService specialtyService) {
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