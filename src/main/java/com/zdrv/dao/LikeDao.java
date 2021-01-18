package com.zdrv.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeDao {

	void insert(Integer petId, Integer userId) throws Exception;
	void delete(Integer id) throws Exception;

}
