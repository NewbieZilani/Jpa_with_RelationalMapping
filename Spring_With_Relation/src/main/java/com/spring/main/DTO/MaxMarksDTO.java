package com.spring.main.DTO;

public class MaxMarksDTO {
    private String subjectName;
    private int maxMarks;

    public MaxMarksDTO() {
    }

    public MaxMarksDTO(String subjectName, int maxMarks) {
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }
}
