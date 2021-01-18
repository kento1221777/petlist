package com.zdrv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdrv.dao.LikeDao;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao likeDao;


	@Override
	public void addLike(Integer petId, Integer userId) throws Exception {
		likeDao.insert(petId, userId);
	}

	@Override
	public void deletePet(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}


}
