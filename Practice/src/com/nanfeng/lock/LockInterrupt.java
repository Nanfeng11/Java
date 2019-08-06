package com.nanfeng.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author：nanfeng
 * Created:2019/8/6
 */
class LockTaskOne implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            while (true) {
                lock.lockInterruptibly();
            }
        } catch (Exception e) {
            System.out.println("进入catch块，线程终止");
            return;
        } finally {
            lock.unlock();
        }
    }
}

public class LockInterrupt {
    public static void main(String[] args) throws InterruptedException {
        LockTaskOne taskOne = new LockTaskOne();
        Thread thread = new Thread(taskOne);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
