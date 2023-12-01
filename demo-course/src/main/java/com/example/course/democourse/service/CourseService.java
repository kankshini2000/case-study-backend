package com.example.course.democourse.service;

import java.util.List;

import com.example.course.democourse.dto.CourseDto;
import com.example.course.democourse.model.Course;


public interface CourseService {
	
	CourseDto createCourse(CourseDto course);
	List<CourseDto> getCourse();
	CourseDto getitsId(Long cid);
	CourseDto updateCourse(CourseDto course, Long cid);
	void deleteCourse(Long cid);
}
