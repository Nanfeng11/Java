package com.nanfeng.reflect;

/**
 * Author：nanfeng
 * Created:2019/8/4
 */
public class GCTest {
    public static GCTest test;

    public void isAlive() {
        System.out.println("I am alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        test = this;
    }

    public static void main(String[] args) throws InterruptedException {
        test = new GCTest();
        test = null;
        System.gc();
        Thread.sleep(1000);
        if (test != null) {
            test.isAlive();
        } else {
            System.out.println("NO,I am dead!");
        }

        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        } else {
            System.out.println("NO,I am dead!");
        }

    }
}
