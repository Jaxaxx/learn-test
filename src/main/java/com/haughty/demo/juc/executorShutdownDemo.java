package com.haughty.demo.juc;

import java.util.concurrent.*;

public class executorShutdownDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            String name = Thread.currentThread().getName();
//            System.out.printf("hello %s", name);
//            System.out.println();
//        });

        Future<String> submit = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "1123";
            }
        });

        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("尝试关闭线程执行器...");
            executor.shutdown();
            boolean result = executor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            System.err.println("关闭任务被中断");
            e.printStackTrace();
        } finally {
            if (executor.isTerminated()) {
                System.out.println("取消未完成的任务");
                executor.shutdownNow();
            }
            System.out.println("任务关闭完成");
        }
    }
}
/**
 * 执行结果
 * <p>
 * hello pool-1-thread-1
 * 尝试关闭线程执行器...
 * 任务关闭完成
 * 取消未完成的任务
 * <p>
 * --
 * 1.shutdown     只是将线程池的状态设置为SHUTDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断
 * 2.shutdownNow  则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
 * 3.awaitTermination(long timeOut , TImeUnit unit)
 *   3.1 等所有已提交的任务（包括正在执行的和队列中等待的）执行完
 *   3.2 或者等待时间到
 *   3.3 或者线程被中断， 抛出InterruptedException
 *   然后返回true
 *
 */