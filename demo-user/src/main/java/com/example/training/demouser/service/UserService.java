package com.example.training.demouser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.training.demouser.dto.UserDto;
import com.example.training.demouser.model.User;


public interface UserService {
	
	UserDto createUser(UserDto userDto);
	List<UserDto> getAllUser();
	UserDto getUserbyId(Long pid);
	UserDto updateUser(UserDto userDto, Long pid);
	void deleteUser(Long pid);
	User getUser(String uname);
}
