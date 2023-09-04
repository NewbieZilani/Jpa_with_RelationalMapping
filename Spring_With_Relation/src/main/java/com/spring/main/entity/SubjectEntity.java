package com.spring.main.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name")
    private String name;

    @Column(name = "marks")
    private int marks;

    @ManyToMany(mappedBy = "subjects")
    private List<StudentEntity> students;

    public SubjectEntity() {
    }

    public SubjectEntity(Long subjectId, String name, int marks, List<StudentEntity> students) {
        this.subjectId = subjectId;
        this.name = name;
        this.marks = marks;
        this.students = students;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}

