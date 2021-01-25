package com.zdrv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdrv.dao.LikeDao;
import com.zdrv.dao.PetDao;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao likeDao;
	@Autowired
	PetDao petDao;

	@Override
	public void addLike(Integer petId, Integer userId) throws Exception {
		likeDao.insert(petId, userId);
	}

	@Override
	public void deleteLike(Integer petId, Integer userId) throws Exception {
		likeDao.delete(petId, userId);
	}

	@Override
	public boolean addDeleteLike(Integer petId, Integer userId) throws Exception {
		// すでに「いいね」済みか調べる
		if(likeDao.findByPetIdAndUserId(petId, userId) != null) {
			likeDao.delete(petId, userId);
			petDao.minusLikenum(petId);
			return false;
		} else {
			likeDao.insert(petId, userId);
			petDao.plusLikenum(petId);
			return true;
		}
	}


}
