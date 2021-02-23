package com.upgrad.mavgrad.repository;

import com.upgrad.mavgrad.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByUserName(String userName);

}