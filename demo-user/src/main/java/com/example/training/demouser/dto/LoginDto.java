package com.example.training.demouser.dto;

import com.example.training.demouser.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginDto {
	
	private long pid;
	private String uname;
	private UserRole role;
}
