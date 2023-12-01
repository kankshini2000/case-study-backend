package com.example.training.demouser.service.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.training.demouser.dto.UserDto;
import com.example.training.demouser.exception.ResourceNotFoundException;

import com.example.training.demouser.model.User;
import com.example.training.demouser.repo.UserRepo;
import com.example.training.demouser.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepo ;
	
	 private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userdto) {
		
		User user = modelMapper.map(userdto, User.class);
		User createStd = userRepo.save(user);
		return modelMapper.map(createStd, UserDto.class);
	}
	
	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepo.findAll();
		 return users.stream()
	                .map(user -> modelMapper.map(user, UserDto.class))
	                .collect(Collectors.toList());
	}

	@Override
	public UserDto getUserbyId(Long pid) {
		 Optional<User> userOptional = userRepo.findById(pid);
	        
	        if (userOptional.isPresent()) {
	            UserDto userDto = modelMapper.map(userOptional.get(), UserDto.class);
	            return userDto;
	        } else {
	            throw new ResourceNotFoundException("User", "pid", pid);
	        }
	}

	
	@Override
	public UserDto updateUser(UserDto userDto, Long pid) {
		Optional<User> userOptional= userRepo.findById(pid);
		
		if(userOptional.isPresent()) {
			User existingUser = userOptional.get();
		    existingUser.setUname(userDto.getUname());
			existingUser.setEmail(userDto.getEmail());
			existingUser.setRole(userDto.getRole());
		     User updatedUser = userRepo.save(existingUser);
		return modelMapper.map(updatedUser, UserDto.class);
		}
		else 
			throw new ResourceNotFoundException("User", "id",userDto.getPid());
		}

	
	@Override
	public void deleteUser(Long pid) {
		 userRepo.findById(pid).orElseThrow(
	                () -> new ResourceNotFoundException("User", "pid", pid));
		 userRepo.deleteById(pid);
		
	}


}
