package com.example.lab5springdi.controller;

import com.example.lab5springdi.model.Student;
import com.example.lab5springdi.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Hiển thị danh sách
    @GetMapping
    public String viewStudents(Model model) {
        model.addAttribute("students", service.findAll());
        model.addAttribute("student", new Student());
        return "student";
    }

    // Thêm sinh viên
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

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer id) {
        service.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/edit")
    public String editStudent(@RequestParam Integer id, Model model){
        model.addAttribute("student", service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateStudent(Student student){
        service.save(student);
        return "redirect:/students";
    }
}