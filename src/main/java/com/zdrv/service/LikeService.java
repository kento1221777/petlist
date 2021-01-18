package com.zdrv.service;


public interface LikeService {


	void addLike(Integer petId, Integer userId) throws Exception;
	void deletePet(Integer id) throws Exception;

}
