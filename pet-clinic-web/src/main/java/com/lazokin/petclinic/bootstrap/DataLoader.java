package com.lazokin.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lazokin.petclinic.model.Owner;
import com.lazokin.petclinic.model.Pet;
import com.lazokin.petclinic.model.PetType;
import com.lazokin.petclinic.model.Specialty;
import com.lazokin.petclinic.model.Vet;
import com.lazokin.petclinic.model.Visit;
import com.lazokin.petclinic.service.OwnerService;
import com.lazokin.petclinic.service.PetTypeService;
import com.lazokin.petclinic.service.SpecialtyService;
import com.lazokin.petclinic.service.VetService;
import com.lazokin.petclinic.service.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) {
		if (databaseEmpty()) {
			loadData();
		}	
	}

	private boolean databaseEmpty() {
		return petTypeService.findAll().isEmpty();
	}

	private void loadData() {
		PetType dogType = new PetType();
		dogType.setName("Dog");
		PetType savedDogType = petTypeService.save(dogType);
		
		PetType catType = new PetType();
		catType.setName("Cat");
		PetType savedCatType = petTypeService.save(catType);
		
		Pet dog = new Pet();
		dog.setPetType(savedDogType);
		dog.setName("Buster");
		dog.setBirthDate(LocalDate.now());
		
		Pet cat = new Pet();
		cat.setPetType(savedCatType);
		cat.setName("Pus");
		cat.setBirthDate(LocalDate.now());
		
		Owner dogOwner = new Owner();
		dogOwner.setFirstName("John");
		dogOwner.setLastName("Snow");
		dogOwner.setAddress("1 Main St");
		dogOwner.setCity("Somewhere");
		dogOwner.setTelephone("123456789");
		dogOwner.getPets().add(dog);
		dog.setOwner(dogOwner);
		
		Owner catOwner = new Owner();
		catOwner.setFirstName("Tyrion");
		catOwner.setLastName("Lannister");
		catOwner.setAddress("1 Main St");
		catOwner.setCity("Somewhere");
		catOwner.setTelephone("123456789");
		catOwner.getPets().add(cat);
		cat.setOwner(catOwner);
		ownerService.save(catOwner);
		
		Specialty radiologySpecialty = new Specialty();
		radiologySpecialty.setName("Radiology");
		Specialty savedRadiologySpeciality = specialtyService.save(radiologySpecialty);
		
		Specialty surgerySpecialty = new Specialty();
		surgerySpecialty.setName("Surgery");
		Specialty savedSurgerySpeciality = specialtyService.save(surgerySpecialty);
		
		Specialty dentistrySpecialty = new Specialty();
		dentistrySpecialty.setName("Dentistry");
		Specialty savedDentistrySpeciality = specialtyService.save(dentistrySpecialty);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Robert");
		vet1.setLastName("Baratheon");
		vet1.getSpecialities().add(savedRadiologySpeciality);
		vet1.getSpecialities().add(savedDentistrySpeciality);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Ned");
		vet2.setLastName("Stark");
		vet2.getSpecialities().add(savedSurgerySpeciality);
		vet2.getSpecialities().add(savedDentistrySpeciality);
		vetService.save(vet2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(cat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Seazy kitty");
		visitService.save(catVisit);
	}

}
