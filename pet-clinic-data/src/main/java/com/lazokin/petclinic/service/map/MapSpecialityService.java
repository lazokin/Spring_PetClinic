package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class MapSpecialityService extends MapService<Specialty, Long> implements SpecialtyService {

}