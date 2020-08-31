package com.haughty.demo.juc;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(4);
        for (int i = 0; i < 5; i++) {
            scheduledThreadPoolExecutor.execute(new ScheduledThread(i));
            // initialDelay表示首次执行任务的延迟时间，参数2：period表示每次执行任务的间隔时间，参数3：TimeUnit.MILLISECONDS执行的时间间隔数值单位
//            scheduledThreadPoolExecutor.scheduleAtFixedRate(new ScheduledThread(i), 1000, 2000, TimeUnit.MILLISECONDS);
        }
    }

}
