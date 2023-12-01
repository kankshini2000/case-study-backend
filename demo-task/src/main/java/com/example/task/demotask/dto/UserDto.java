package com.example.task.demotask.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
	private Long pid;
	
	private String uname;
	
	private String email;
	
	private UserRole role;
}
