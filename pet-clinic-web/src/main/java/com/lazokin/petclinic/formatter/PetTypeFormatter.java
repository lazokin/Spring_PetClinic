package com.lazokin.petclinic.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.service.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType> {
	
	private final PetTypeService service;

	public PetTypeFormatter(PetTypeService service) {
		this.service = service;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String name, Locale locale) throws ParseException {
		return service.findByName(name);
	}

}
