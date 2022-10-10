package com.svv.async.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svv.async.entity.Student;
import com.svv.async.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studService;
	
	@PostMapping("/save")
	ResponseEntity<?> saveStudent(@RequestBody Student stud) throws InterruptedException
	{
		Student student = studService.saveStudent(stud);
		
		studService.printAllUsers(); //this will run asynchronously in another thread
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	}


}
