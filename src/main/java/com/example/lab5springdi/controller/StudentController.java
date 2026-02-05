package com.example.lab5springdi.controller;

import com.example.lab5springdi.model.Student;
import com.example.lab5springdi.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String viewStudents(Model model) {
        model.addAttribute("students", service.findAll());
        return "student";
    }

    @PostMapping("/add")
    public String addStudent(Student student) {
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        model.addAttribute("students", service.findByName(name));
        return "student";
    }
}
