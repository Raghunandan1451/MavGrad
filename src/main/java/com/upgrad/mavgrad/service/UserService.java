package com.upgrad.mavgrad.service;

import com.upgrad.mavgrad.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public UserService(){
		System.out.println("*********** UserService ***********");
	}
	public boolean login(User user){
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin123")){
			return true;
		}else{
			return false;
		}

	}
}