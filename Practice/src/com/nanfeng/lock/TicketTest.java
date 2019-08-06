package com.nanfeng.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author：nanfeng
 * Created:2019/8/6
 */
class Task implements Runnable {
    private int ticket = 20;
    private Lock lock = new ReentrantLock();

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                //需要加锁，临界区代码
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            "还剩下" + ticket-- + "票");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class TicketTest {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task, "黄牛A").start();
        new Thread(task, "黄牛B").start();
        new Thread(task, "黄牛C").start();
    }
}
