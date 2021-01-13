package com.zdrv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zdrv.dao.PetDao;
import com.zdrv.domain.Pet;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetDao petDao;

	@Override
	public List<Pet> getPetList() throws Exception {
		return petDao.selectAll();
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






}
