package com.zdrv.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zdrv.domain.Like;

@Mapper
public interface LikeDao {

	void insert(@Param("petId") Integer petId, @Param("userId") Integer userId) throws Exception;
	void delete(@Param("petId") Integer petId, @Param("userId") Integer userId) throws Exception;
	Like findByPetIdAndUserId (@Param("petId") Integer petId, @Param("userId") Integer userId) throws Exception;
	List<Map<Integer, Integer>> count() throws Exception;

}
