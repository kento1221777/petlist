package com.zdrv.dao;

import com.zdrv.domain.User;

public interface UserDao {

	User selectByLoginId(String loginId) throws Exception;


}
