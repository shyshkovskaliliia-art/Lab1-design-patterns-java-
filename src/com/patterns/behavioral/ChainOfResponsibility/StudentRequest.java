package com.patterns.behavioral.ChainOfResponsibility;

public class StudentRequest {
    private String studentName;
    private String subject;
    private int difficulty;

    public StudentRequest(String studentName, String subject, int difficulty) {
        this.studentName = studentName;
        this.subject = subject;
        this.difficulty = difficulty;
    }

    public int getDifficulty() { return difficulty; }
    public String getStudentName() { return studentName; }
    public String getSubject() { return subject; }
}
