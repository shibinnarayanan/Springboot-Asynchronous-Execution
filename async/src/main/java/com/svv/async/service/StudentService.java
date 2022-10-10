package com.svv.async.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.svv.async.entity.Student;
import com.svv.async.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studRepo;

	public Student saveStudent(Student stud)
	{
		return studRepo.save(stud);
	}

	
	@Async
	public void printAllUsers() throws InterruptedException
	{
		List<Student> studentList = studRepo.findAll();
		
		Thread.sleep(3000);
		
		studentList.forEach(student->{System.out.println(Thread.currentThread().getName()+" -> "+student);});
		
	}

}
