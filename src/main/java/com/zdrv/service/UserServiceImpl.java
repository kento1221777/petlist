package com.zdrv.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.dao.UserDao;
import com.zdrv.domain.Pet;
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

	@Override
	public List<Pet> getMyimageByUserId(Integer id) throws Exception {
		return dao.selectMyimageByUserId(id);
	}

	@Override
	public User getUser(String loginId) throws Exception {

		return dao.selectByLoginId(loginId);
	}

	@Override
	@Transactional
	public void addUser(User user) throws Exception {
		// パスワードをハッシュ化してセット
		String hashed = BCrypt.hashpw(user.getLoginPass(), BCrypt.gensalt());
		user.setLoginPass(hashed);
		dao.insertUser(user);
	}

}
