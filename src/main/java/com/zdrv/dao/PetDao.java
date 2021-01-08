package com.zdrv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Pet;

@Mapper
public interface PetDao {

	List<Pet> selectAll() throws Exception;
	Pet selectById(Integer id) throws Exception;
	List<Pet> selectAllByUserId(Integer userId) throws Exception;
	List<Pet> selectAllByCategoryId(Integer categoryId) throws Exception;
	void insert(Pet pet) throws Exception;

}
