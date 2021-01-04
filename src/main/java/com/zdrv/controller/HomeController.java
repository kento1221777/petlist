package com.zdrv.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdrv.service.PetService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	PetService petService;

	@GetMapping()
	public String home(
			HttpServletRequest request,
			Model model) throws Exception {
		model.addAttribute("petList", petService.getPetList());
		return "home";
	}

	@GetMapping("/{id}")
	public String detail(
			@PathVariable Integer id,
			Model model) throws Exception {
		model.addAttribute("pet", petService.getPetById(id));
		return "detail";
	}



}
