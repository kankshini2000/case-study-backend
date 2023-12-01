package com.example.course.democourse.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.course.democourse.Exception.ResourceNotFoundException;
import com.example.course.democourse.dto.CourseDto;
import com.example.course.democourse.model.Course;
import com.example.course.democourse.repo.CourseRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseImpl implements CourseService{
	
	private CourseRepo repo;
	
	private ModelMapper modelMapper;

	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		Course createdCourse =repo.save(course);
        return modelMapper.map(createdCourse, CourseDto.class);
	}

	@Override
	public List<CourseDto> getCourse() {
		List<Course> courses = repo.findAll();
        return courses.stream()
                .map(user -> modelMapper.map(user, CourseDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public CourseDto getitsId(Long cid) {
     Optional<Course> courseOptional = repo.findById(cid);
        
        if (courseOptional.isPresent()) {
            CourseDto userDto = modelMapper.map(courseOptional.get(), CourseDto.class);
            return userDto;
        } else {
            throw new ResourceNotFoundException("Course", "cid", cid);
        }
	}

	@Override
	public CourseDto updateCourse(CourseDto course, Long cid) {
		Optional<Course> courseOptional = repo.findById(course.getCid());
        
        if (courseOptional.isPresent()) {
            Course existingCourse = courseOptional.get();
            existingCourse.setCname(course.getCname());
            existingCourse.setCountTime(course.getCountTime());
            existingCourse.setCourseCode(course.getCourseCode());
            existingCourse.setDays(course.getDays());
            Course updatedCourse = repo.save(existingCourse);
            return modelMapper.map(updatedCourse, CourseDto.class);
        } else {
        	throw new ResourceNotFoundException("Course", "cid", course.getCid());
        }
	}

	@Override
	public void deleteCourse(Long cid) {
		repo.findById(cid).orElseThrow(
                () -> new ResourceNotFoundException("Course", "cid", cid));
		repo.deleteById(cid);
		
	}
	
	
	
}
