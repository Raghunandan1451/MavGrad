package com.upgrad.mavgrad.controller;

import com.upgrad.mavgrad.model.Post;
import com.upgrad.mavgrad.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {
	//localhost:8080/posts : GET
	@Autowired
	PostService postService;
	
	@RequestMapping("/posts")
	public String getUserPost(Model model){
		ArrayList<Post> posts= postService.getAllPosts();
		model.addAttribute("posts",posts);
		return "posts";
	}
	//TODO: GET : posts/newpost  ,  POST: post/create
	@RequestMapping("/posts/newpost")
	public String newPost(){
		return "posts/create";
	}
	@RequestMapping(value="/posts/create", method= RequestMethod.POST)
	public String createPost(Post newPost){
		newPost.setDate(new Date());
		postService.createPost(newPost);
		return "redirect:/posts";
	}
}
