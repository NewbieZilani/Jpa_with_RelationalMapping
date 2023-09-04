package com.spring.main.controller;

import com.spring.main.entity.StudentEntity;
import com.spring.main.entity.SubjectEntity;
import com.spring.main.repository.SubjectRepository;
import com.spring.main.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectRepository subjectRepository, SubjectService subjectService) {
        this.subjectRepository = subjectRepository;
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addSubject(@RequestBody SubjectEntity subject) {
        SubjectEntity savedSubject = subjectRepository.save(subject);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<SubjectEntity>> getAllSubject() {
        List<SubjectEntity> subjectList = subjectRepository.findAll();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

    // find the list of student who took a specific subject
    @GetMapping("/{subjectId}/students")
    public ResponseEntity<List<StudentEntity>> getStudentsForSubject(@PathVariable Long subjectId) {
        SubjectEntity subject = subjectRepository.findById(subjectId).orElse(null);
        if (subject == null) {
            return ResponseEntity.notFound().build();
        }

        List<StudentEntity> students = subject.getStudents();

        return ResponseEntity.ok(students);
    }


}
