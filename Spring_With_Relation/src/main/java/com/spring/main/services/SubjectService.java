package com.spring.main.services;

import com.spring.main.entity.SubjectEntity;
import com.spring.main.repository.SubjectRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SubjectService{
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity addSubject(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }

    public List<SubjectEntity> getAllSubject() {
        return subjectRepository.findAll();
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

}
