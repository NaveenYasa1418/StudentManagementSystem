package com.studentmanagementsystem.student.controller;

import com.studentmanagementsystem.student.entity.Student;
import com.studentmanagementsystem.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("/students/new")
    public String addStudents( Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "save";
    }

    @PostMapping("/students")
    public String saveStudents(@ModelAttribute("student") Student student){
        studentService.saveStudents(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
       // studentService.getStudentById(id);
        return "edit";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student){
        Student eStudent = studentService.getStudentById(student.getId());
        eStudent.setId(student.getId());
        eStudent.setFirstName(student.getFirstName());
        eStudent.setLastName(student.getLastName());
        eStudent.setEmailAddress(student.getEmailAddress());
        studentService.updateStudent(eStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String removeStudent(@PathVariable("id") Long id){
        log.info("Inside Delete Method");
        studentService.removeStudentById(id);
        return "redirect:/students";
    }


}
