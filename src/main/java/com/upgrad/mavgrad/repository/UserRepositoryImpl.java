package com.upgrad.mavgrad.repository;

import com.upgrad.mavgrad.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class UserRepositoryImpl implements UserRepository{

    public List<User> findByUserName(String userName) {
        return findByUserName(userName);
    }
}