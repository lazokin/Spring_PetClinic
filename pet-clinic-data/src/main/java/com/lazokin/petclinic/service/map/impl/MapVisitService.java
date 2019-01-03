package com.lazokin.petclinic.service.map.impl;

import org.springframework.stereotype.Service;

import com.lazokin.petclinic.model.Visit;
import com.lazokin.petclinic.service.VisitService;
import com.lazokin.petclinic.service.map.MapService;

@Service
public class MapVisitService extends MapService<Visit, Long> implements VisitService {
	
}