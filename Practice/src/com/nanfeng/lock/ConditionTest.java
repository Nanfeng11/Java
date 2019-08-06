package com.nanfeng.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Author：nanfeng
 * Created:2019/8/6
 */

class Goods {
    //商品名称
    private String name;
    //当前商品数量
    private int count;
    //商品最大数量
    private int maxCount;

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    private Lock lock = new ReentrantLock();
    //消费者队列
    private Condition consumer = lock.newCondition();
    //生产者队列
    private Condition producer = lock.newCondition();

    /**
     * 生产方法
     *
     * @param name 生产的商品名称
     */
    public void setGoods(String name) {
        lock.lock();
        try {
            //当商品数量达到了最大值时阻塞生产者线程
            while (count > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "商品已达到最大数量，等待消费者消费"
                );
                producer.await();
            }
            Thread.sleep(200);
            //生产商品
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            //唤醒消费者进程
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费方法
     */
    public void getGoods() {
        lock.lock();
        try {
            //商品数为0时阻塞消费者线程
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() +
                        "商品已被消费完，等待生产者生产"
                );
                consumer.await();
            }
            Thread.sleep(200);
            //消费商品
            count--;
            System.out.println(Thread.currentThread().getName() + "消费" + toString());
            //唤醒生产者线程
            producer.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" + "name='" + name + '\'' + "count=" + count + "}";
    }
}

class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.setGoods("迪奥999");
        }
    }
}

class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.getGoods();
        }
    }
}

public class ConditionTest {
    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        //创建10个消费者模型
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(consumer, "消费者" + i);
            list.add(thread);
        }
        //创建5个生产者线程
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer, "生产者" + i);
            list.add(thread);
        }
        for (Thread th : list) {
            th.start();
        }
    }
}
