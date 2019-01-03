package com.lazokin.petclinic.service.map.impl;

import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.PetTypeService;
import com.lazokin.petclinic.service.map.MapService;

import org.springframework.stereotype.Service;

@Service
public class MapPetTypeService extends MapService<PetType, Long> implements PetTypeService {

}