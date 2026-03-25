package com.patterns.behavioral.Memento;

import java.util.Stack;

public class GitHistory {
    private Stack<GitCommit> history = new Stack<>();

    public void push(GitCommit commit) {
        history.push(commit);
    }

    public GitCommit pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
