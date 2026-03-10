package com.example.lab5springdi.service;

import com.example.lab5springdi.model.Student;
import com.example.lab5springdi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

