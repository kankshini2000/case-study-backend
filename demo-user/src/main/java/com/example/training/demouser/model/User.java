package com.example.training.demouser.model;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_db")
public class User {
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	//fingByPid;
	
	@Column(nullable = false)
	@NotEmpty(message = "feild name cant be empty")
	private String uname;
	//findByUname
	
	@Column(nullable = false, unique = true)
	@Email(message = "Enter a valid email")
	private String email;
	
	
	private String password;
	
	private UserRole role;
}
