package com.example.course.democourse.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.course.democourse.dto.CourseDto;
import com.example.course.democourse.model.Course;
import com.example.course.democourse.repo.CourseRepo;

@SpringBootTest
public class CourseImplTest {

	 @Mock
	    private CourseRepo courserepo;

	    @InjectMocks
	    private CourseImpl courseimpl ;

	    @Test
	    public void testSaveCourse() {
	        
	        CourseDto inputCourseDto = new CourseDto(1L,"cname","CD001",LocalTime.now(),13);

	        
//	        Course inputCourse = CourseMapper.CourseDtoToCourse(inputCourseDto);
	        Course savedCourse =new Course(1L,"cname","CD001",LocalTime.now(),13);
	        Mockito.when(courserepo.save(Mockito.any(Course.class))).thenReturn(savedCourse);

	        CourseDto result = courseimpl.createCourse(inputCourseDto);

	        assertEquals(savedCourse.getCname(), result.getCname(), "not done"); 
	    }

	    @Test
	    public void testGetCourseById() {
	        Long cid = 1L;
	        Course course =new Course(1L,"cname","CD001",LocalTime.now(),13);
	        CourseDto expectedCourseDto = new CourseDto(1L,"cname","CD001",LocalTime.now(),13);
	        Mockito.when(courserepo.findById(cid)).thenReturn(Optional.of(course));

	        CourseDto result = courseimpl.getitsId(cid);

	         assertEquals(course.getCname(),result.getCname(),"wrong");
	    }

//	    @Test
//	    public void testUpdateCourse() {
//	        int courseId = 1;
//	        CourseDto updatedCourseDto = new CourseDto(1, "coursename", LocalTime.now());
//	        Course existingCourse = 
//	        Mockito.when(courserepo.findById(courseId)).thenReturn(Optional.of(existingCourse));
//	        Mockito.when(courserepo.save(Mockito.any(Course.class))).thenReturn(existingCourse);
	//
//	        CourseDto result = courseimpl.updateCourse(updatedCourseDto, courseId);
	//
//	        // Perform assertions on the result
//	        // Assert.assertEquals(expectedResult, result);
//	    }

	    @Test
	    public void testDeleteCourseById() {
	        Long cid = 1L;
	        Course existingCourse =  new Course(1L,"cname","CD001",LocalTime.now(),13);
	        Mockito.when(courserepo.findById(cid)).thenReturn(Optional.of(existingCourse));

	        courseimpl.deleteCourse(cid);

	        // Verify that deleteById method is called once
	        Mockito.verify(courserepo, Mockito.times(1)).deleteById(cid);
	    }

	    @Test
	    public void testGetAllCourses() {
	        List<Course> courseList = Arrays.asList(new Course(1L,"cname","CD001",LocalTime.now(),13));
	        Mockito.when(courserepo.findAll()).thenReturn(courseList);

	        List<CourseDto> result = courseimpl.getCourse();

	         assertEquals(courseList.size(), result.size());
	    }

}
