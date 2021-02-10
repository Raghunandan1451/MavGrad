package com.upgrad.mavgrad.controller;

import com.upgrad.mavgrad.model.User;
import com.upgrad.mavgrad.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private UserService userService = new UserService();
	@RequestMapping("/users/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "users/login";
	}
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String loginUser(User user) {
		if(userService.login(user)) {
			return "redirect:/posts";
		} else {
			return "users/login";
		}
	}
	@RequestMapping("/users/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "users/registration";
	}
	public String registerUser(User user) {
		// TODO: register User
		return "users/registration";
	}
}
