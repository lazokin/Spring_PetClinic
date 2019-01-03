package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Speciality;
import com.lazokin.petclinic.service.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}