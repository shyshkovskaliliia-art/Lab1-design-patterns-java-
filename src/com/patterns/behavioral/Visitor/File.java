package com.patterns.behavioral.Visitor;

public class File implements FileSystemElement {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() { return size; }
    public String getName() { return name; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFile(this);
    }
}
