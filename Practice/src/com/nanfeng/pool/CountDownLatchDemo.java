package com.nanfeng.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */
class CDLTask implements Runnable {
    //运动员线程
    private CountDownLatch countDownLatch;

    public CDLTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "到达终点");
        countDownLatch.countDown();
    }
}

public class CountDownLatchDemo {
    // 裁判线程
    public static void main(String[] args) {
        //多线程计数器
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CDLTask task = new CDLTask(countDownLatch);
        Thread thread1 = new Thread(task, "运动员A");
        Thread thread2 = new Thread(task, "运动员B");
        Thread thread3 = new Thread(task, "运动员C");
        System.out.println("开始比赛");
        thread1.start();
        thread2.start();
        thread3.start();
        // ...等待所有运动员到达终点
        try {
            //谁调用谁阻塞，直到countDownLatch的值减为0
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("比赛结束..");
    }
}
