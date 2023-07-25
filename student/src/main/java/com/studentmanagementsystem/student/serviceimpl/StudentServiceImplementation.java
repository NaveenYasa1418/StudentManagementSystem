package com.studentmanagementsystem.student.serviceimpl;

import com.studentmanagementsystem.student.entity.Student;
import com.studentmanagementsystem.student.repository.StudentRepository;
import com.studentmanagementsystem.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudents(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void findByEmailAddress(String emailAddress) {
        studentRepository.findStudentByEmailAddress(emailAddress);
    }
}
