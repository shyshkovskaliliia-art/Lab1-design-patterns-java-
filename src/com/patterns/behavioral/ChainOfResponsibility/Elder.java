package com.patterns.behavioral.ChainOfResponsibility;

public class Elder extends UniversityHandler {
    @Override
    public void handle(StudentRequest request) {
        if (request.getDifficulty() == 1) {
            System.out.println("Староста: Питання по '" + request.getSubject() +
                    "' для " + request.getStudentName() + " вирішено (н-ки відпрацьовано).");
        } else if (next != null) {
            next.handle(request);
        }
    }
}
