package com.patterns.behavioral.ChainOfResponsibility;

public class Lecturer extends UniversityHandler {
    @Override
    public void handle(StudentRequest request) {
        if (request.getDifficulty() == 2) {
            System.out.println("Викладач: Залік з предмета '" + request.getSubject() +
                    "' для студента " + request.getStudentName() + " виставлено успішно.");
        } else if (next != null) {
            next.handle(request);
        }
    }
}
