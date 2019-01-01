package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapCrudService<Pet, Long> implements PetService {

}