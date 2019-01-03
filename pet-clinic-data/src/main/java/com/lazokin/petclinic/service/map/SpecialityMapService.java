package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}