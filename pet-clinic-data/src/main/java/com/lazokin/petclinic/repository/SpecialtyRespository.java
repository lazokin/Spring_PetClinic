package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Specialty;

public interface SpecialtyRespository extends CrudRepository<Specialty, Long> {

}
