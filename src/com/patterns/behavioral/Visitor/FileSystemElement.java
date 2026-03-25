package com.patterns.behavioral.Visitor;

public interface FileSystemElement {
    void accept(Visitor visitor);
}
