package com.example.training.demouser.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.training.demouser.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
