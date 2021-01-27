package com.zdrv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdrv.domain.Category;
import com.zdrv.domain.Pet;
import com.zdrv.service.LikeService;
import com.zdrv.service.PetService;
import com.zdrv.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	PetService petService;
	@Autowired
	UserService userService;
	@Autowired
	LikeService likeService;

	@GetMapping
	public String home(
			HttpSession session,
			HttpServletRequest request,
			Model model) throws Exception {
		Integer userId = (Integer) session.getAttribute("id");
		model.addAttribute("petList", petService.getPetList(userId));
		model.addAttribute("categoryList", getCategoryList());
		return "home";
	}
	@GetMapping("likeDesc")
	public String likeDesc(
			HttpSession session,
			HttpServletRequest request,
			Model model) throws Exception {
		Integer userId = (Integer) session.getAttribute("id");
		model.addAttribute("petList", petService.getPetListLikeDesc(userId));
		model.addAttribute("categoryList", getCategoryList());
		return "likeDesc";
	}


	@GetMapping("/category/{categoryId}")
	public String category(
			@PathVariable Integer categoryId,
			Model model) throws Exception {
		model.addAttribute("categoryList", getCategoryList());
		model.addAttribute("categoryTypeList", petService.getPetListByCategoryId(categoryId));
		return "category";
	}

	@GetMapping("/mygallery/{id}")
	public String mygallery(
			@PathVariable Integer id,
			Model model) throws Exception {
		List<Pet> petList = petService.getPetListByUserId(id);
		System.out.println(petList.size());
		for(Pet p : petList) {
			System.out.println(p.getImage());
		}
		model.addAttribute("petList", petList);
		return "mygallery";
	}

	@GetMapping("/like/{petId}/{userId}")
	@ResponseBody
	public boolean like(@PathVariable("petId") Integer petId, @PathVariable("userId") Integer userId) throws Exception {
		return likeService.addDeleteLike(petId, userId);
	}

	@GetMapping("/like/{id}")
	public String like(@PathVariable Integer id,
			Model model) throws Exception {
		List<Pet> petList = petService.getPetListByLike(id);
		model.addAttribute("petList", petList);
		return "like";

	}

	private List<Category> getCategoryList() {
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(new Category(1, "犬"));
		categoryList.add(new Category(2, "猫"));
		categoryList.add(new Category(3, "うさぎ"));
		categoryList.add(new Category(4, "ハムスター"));
		categoryList.add(new Category(5, "鳥"));
		categoryList.add(new Category(6, "魚"));
		categoryList.add(new Category(7, "その他"));
		return categoryList;
	}

}
