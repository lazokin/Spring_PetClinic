package com.lazokin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
