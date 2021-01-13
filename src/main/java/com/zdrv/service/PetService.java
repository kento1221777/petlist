package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Pet;



public interface PetService {

	List<Pet> getPetList() throws Exception;
	Pet getPetById(Integer id) throws Exception;
	List<Pet> getPetListByCategoryId(Integer categoryId) throws Exception;
	List<Pet> getPetListByUserId(Integer userId) throws Exception;
	void addPet(Pet pet) throws Exception;

}
