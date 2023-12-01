package com.example.task.demotask.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.demotask.model.Tasks;

public interface TaskRepo extends JpaRepository<Tasks, Long>{
	
   // List<Tasks> findByTaskId(Long tid);
//
   List<Tasks> findByUserId(Long tid);
}
