package com.zdrv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zdrv.dao.LikeDao;

@Controller
public class TestController {

	@Autowired
	LikeDao dao;

	@GetMapping("/test")
	public String test() throws Exception {

		List<Map<Integer, Integer>> result = dao.count();

		Map<Integer, Integer> map = new HashMap<>();





		return "test";
	}

}
