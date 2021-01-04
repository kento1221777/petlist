package com.zdrv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Pet;

@Mapper
public interface PetDao {

	List<Pet> selectAll() throws Exception;
	Pet selectById(Integer id) throws Exception;
	void insert(Pet pet) throws Exception;

}
