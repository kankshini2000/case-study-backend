package com.example.task.demotask.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="tasks" )
public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tid;
	
	private Long userId;
	private Long cid;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalTime hrsPerdays;
}
