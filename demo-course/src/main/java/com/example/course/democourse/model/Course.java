package com.example.course.democourse.model;



import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	@Column(nullable = false)
	private String cname;
	
	@Column(nullable = false)
	private String courseCode;
	
	private LocalTime countTime;
	//private LocalDateTime countTime;
	
	private int days;
}
