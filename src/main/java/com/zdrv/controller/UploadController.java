package com.zdrv.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zdrv.domain.Pet;
import com.zdrv.service.PetService;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	PetService petService;

	@GetMapping
	public String upload() {
		return "upload";
	}

	@PostMapping
	public String doPost(
			HttpServletRequest request,
			@RequestParam MultipartFile upfile, @Valid Pet pet, Model model) throws Exception {
		if(upfile.isEmpty()) {
			//ファイルが選択されいていない
			return "upload";
		}

		//選択されたファイルの情報
		String image = upfile.getOriginalFilename();
		String contentType = upfile.getContentType();

		// 画像以外の場合はアップさせない
		if(!contentType.startsWith("image/")) {
			return "upload";
		}

		//uploadsフォルダにファイルを保存
		File dest = new File(request.getServletContext().getRealPath("/uploads") + "/" + image);
		System.out.println(dest);
		upfile.transferTo(dest);

		petService.addPet(pet);

		return "uploadDone";
	}

}
