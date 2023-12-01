package com.example.training.demouser.dto;

import com.example.training.demouser.model.UserRole;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
    private Long pid;
	
	
	private String uname;
	
	private String email;
	
	private UserRole role;
}
