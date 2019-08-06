package com.nanfeng.lock;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用synchronized+wait()/notify()实现多生产者-消费者模型
 * Author：nanfeng
 * Created:2019/8/6
 */

class Goods {
    //商品名称
    private String goodsName;
    //商品库存
    private int count;

    //生产方法
    public synchronized void set(String goodsName) throws InterruptedException {
        //此时还有商品没被消费，等待消费者消费
        while (this.count > 0) {
            wait();
        }
        this.goodsName = goodsName;
        this.count = count + 1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("生产" + toString());
        System.out.println("-------------------------");
        //生产完商品后通知消费者线程可以消费了
        notifyAll();
    }

    class Producer implements Runnable {
        private Goods goods;

        public Producer(Goods goods) {
            this.goods = goods;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    this.goods.set("迪奥999");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费方法
    public synchronized void get() throws InterruptedException {
        //此时还没有商品，等待生产者生产商品
        while (this.count == 0) {
            wait();
        }
        //每次消费一个商品
        this.count = this.count - 1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("消费" + toString());
        System.out.println("-------------------");
        //消费完告知生产者线程可以继续生产了
        notifyAll();
    }

    class Consumer implements Runnable {
        private Goods goods;

        public Consumer(Goods goods) {
            this.goods = goods;
        }

        @Override
        public void run() {
            try {
                this.goods.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Goods [goodsName=" + goodsName + ",count=" + count + "]";
    }
}

/**
 * 生产者类
 */
class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.set("迪奥999");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者类
 */
class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SynchronizedTest {
    public static void main(String[] args) {
        Goods goods = new Goods();
        //存储生产者、消费者线程
        List<Thread> threadList = new ArrayList<>();
        //10个生产者线程
        for (int i = 0; i < 10; i++) {
            Thread producerThread = new Thread(new Producer(goods));
            producerThread.setName("生产者线程" + i);
            threadList.add(producerThread);
        }
        //6个消费者线程
        for (int i = 0; i < 6; i++) {
            Thread consumerThread = new Thread(new Consumer(goods));
            consumerThread.setName("消费者线程" + i);
            threadList.add(consumerThread);
        }
        //启动所有线程
        for (Thread thread : threadList) {
            thread.start();
        }
    }
}
