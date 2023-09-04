package com.spring.main.controller;

import com.spring.main.DTO.MaxMarksDTO;
import com.spring.main.DTO.StudentSubjectDTO;
import com.spring.main.entity.StudentEntity;
import com.spring.main.entity.SubjectEntity;
import com.spring.main.repository.StudentRepository;
import com.spring.main.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService; // Initialize the service
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addCandidate(@RequestBody StudentEntity student) {
        StudentEntity savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentEntity>> getAllCandidate() {
        List<StudentEntity> studentList = studentRepository.findAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        Optional<StudentEntity> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            studentRepository.deleteById(studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //This endpoint is used for find all the subjects a student took with their marks
    @GetMapping("/student/{studentId}/subjects")
    public ResponseEntity<List<StudentSubjectDTO>> getStudentSubjects(@PathVariable Long studentId) {
        StudentEntity student = studentService.getStudentById(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        List<StudentSubjectDTO> subjectsWithMarks = student.getSubjectsWithMarks();
        return ResponseEntity.ok(subjectsWithMarks);
    }


    //This endpoint is used for find the maximum mark a student got in which subject
    @GetMapping("/{studentId}/maxmark")
    public ResponseEntity<MaxMarksDTO> getMaxMarksSubject(@PathVariable Long studentId) {
        StudentEntity student = studentService.getStudentById(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        List<SubjectEntity> subjects = student.getSubjects();
        if (subjects.isEmpty()) {
            return ResponseEntity.ok(new MaxMarksDTO("", 0));
        }

        int maxMarks = Integer.MIN_VALUE;
        String maxMarksSubjectName = "";

        for (SubjectEntity subject : subjects) {
            if (subject.getMarks() > maxMarks) {
                maxMarks = subject.getMarks();
                maxMarksSubjectName = subject.getName();
            }
        }

        MaxMarksDTO maxMarksDTO = new MaxMarksDTO(maxMarksSubjectName, maxMarks);
        return ResponseEntity.ok(maxMarksDTO);
    }

}