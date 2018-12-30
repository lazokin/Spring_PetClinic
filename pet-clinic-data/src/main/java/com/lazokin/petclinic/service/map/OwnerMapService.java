package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.service.OwnerService;

public class OwnerMapService extends AbstractMapCrudService<Owner, Long> implements OwnerService {

	@Override
	public Owner save(Owner owner) {
		return super.save(owner.getId(), owner);
	}

	@Override
	public Owner findByLastName(Long lastName) {
		return null;
	}

}