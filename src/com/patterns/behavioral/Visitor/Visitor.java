package com.patterns.behavioral.Visitor;

public interface Visitor {
    void visitFile(File file);
    void visitDirectory(Directory directory);
}
