package com.upgrad.mavgrad.controller;

import java.util.List;


// import com.upgrad.mavgrad.model.Post;
import com.upgrad.mavgrad.model.User;
import com.upgrad.mavgrad.repository.UserRepository;
// import com.upgrad.mavgrad.service.PostService;
import com.upgrad.mavgrad.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {
	// URL : users/login
	@Autowired
	private UserService userService;

	// @Autowired
	// private PostService postservice;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("users/login") //localhost:8080/users/login : GET
	public String login(Model model){
		model.addAttribute("user", new User());
		return "users/login";
	}


	@RequestMapping(value="users/login", method= RequestMethod.POST)  // localhost:8080/users/login : POST
	public String loginUser(User user){
		if(userService.login(user)){
			return "redirect:/posts"; //localhost:8080/posts : GET
		}else{
			return "users/login"; //localhost:8080/users/login : GET
		}
	}


	@RequestMapping("users/registration")
	public String registration(){
		return "users/registration";
	}

	@RequestMapping(value="users/registration", method= RequestMethod.POST)
	public String registerUser(User user){
		//TO DO : service code to register the user so that you can login with that creds
		return "redirect:/users/login";
	}
	//TO DO: logout feature: done
	public String logout(){
		return "redirect:index";
	}

	@GetMapping("/{user}")
	public List<User> getUserByUserName(@PathVariable("user") final String userName) {
		return userRepository.findByUserName(userName);
	}

	@GetMapping("/gellAllUsers")
	public List<User> getAllusers() {
		return userRepository.findAll();
	}

	@RequestMapping(value="createUser", method= RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}