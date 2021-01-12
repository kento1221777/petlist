package com.zdrv.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zdrv.domain.User;
import com.zdrv.service.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService service;

	@GetMapping({"/", "/login"})
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping({"/", "/login"})
	public String login(
			@Valid User user,
			Errors errors,
			HttpSession session) throws Exception {
		// 入力に不備がある
		if(errors.hasErrors()) {
			return "login";
		}

		// パスワードが正しくない
		if(!service.isCorrectIdAndPassword(user.getLoginId(), user.getLoginPass())) {
			errors.rejectValue("loginId", "error.incorrect_id_password");
			return "login";
		}

		// 正しいログインIDとパスワード
		// ⇒ セッションにログインIDを格納し、リダイレクト
		User loginuser = service.getUser(user.getLoginId());
		session.setAttribute("id", loginuser.getId());
		session.setAttribute("name", loginuser.getName());
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// セッションを破棄し、トップページへ遷移
		session.invalidate();
		return "redirect:/";
	}

}
