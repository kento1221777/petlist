package com.zdrv.dao;

import java.util.List;

import com.zdrv.domain.Pet;
import com.zdrv.domain.User;

public interface UserDao {

	User selectByLoginId(String loginId) throws Exception;
	List<Pet> selectMyimageByUserId(Integer id) throws Exception;

}
