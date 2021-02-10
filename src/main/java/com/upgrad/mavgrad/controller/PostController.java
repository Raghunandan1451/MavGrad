package com.upgrad.mavgrad.controller;

import java.util.ArrayList;

import com.upgrad.mavgrad.model.Post;
import com.upgrad.mavgrad.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
	PostService postService = new PostService();
	@RequestMapping("/posts")
	public String getUserPost(Model model) {
		ArrayList<Post> posts = postService.getAllPosts();
		model.addAttribute("posts", posts);
		return "posts";
	}
}
