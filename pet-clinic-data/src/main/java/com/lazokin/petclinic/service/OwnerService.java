package com.lazokin.petclinic.service;

import com.lazokin.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(Long lastName);
	
}
