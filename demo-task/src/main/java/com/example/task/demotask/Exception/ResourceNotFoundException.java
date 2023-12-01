package com.example.task.demotask.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long tid) {
		super(String.format("%s not found with %s : '%s' ", resourceName,fieldName,tid));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = tid;
	}
}