package edu.remsely.java_patterns.pr4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleExecutorService {
    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final Thread[] workerThreads;
    private final AtomicBoolean isRunning = new AtomicBoolean(true);

    public SimpleExecutorService(int threadCount) {
        this.workerThreads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            workerThreads[i] = new Worker("Worker-" + i);
            workerThreads[i].start();
        }
    }

    public void shutdown() {
        isRunning.set(false);
    }

    public void submit(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long terminationTime = System.currentTimeMillis() + unit.toMillis(timeout);
        for (Thread thread : workerThreads) {
            long remainingTime = terminationTime - System.currentTimeMillis();
            if (remainingTime > 0) {
                thread.join(remainingTime);
            }
        }
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (isRunning.get() || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.poll(1, TimeUnit.SECONDS);
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    if (!isRunning.get()) {
                        break;
                    }
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
