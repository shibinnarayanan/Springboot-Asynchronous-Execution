package com.svv.async.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svv.async.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
