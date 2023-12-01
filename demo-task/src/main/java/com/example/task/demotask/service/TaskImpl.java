package com.example.task.demotask.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.task.demotask.Exception.ResourceNotFoundException;
import com.example.task.demotask.dto.CourseDto;
import com.example.task.demotask.dto.TaskCourseDto;
import com.example.task.demotask.dto.TaskDto;
import com.example.task.demotask.dto.UserDto;
import com.example.task.demotask.dto.UserRole;
import com.example.task.demotask.model.Tasks;
import com.example.task.demotask.repo.TaskRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskImpl implements TaskService{
	
	private TaskRepo taskRepo;
	
	private WebClient webClient;
	
	private ModelMapper modelMapper;

	
	@Override
	public TaskDto createTask(TaskDto taskDto) {
		UserDto user = getUserByWebClient(taskDto.getUserId());
		if (user.getRole().equals(UserRole.ADMIN)) {
			throw new RuntimeException("Admin cannnot be enrolled to course");
		}
		getCourseByWebClient(taskDto.getCid());
		Tasks task = modelMapper.map(taskDto, Tasks.class);
		Tasks savedTask = taskRepo.save(task);
		return modelMapper.map(savedTask, TaskDto.class);
	}
	
	@Override
	public List<TaskCourseDto> getTaskListById(Long tid) {
		List<Tasks> listTask = taskRepo.findByUserId(tid);
		
		return listTask.stream().map((task)->
				new TaskCourseDto(
						task.getTid(),
						task.getUserId(),
						getCourseByWebClient(task.getCid()),
						task.getStartDate(),
						task.getEndDate(),
						task.getHrsPerdays()
				))
				.collect(Collectors.toList());
	}

	
	@Override
	public List<TaskDto> getAllTask() {
		List<Tasks> tasks = taskRepo.findAll();
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public TaskDto getTaskbyId(Long tid) {
		Optional<Tasks> task = taskRepo.findById(tid);
		Tasks gotTask = task.get();
		return modelMapper.map(gotTask, TaskDto.class);
	}

	

	@Override
	public void deleteTask(Long tid) {
		taskRepo.findById(tid).orElseThrow(
                () -> new ResourceNotFoundException("Task", "tid", tid));
        taskRepo.deleteById(tid);
    }
		
	
	 private UserDto getUserByWebClient(Long pid) {

			UserDto dto = webClient.get()
					.uri("http://localhost:8090/api/v1/user/get/" + pid)
					.retrieve()
					.bodyToMono(UserDto.class).block();

			return dto;

		}
	 
	 private CourseDto getCourseByWebClient(Long cid) {
		 CourseDto dto;
		 try {
			 dto = webClient.get()
						.uri("http://localhost:8091/api/v1/course/get/" + cid)
						.retrieve()
						.bodyToMono(CourseDto.class).block();
		 }catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			return dto;
	 }
	
	
}
