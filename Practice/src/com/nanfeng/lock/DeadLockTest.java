package com.nanfeng.lock;

/**
 * Author：nanfeng
 * Created:2019/8/6
 */
class Pen {
}

class Book {
}

public class DeadLockTest {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Book book = new Book();
        Thread penThread = new Thread(() -> {
            synchronized (pen) {
                System.out.println("我有笔，需要本子");
                synchronized (book) {
                    System.out.println("笔线程同时获取到笔与本子");
                }
            }
        });
        Thread bookThread = new Thread(() -> {
            synchronized (book) {
                System.out.println("我有本子，需要笔");
                synchronized (pen) {
                    System.out.println("本子线程同时获取本子与笔");
                }
            }
        });
        penThread.start();
        bookThread.start();
    }
}
