package com.haughty.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadTest {

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();  // 顺序打印
//        ExecutorService executor = Executors.newFixedThreadPool(5);
        ExecutorService executor = Executors.newCachedThreadPool();
//        ExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new MyThread(i));
        }
        executor.shutdown();
    }

}
