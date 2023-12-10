package com.example.training.demouser.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.demouser.dto.LoginDto;
import com.example.training.demouser.dto.UserDto;
import com.example.training.demouser.model.User;
import com.example.training.demouser.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserControl {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserControl.class);
	
	private UserService userService;
	
	
	@PostMapping("create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createdUser = userService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public LoginDto login(@RequestBody User loginUser ){
		System.out.println("fghjk");
		User user = getUserByName(loginUser.getUname());
		if(user.getUname().equals(loginUser.getUname()) && user.getPassword().equals(loginUser.getPassword())) {
			System.out.println("fghjk");
			LoginDto dto = new LoginDto(user.getPid(),user.getUname(), user.getRole());
			return dto;
		}else {
			return new LoginDto(0,user.getUname(),user.getRole());
		}
	}
	
	@GetMapping("/getuser/{uname}")
	public User getUserByName(@PathVariable String uname) {
		return userService.getUser(uname);
		
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> getUser = userService.getAllUser();
		return new ResponseEntity<>(getUser, HttpStatus.OK);
	}
	
	@GetMapping("/get/{pid}")
	public ResponseEntity<UserDto> getUserByItsID(@PathVariable Long pid){
		UserDto getusersid = userService.getUserbyId(pid);
		return new ResponseEntity<>(getusersid, HttpStatus.OK);
	}
	
	@PutMapping("/update/{pid}")
	public ResponseEntity<UserDto> UpdateUser(@RequestBody UserDto userDto,@PathVariable Long pid){
		userDto.setPid(pid);
		UserDto updatedUser = userService.updateUser(userDto, pid);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{pid}")
	public ResponseEntity<String> deltetUserByItsId(@PathVariable Long pid){
		userService.deleteUser(pid);
		return new ResponseEntity<>("User deleted succesfully", HttpStatus.OK) ;
	}
	
}
