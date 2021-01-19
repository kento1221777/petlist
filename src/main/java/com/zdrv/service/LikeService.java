package com.zdrv.service;


public interface LikeService {


	void addLike(Integer petId, Integer userId) throws Exception;
	void deleteLike(Integer petId, Integer userId) throws Exception;
	boolean addDeleteLike(Integer petId, Integer userId) throws Exception;

}
