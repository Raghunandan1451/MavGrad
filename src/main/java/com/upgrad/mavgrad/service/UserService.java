package com.upgrad.mavgrad.service;

import com.upgrad.mavgrad.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public boolean login(User user){
		if(user.getUserName().equals("admin") && user.getPassword().equals("admin123")){
			return true;
		}else{
			return false;
		}

	}
}
