package com.zdrv.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdrv.dao.UserDao;
import com.zdrv.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public boolean isCorrectIdAndPassword(String loginId, String loginPass) throws Exception {
		User user = dao.selectByLoginId(loginId);

		// ログインIDが正しいかチェック
		if(user == null) {
			return false;
		}

		// パスワードが正しいかチェック
		if(!BCrypt.checkpw(loginPass, user.getLoginPass())) {
			return false;
		}

		return true;
	}

}
