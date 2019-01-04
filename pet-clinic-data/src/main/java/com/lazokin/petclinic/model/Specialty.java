package com.lazokin.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialty")
public class Specialty extends BaseEntity {
	
	@Builder
	public Specialty(Long id, String name) {
		super(id);
		this.name = name;
	}

	@Column(name = "name")
	private String name;

}
