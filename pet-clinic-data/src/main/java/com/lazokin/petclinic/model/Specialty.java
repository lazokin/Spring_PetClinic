package com.lazokin.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "specialty")
public class Specialty extends NamedEntity {
	
	@Builder
	public Specialty(Long id, String name) {
		super(id, name);
	}
	
}
