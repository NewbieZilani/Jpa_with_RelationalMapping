package com.spring.main.services;

import com.spring.main.entity.StudentEntity;
import com.spring.main.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }


}
