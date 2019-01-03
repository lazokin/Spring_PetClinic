package com.lazokin.petclinic.service.map.impl;

import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.service.SpecialtyService;
import com.lazokin.petclinic.service.map.MapService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class MapSpecialityService extends MapService<Specialty, Long> implements SpecialtyService {

}