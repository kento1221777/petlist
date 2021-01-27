package com.zdrv.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zdrv.domain.Category;
import com.zdrv.domain.Pet;
import com.zdrv.service.PetService;

@Controller
@RequestMapping()
public class PetController {

	@Autowired
	PetService petService;

	@GetMapping("/add/{id}")
	public String addGet(@PathVariable Integer id, Model model) {
		model.addAttribute("pet", new Pet());



		model.addAttribute("categoryList", getCategoryList());
		return "upload";
	}

	@PostMapping("/add/{id}")
	public String addPost(
			@PathVariable Integer id,
			HttpServletRequest request,
			@RequestParam MultipartFile upfile, @Valid Pet pet, Errors errors, Model model) throws Exception {
		if(upfile.isEmpty()) {
			//ファイルが選択されいていない
			errors.rejectValue("upfile", "error.not_image_file");
			model.addAttribute("categoryList", getCategoryList());
			return "upload";
		}

		//選択されたファイルの情報
		String image = upfile.getOriginalFilename();
		String contentType = upfile.getContentType();

		// 画像以外の場合はアップさせない
		if(!contentType.startsWith("image/")) {
			errors.rejectValue("upfile", "error.not_image_file");
			model.addAttribute("categoryList", getCategoryList());
			return "upload";
		}

		//uploadsフォルダにファイルを保存
		File dest = new File(request.getServletContext().getRealPath("/uploads") + "/" + image);
		System.out.println(dest);
		upfile.transferTo(dest);

		pet.setUserId(id);
		petService.addPet(pet);

		return "uploadDone";
	}



	@GetMapping("/delete/{id}")
	public String deleteGet(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("pet", petService.getPetById(id));
		return "delete";
	}

	@PostMapping("/delete/{id}")
	public String deletePost(@PathVariable Integer id, Model model, HttpServletRequest request) throws Exception {

		if(request.getParameter("cancel") != null) {
			return "redirect:/home";
		}
		petService.deletePet(id);
		return "uploadDone";
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
