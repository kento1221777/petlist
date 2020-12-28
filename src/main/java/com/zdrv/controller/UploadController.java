package com.zdrv.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@GetMapping
	public String upload() {
		return "upload";
	}

	@PostMapping
	public String doPost(
			HttpServletRequest request,
			@RequestParam MultipartFile upfile, Model model) throws IllegalStateException, IOException {
		if(upfile.isEmpty()) {
			//ファイルが選択されいていない
			return "upload";
		}

		//選択されたファイルの情報
		String fileName = upfile.getOriginalFilename();
		String contentType = upfile.getContentType();

		// 画像以外の場合はアップさせない
		if(!contentType.startsWith("image/")) {
			return "upload";
		}

		//uploadsフォルダにファイルを保存
		File dest = new File(request.getServletContext().getRealPath("/uploads") + "/" + fileName);
		System.out.println(dest);
		upfile.transferTo(dest);



		return "uploadDone";
	}

}
