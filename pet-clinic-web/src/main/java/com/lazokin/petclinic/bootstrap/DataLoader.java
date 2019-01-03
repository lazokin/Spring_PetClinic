package com.lazokin.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.PetTypeService;
import com.lazokin.petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) {
		
		PetType dogType = new PetType();
		dogType.setName("Dog");
		petTypeService.save(dogType);
		
		PetType catType = new PetType();
		catType.setName("Cat");
		petTypeService.save(catType);
		
		Pet dog = new Pet();
		dog.setPetType(dogType);
		dog.setName("Buster");
		dog.setBirthDate(LocalDate.now());
		
		Pet cat = new Pet();
		cat.setPetType(catType);
		cat.setName("Pus");
		cat.setBirthDate(LocalDate.now());
		
		Owner dogOwner = new Owner();
		dogOwner.setFirstName("John");
		dogOwner.setLastName("Doe");
		dogOwner.setAddress("1 Main St");
		dogOwner.setCity("Somewhere");
		dogOwner.setTelephone("123456789");
		dogOwner.getPets().add(dog);
		dog.setOwner(dogOwner);
		ownerService.save(dogOwner);
		
		Owner catOwner = new Owner();
		catOwner.setFirstName("Jane");
		catOwner.setLastName("Doe");
		catOwner.setAddress("1 Main St");
		catOwner.setCity("Somewhere");
		catOwner.setTelephone("123456789");
		catOwner.getPets().add(cat);
		cat.setOwner(catOwner);
		ownerService.save(catOwner);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("James");
		vet1.setLastName("Anderson");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Mary");
		vet2.setLastName("Sue");
		vetService.save(vet2);
		
	}

}
