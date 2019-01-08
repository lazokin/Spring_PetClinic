package com.lazokin.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class NamedEntity extends BaseEntity {

	public NamedEntity(Long id, String name) {
		super(id);
		this.name = name;
	}

	@Column(name = "name")
	private String name;
	
	@Override
    public String toString() {
        return this.getName();
    }

}
