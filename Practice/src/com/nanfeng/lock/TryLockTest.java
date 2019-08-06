package com.nanfeng.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author：nanfeng
 * Created:2019/8/6
 */

class LockTaskTwo implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        boolean isLock = false;
        try {
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() +
                        "获取锁成功");
                TimeUnit.SECONDS.sleep(1);
                isLock = true;
            } else {
                System.out.println("获取锁失败，线程继续运行");
            }
        } catch (Exception e) {

        } finally {
            if (isLock) {
                lock.unlock();
            }
        }
    }
}

public class TryLockTest {
    public static void main(String[] args) {
        LockTaskTwo taskTwo = new LockTaskTwo();
        Thread threadA = new Thread(taskTwo, "线程A");
        Thread threadB = new Thread(taskTwo, "线程B");
        threadA.start();
        threadB.start();
    }
}

//class LockTaskTwo implements Runnable {
//    private Lock lock = new ReentrantLock();
//
//    @Override
//    public void run() {
//        boolean isLock = false;
//        try {
//            if (lock.tryLock(2, TimeUnit.SECONDS)) {
//                System.out.println(Thread.currentThread().getName() +
//                        "获取锁成功");
//                TimeUnit.SECONDS.sleep(1);
//                isLock = true;
//            } else {
//                System.out.println("获取锁失败，线程继续运行");
//            }
//        } catch (Exception e) {
//
//        } finally {
//            if (isLock) {
//                lock.unlock();
//            }
//        }
//    }
//}
//
//public class TryLockTest {
//    public static void main(String[] args) {
//        LockTaskTwo taskTwo = new LockTaskTwo();
//        Thread threadA = new Thread(taskTwo, "线程A");
//        Thread threadB = new Thread(taskTwo, "线程B");
//        threadA.start();
//        threadB.start();
//    }
//}