package com.patterns.behavioral.ChainOfResponsibility;

public class Dean extends UniversityHandler {
    @Override
    public void handle(StudentRequest request) {
        if (request.getDifficulty() == 3) {
            System.out.println("Декан: Студент " + request.getStudentName() +
                    " отримав дозвіл на перездачу або закриття іспиту з '" + request.getSubject() + "'.");
        } else {
            System.out.println("Адміністрація: Запит відхилено. Рівень складності перевищує повноваження деканату.");
        }
    }
}
