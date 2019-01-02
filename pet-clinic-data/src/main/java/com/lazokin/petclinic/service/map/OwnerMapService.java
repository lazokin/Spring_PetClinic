package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(Long lastName) {
		return null;
	}

}