package com.studentmanagementsystem.student.repository;

import com.studentmanagementsystem.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentByEmailAddress(String emailAddress);
}
