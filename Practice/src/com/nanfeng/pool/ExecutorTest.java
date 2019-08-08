package com.nanfeng.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */
//提交速度>执行速度
//class CachedTask implements Runnable {
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName());
//        try {
//            TimeUnit.MILLISECONDS.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//public class ExecutorTest {
//
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.submit(new CachedTask());
//        }
//        executorService.shutdown();
//    }
//
//}


//提交速度<执行速度
class CachedTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new CachedTask());
        }
        executorService.shutdown();
    }

}