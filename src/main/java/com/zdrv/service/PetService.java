package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Pet;



public interface PetService {

	List<Pet> getPetList(Integer userId) throws Exception;
	Pet getPetById(Integer id) throws Exception;
	List<Pet> getPetListByCategoryId(Integer categoryId) throws Exception;
	List<Pet> getPetListByUserId(Integer userId) throws Exception;
	List<Pet> getPetListByLike(Integer userId) throws Exception;
	void addPet(Pet pet) throws Exception;
	void editPet(Pet pet) throws Exception;
	void deletePet(Integer id) throws Exception;

}
