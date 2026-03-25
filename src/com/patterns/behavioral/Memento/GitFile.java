package com.patterns.behavioral.Memento;

public class GitFile {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public GitCommit save() {
        System.out.println("Git: Збереження стану (commit)...");
        return new GitCommit(content);
    }

    public void restore(GitCommit commit) {
        this.content = commit.getContent();
        System.out.println("Git: Стан відновлено до: " + content);
    }
}
