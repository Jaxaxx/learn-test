package com.haughty.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池相关
 */
public class executorDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
        });
    }
}
