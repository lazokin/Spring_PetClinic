package com.lazokin.petclinic.service;

import com.lazokin.petclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(Long lastName);
	
}
