package com.nanfeng.reflect;

/**
 * Author：nanfeng
 * Created:2019/8/5
 */
public class TestDemo {
    public static void main(String[] args) {
        Class<?> cls = TestDemo.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
    }
}
