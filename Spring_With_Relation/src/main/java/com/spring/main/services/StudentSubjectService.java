package com.spring.main.services;

import com.spring.main.entity.StudentEntity;
import com.spring.main.entity.SubjectEntity;
import com.spring.main.repository.StudentRepository;
import com.spring.main.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public StudentSubjectService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public void associateStudentWithSubject(Long studentId, Long subjectId) {
        // Retrieve the student and subject entities from their respective repositories
        StudentEntity student = studentRepository.findById(studentId).orElse(null);
        SubjectEntity subject = subjectRepository.findById(subjectId).orElse(null);

        if (student != null && subject != null) {
            // Add the subject to the student's list of subjects
            student.getSubjects().add(subject);

            // Save the updated student entity, which will also update the join table
            studentRepository.save(student);
        }
    }
}






