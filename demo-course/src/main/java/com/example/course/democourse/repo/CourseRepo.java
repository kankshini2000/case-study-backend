package com.example.course.democourse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.democourse.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{
//	Course findByCname (String cname);
}
