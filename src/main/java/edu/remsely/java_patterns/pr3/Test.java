package edu.remsely.java_patterns.pr3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        testMap(new SemaphoreMap<>());
        testMap(new HashMap<>());
        testSet(new SynchronizedSet<>());
        testSet(new HashSet<>());
    }

    public static void testMap(Map<Integer, String> map) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, String.valueOf(i));
            }
        };

        for (int i = 0; i < 100; i++) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(map.size());
    }

    public static void testSet(Set<Integer> set) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                set.add(i);
            }
        };

        for (int i = 0; i < 1000; i++) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(set.size());
    }
}
