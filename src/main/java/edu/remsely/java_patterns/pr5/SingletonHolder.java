package edu.remsely.java_patterns.pr5;

public class SingletonHolder {
    private SingletonHolder() {
    }

    private static class Holder {
        private static SingletonHolder INSTANCE = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return Holder.INSTANCE;
    }
}
