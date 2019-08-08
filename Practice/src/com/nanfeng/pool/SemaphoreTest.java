package com.nanfeng.pool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */
//工人的工作任务
class SemaphoreTask implements Runnable {
    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //获取设备
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "占用一台设备生产。。。");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "生产完毕，释放设备");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {
        //同时有5个设备可以生产
        Semaphore semaphore = new Semaphore(5);
        SemaphoreTask task = new SemaphoreTask(semaphore);
        for (int i = 0; i < 8; i++) {
            new Thread(task, "工人" + (i + 1)).start();
        }
    }
}
