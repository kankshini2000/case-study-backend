package com.example.course.democourse.dto;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
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
public class CourseDto {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
   private Long cid;
	
	private String cname;
	
	private String courseCode;
	
	private LocalTime countTime;
	
	private int days;
	
	
}
