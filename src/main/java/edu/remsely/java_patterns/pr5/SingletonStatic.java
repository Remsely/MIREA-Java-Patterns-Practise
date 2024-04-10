package edu.remsely.java_patterns.pr5;

public class SingletonStatic {
    private static final SingletonStatic instance;

    static {
        instance = new SingletonStatic();
    }

    private SingletonStatic() {
    }

    public static SingletonStatic getInstance() {
        return instance;
    }
}
