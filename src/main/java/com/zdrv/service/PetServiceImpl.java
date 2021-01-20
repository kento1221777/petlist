package com.zdrv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zdrv.dao.LikeDao;
import com.zdrv.dao.PetDao;
import com.zdrv.domain.Like;
import com.zdrv.domain.Pet;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetDao petDao;

	@Autowired
	LikeDao likeDao;

	@Override
	public List<Pet> getPetList(Integer userId) throws Exception {
		List<Pet> petList =  petDao.selectAll();
		List<Pet> modifiedPetList = new ArrayList<>();
		// petListにLikeの情報を加える
		for(Pet pet : petList) {
			Like like = likeDao.findByPetIdAndUserId(pet.getId(), userId);

			if(like != null) {
				pet.setLike(true);
			} else {
				pet.setLike(false);
			}
			modifiedPetList.add(pet);
		}

		return modifiedPetList;
	}

	@Override
	public Pet getPetById(Integer id) throws Exception {
		return petDao.selectById(id);
	}

	@Override
	@Transactional
	public void addPet(Pet pet) throws Exception {
		MultipartFile upfile = pet.getUpfile();

		//選択されたファイルの情報
		String image = upfile.getOriginalFilename();

		pet.setImage(image);

		petDao.insert(pet);
	}

	@Override
	@Transactional
	public List<Pet> getPetListByUserId(Integer userId) throws Exception {
		return petDao.selectAllByUserId(userId);
	}

	@Override
	public List<Pet> getPetListByCategoryId(Integer categoryId) throws Exception {
		return petDao.selectAllByCategoryId(categoryId);
	}

	@Override
	public void editPet(Pet pet) throws Exception {
		MultipartFile upfile = pet.getUpfile();

		//選択されたファイルの情報
		String image = upfile.getOriginalFilename();

		pet.setImage(image);

		petDao.update(pet);
	}

	@Override
	public void deletePet(Integer id) throws Exception {
		petDao.delete(id);
	}

	@Override
	public List<Pet> getPetListByLike(Integer userId) throws Exception {
		return petDao.selectAllByLike(userId);
	}






}
