package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Pet;



public interface PetService {

	List<Pet> getPetList() throws Exception;
	Pet getPetById(Integer id) throws Exception;
	void addPet(Pet pet) throws Exception;

}