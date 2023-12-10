package com.example.basedomains.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {

	private Long tid;
	private Long userId;
	private Long cid;
	private String cname;
    private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalTime hrsPerdays;
}
