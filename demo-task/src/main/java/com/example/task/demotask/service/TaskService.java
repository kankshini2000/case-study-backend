package com.example.task.demotask.service;

import java.util.List;

import com.example.task.demotask.dto.TaskCourseDto;
import com.example.task.demotask.dto.TaskDto;
import com.example.task.demotask.model.Tasks;


public interface TaskService {
	
	TaskDto createTask(TaskDto task);
	List<TaskDto> getAllTask();
	TaskDto getTaskbyId(Long tid);
	List<TaskCourseDto> getTaskListById(Long tid);
	void deleteTask(Long tid);
}
