package com.nanfeng.reflect;

import java.util.concurrent.TimeUnit;

/**
 * Author：nanfeng
 * Created:2019/8/5
 */
//class Task implements Runnable {
//
//    /**
//     * synchronized同步方法，对象锁，锁的是当前Task类的对象：this
//     */
//    public synchronized void testA() {
//        System.out.println("A!");
//        while (true) {
//        }
//    }
//
//    /**
//     * 也锁的是this
//     * A线程没有被锁住，可以进入同步方法，锁住当前对象后没有释放锁
//     * B要进入同步方法的前提是拿到当前对象锁的monitor，但是A一直没释放，所以B一直卡着
//     */
//    public synchronized void testB() {
//        System.out.println("B!");
//    }
//
//输出A!
//    @Override
//    public void run() {
//        if (Thread.currentThread().getName().equals("A")) {
//            testA();
//        } else {
//            testB();
//        }
//    }
//}

//class Task implements Runnable {
//
//    public synchronized void testA() {
//        System.out.println("A!");
//        try {
//            /**
//             * 2秒后A线程执行完毕，释放锁，B可以进同步方法了
//             */
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void testB() {
//        System.out.println("B!");
//    }
//
//    //输出A!B!
//    @Override
//    public void run() {
//        if (Thread.currentThread().getName().equals("A")) {
//            testA();
//        } else {
//            testB();
//        }
//    }
//}


//class Task implements Runnable {
//
//    /**
//     * synchronized的可重入性
//     * 打印完A要执行testB了，执行前判断能不能拿到当前对象的monitor，
//     * 虽然monitor不为0，但是持有锁的线程就是当前线程，所以进入，monitor加1
//     */
//    public synchronized void testA() {
//        System.out.println("A!");
//        testB();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void testB() {
//        System.out.println("B!");
//    }
//
//    //输出A!B!B!
//    @Override
//    public void run() {
//        if (Thread.currentThread().getName().equals("A")) {
//            testA();
//        } else {
//            testB();
//        }
//    }
//}

class Task implements Runnable {

    /**
     * synchronized的可重入性
     * 打印完A要执行testB了，执行前判断能不能拿到当前对象的monitor，
     * 虽然monitor不为0，但是持有锁的线程就是当前线程，所以进入，monitor加1
     */
    public synchronized void testA() {
        System.out.println("A!");
        testB();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void testB() {
        System.out.println("B!");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //输出A!B!B!(间隔4秒)————加锁两次，B释放后A的monitor还要减一
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("A")) {
            testA();
        } else {
            testB();
        }
    }
}

public class SychronizedTest {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task, "A");
        Thread thread2 = new Thread(task, "B");
        thread1.start();
        thread2.start();
    }
}

