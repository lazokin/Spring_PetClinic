package com.lazokin.petclinic.service.map;

import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}