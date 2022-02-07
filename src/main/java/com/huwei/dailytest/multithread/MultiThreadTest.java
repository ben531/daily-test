package com.huwei.dailytest.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new myThread());
//            Future<?> submit = executorService.submit(new myThread());
        }

        executorService.shutdown();
    }
}

class myThread implements Runnable {
    @Override
    public void run() {
        System.out.println("myThread is run" + Thread.currentThread().getName());
    }
}
