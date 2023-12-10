package com.example.course.democourse.control;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.course.democourse.dto.CourseDto;
import com.example.course.democourse.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CourseControl.class)
public class CourseControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPostCourse() throws Exception {
    	
    	 CourseDto courseDto = new CourseDto(1L,"cname","CD001",LocalTime.now(),13);
         CourseDto savedCourse = courseDto;
    	
        when(courseService.createCourse(any(CourseDto.class))).thenReturn(savedCourse);

        mockMvc.perform(post("/api/v1/course/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(courseDto)))
                .andExpect(status().isCreated());
    }

    
    @Test
    public void testGetCourseById() throws Exception {
        Long cid = 1L;
        CourseDto courseDto = new CourseDto(1L,"cname","CD001",LocalTime.now(),13);

        when(courseService.getitsId(null)).thenReturn(courseDto);

        mockMvc.perform(get("/api/v1/course/get/{cid}", cid))
                .andExpect(status().isOk());
                
    }

    @Test
    public void testDeleteCourseById() throws Exception {
        Long cid =1L;
        
        mockMvc.perform(delete("/api/v1/course/del/{cid}", cid))
                .andExpect(status().isOk());
        
        verify(courseService, times(1)).deleteCourse(cid);
    }

    @Test
    public void testGetAllCourses() throws Exception {
        CourseDto courseDto = new CourseDto(1L,"cname","CD001",LocalTime.now(),13);
        
        List<CourseDto> courseList = Arrays.asList(courseDto);
        
        when(courseService.getCourse()).thenReturn(courseList);

        mockMvc.perform(get("/api/v1/course/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(courseList.size()));
    }
}

