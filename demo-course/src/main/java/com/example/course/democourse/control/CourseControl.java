package com.example.course.democourse.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.democourse.dto.CourseDto;
import com.example.course.democourse.model.Course;
import com.example.course.democourse.service.CourseService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("api/v1/course")
@AllArgsConstructor
public class CourseControl {

	private CourseService courseService;
	
	@PostMapping("create")
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto course){
		CourseDto createdCourse = courseService.createCourse(course);
		return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<CourseDto>> getAllCourse(CourseDto course){
		List<CourseDto> getCourse = courseService.getCourse();
		return new ResponseEntity<>(getCourse, HttpStatus.OK);
	}
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<CourseDto> getCourseByItsID(@PathVariable Long cid){
		CourseDto getcoursesid = courseService.getitsId(cid);
		return new ResponseEntity<>(getcoursesid, HttpStatus.OK);
	}
	
	@PutMapping("update/{cid}")
	public ResponseEntity<CourseDto> UpdateCourse(@RequestBody CourseDto course,@PathVariable Long cid){
		course.setCid(cid);
		CourseDto updatedCourse = courseService.updateCourse(course, cid);
		return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
	}
	
	@DeleteMapping("del/{cid}")
	public ResponseEntity<String> deltetCourseByItsId(@PathVariable Long cid){
		courseService.deleteCourse(cid);
		return new ResponseEntity<>("Course deleted succesfully", HttpStatus.OK) ;
	}
}
