package com.patterns.behavioral.ChainOfResponsibility;

public abstract class UniversityHandler {
    protected UniversityHandler next;

    public void setNext(UniversityHandler next) {
        this.next = next;
    }

    public abstract void handle(StudentRequest request);
}
