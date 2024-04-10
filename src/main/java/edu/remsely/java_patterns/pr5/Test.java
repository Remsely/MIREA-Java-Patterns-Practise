package edu.remsely.java_patterns.pr5;

public class Test {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();

        System.out.println(s1 == s2);

        SingletonHolder s3 = SingletonHolder.getInstance();
        SingletonHolder s4 = SingletonHolder.getInstance();

        System.out.println(s3 == s4);

        SingletonStatic s5 = SingletonStatic.getInstance();
        SingletonStatic s6 = SingletonStatic.getInstance();

        System.out.println(s5 == s6);
    }
}
