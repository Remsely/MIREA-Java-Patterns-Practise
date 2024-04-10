package edu.remsely.java_patterns.pr4;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final int threadCount = 5;
        SimpleExecutorService executor = new SimpleExecutorService(threadCount);

        Runnable task = () -> System.out.println("Current thread:" + Thread.currentThread().getName());

        for (int i = 0; i < threadCount * 2; i++) {
            executor.submit(task);
        }

        TimeUnit.MILLISECONDS.sleep(100);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Finished all threads");
    }
}
