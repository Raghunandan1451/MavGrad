package com.upgrad.mavgrad.service;

import com.upgrad.mavgrad.model.User;
// import com.upgrad.mavgrad.repository.PostRepository;
import com.upgrad.mavgrad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public UserService(){
		System.out.println("*********** UserService ***********");
	}
	@Autowired
	private UserRepository repository;
	public User login(User user){
		User existingUser = repository.checkUser(user.getUsername(),user.getPassword());
		if(existingUser!=null){
			return existingUser;
		}else{
			return null;
		}
	}

	public void registerUser(User newUser){
		User existingUser = repository.checkUser(newUser.getUsername(),newUser.getPassword());
		if(existingUser == null){
			repository.register(newUser);
		}else{
			System.out.println("User Already exist");
		}
	}
}
