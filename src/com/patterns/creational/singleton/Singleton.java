package com.patterns.creational.singleton;

public class Singleton {
    private static Singleton instance;
    private String databaseUrl;

    private Singleton() {
        databaseUrl = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Singleton створено!");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getDatabaseUrl() { return databaseUrl; }
    public void setDatabaseUrl(String url) { this.databaseUrl = url; }
}