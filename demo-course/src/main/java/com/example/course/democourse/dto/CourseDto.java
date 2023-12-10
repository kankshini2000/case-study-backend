package com.example.course.democourse.dto;

import java.time.LocalTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	

   private Long cid;
	
	@NotBlank(message ="enter valid name")
	private String cname;
	
	@NotBlank(message ="enter valid courseCode")
	private String courseCode;
	
	@NotNull(message ="enter valid LocalTime")
	private LocalTime countTime;
	
	//@NotBlank(message ="no null days")
	private int days;
	
	
}
