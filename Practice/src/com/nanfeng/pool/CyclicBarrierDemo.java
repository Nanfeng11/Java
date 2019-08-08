package com.nanfeng.pool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */
class CBTask implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CBTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + "已经到达会场");
        try {
            // 当前线程阻塞，直到所有线程都到达此位置
            TimeUnit.SECONDS.sleep(2);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("所有人均已到场，会议开始");
    }
}

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
                () -> {
                    System.out.println("当前线程为" +
                            Thread.currentThread().getName());
                });
        CBTask task = new CBTask(cyclicBarrier);
        Thread thread1 = new Thread(task, "小王");
        Thread thread2 = new Thread(task, "小刘");
        Thread thread3 = new Thread(task, "小张");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}