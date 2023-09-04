package com.spring.main.controller;
import com.spring.main.services.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-subject")
public class StudentSubjectController {

    private final StudentSubjectService studentSubjectService;

    @Autowired
    public StudentSubjectController(StudentSubjectService studentSubjectService) {
        this.studentSubjectService = studentSubjectService;
    }

    @PostMapping("/connect")
    public void associateStudentWithSubject(
            @RequestParam Long studentId,
            @RequestParam Long subjectId) {
        studentSubjectService.associateStudentWithSubject(studentId, subjectId);
    }
}
