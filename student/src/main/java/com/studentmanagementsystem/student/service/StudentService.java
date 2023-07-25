package com.studentmanagementsystem.student.service;

import com.studentmanagementsystem.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudents(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student Student);

    void removeStudentById(Long id);

    void findByEmailAddress(String emailAddress);
}
