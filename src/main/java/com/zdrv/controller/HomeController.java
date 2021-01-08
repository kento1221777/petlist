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

import com.zdrv.domain.Category;
import com.zdrv.domain.User;
import com.zdrv.service.PetService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	PetService petService;

	@GetMapping()
	public String home(
			HttpServletRequest request,
			HttpSession session,
			Model model) throws Exception {
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(new Category(1, "犬"));
		categoryList.add(new Category(2, "猫"));
		categoryList.add(new Category(3, "うさぎ"));
		categoryList.add(new Category(4, "ハムスター"));
		categoryList.add(new Category(5, "鳥"));
		categoryList.add(new Category(6, "魚"));
		categoryList.add(new Category(7, "その他"));

		request.getSession();
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("petList", petService.getPetList());
		model.addAttribute("categoryList", categoryList);
		return "home";
	}

	@GetMapping({"/{id}", "category/detail/{id}"})
	public String detail(
			@PathVariable Integer id,
			Model model) throws Exception {
		model.addAttribute("pet", petService.getPetById(id));
		return "detail";
	}

	@GetMapping("/category/{categoryId}")
	public String category(
			@PathVariable Integer categoryId,
			Model model) throws Exception {
		model.addAttribute("categoryTypeList", petService.getPetListByCategoryId(categoryId));
		return "category";
	}





}
