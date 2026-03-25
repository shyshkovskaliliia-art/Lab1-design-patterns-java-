package com.patterns.behavioral.Memento;

public class GitCommit {
    private final String content;

    public GitCommit(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
