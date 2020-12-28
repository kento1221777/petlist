package com.zdrv.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping()
	public String home(
			HttpServletRequest request,
			Model model) {
		File directory = new File(request.getServletContext().getRealPath("/uploads") + "/");
		File[] files = directory.listFiles();
		model.addAttribute("files", files);
		return "home";
	}

}
