package com.lazokin.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lazokin.petclinic.model.Owner;
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
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDog = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCat = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Nikolce");
		owner1.setLastName("Ambukovski");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Mende");
		owner2.setLastName("Cvetkovski");
		ownerService.save(owner2);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Pece");
		vet1.setLastName("Kuzmanovski");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Goce");
		vet2.setLastName("Petrovski");
		vetService.save(vet2);
		
	}

}
