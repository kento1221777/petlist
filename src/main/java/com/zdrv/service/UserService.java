package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Pet;
import com.zdrv.domain.User;

public interface UserService {

	boolean isCorrectIdAndPassword(String loginId, String loginPass) throws Exception;
	User getUser(String loginId) throws Exception;
	List<Pet> getMyimageByUserId(Integer userId) throws Exception;


}
