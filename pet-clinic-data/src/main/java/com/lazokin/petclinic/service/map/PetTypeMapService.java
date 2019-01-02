package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.PetTypeService;

import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}