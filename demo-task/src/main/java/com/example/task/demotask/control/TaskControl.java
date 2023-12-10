package com.example.task.demotask.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.demotask.dto.TaskCourseDto;
import com.example.task.demotask.dto.TaskDto;
import com.example.task.demotask.model.Tasks;
import com.example.task.demotask.service.TaskService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/tasks")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TaskControl {

	//
	
	private TaskService service;
	
	@PostMapping("/{pid}/{cid}")
	public ResponseEntity<TaskDto> createTasks(@RequestBody TaskDto taskDto,
			@PathVariable Long pid,
			@PathVariable Long cid){
		taskDto.setUserId(pid);
		taskDto.setCid(cid);
		System.out.println("task id" + taskDto.getCid());
		TaskDto creatingTasks = service.createTask(taskDto);
		return new ResponseEntity<>(creatingTasks, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAllTasks(){
		List<TaskDto> tasks =service.getAllTask();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll/{pid}")
	public ResponseEntity<List<TaskCourseDto>> getAllTaskByUserId(@PathVariable Long pid) {
		
		List<TaskCourseDto> savedTask = service.getTaskListById(pid);
		return new ResponseEntity<>(savedTask,HttpStatus.OK);
	}
	
	@GetMapping("/all/get")
	public ResponseEntity<Object> getAllTasksNew(){
		List<TaskCourseDto> tasks = service.getAllTasksNew();
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
	
	@GetMapping("/byid/{tid}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable Long tid) {
		
		TaskDto savedTask = service.getTaskbyId(tid);
		return new ResponseEntity<>(savedTask,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{tid}")
	public ResponseEntity<String> deleteUser(@PathVariable Long tid){
		service.deleteTask(tid);
		return new ResponseEntity<>("Tasks Deleted Successfully",HttpStatus.OK);
	}
	
//	
	
}
