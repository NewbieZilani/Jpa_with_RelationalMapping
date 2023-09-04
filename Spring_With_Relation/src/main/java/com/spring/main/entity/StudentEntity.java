package com.spring.main.entity;

import com.spring.main.DTO.StudentSubjectDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "gender")
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<SubjectEntity> subjects;


    public StudentEntity() {
    }

    public StudentEntity(Long studentId, String studentName, String gender, List<SubjectEntity> subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.subjects = subjects;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }


    public List<StudentSubjectDTO> getSubjectsWithMarks() {
        List<StudentSubjectDTO> subjectsWithMarks = new ArrayList<>();
        for (SubjectEntity subject : subjects) {
            StudentSubjectDTO dto = new StudentSubjectDTO();
            dto.setSubjectName(subject.getName());
            dto.setMarks(subject.getMarks());
            subjectsWithMarks.add(dto);
        }
        return subjectsWithMarks;
    }

}
