package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapCrudService<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet vet) {
		return super.save(vet.getId(), vet);
	}

}