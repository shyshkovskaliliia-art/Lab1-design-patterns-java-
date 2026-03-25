package com.patterns.behavioral.Visitor;

public class SizeCalculator implements Visitor {
    private int totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
        System.out.println("Файл '" + file.getName() + "': " + file.getSize() + " КБ додано.");
    }

    @Override
    public void visitDirectory(Directory directory) {
        System.out.println("Аналіз папки: " + directory.getName());
    }

    public int getTotalSize() {
        return totalSize;
    }
}
