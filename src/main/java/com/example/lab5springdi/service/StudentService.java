package com.example.lab5springdi.service;

import com.example.lab5springdi.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAll();

    Student findById(Integer id);

    List<Student> findByName(String name);

}
