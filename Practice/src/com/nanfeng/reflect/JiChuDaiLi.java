package com.nanfeng.reflect;

/**
 * Author：nanfeng
 * Created:2019/8/5
 */
//interface ISubject {
//    void eat();
//}
//
//class RealSubject implements ISubject {
//
//    @Override
//    public void eat() {
//        System.out.println("吃签佰度");
//    }
//}
//
//class ProxySubject implements ISubject {
//    private ISubject subject;
//
//    public ProxySubject(ISubject subject) {
//        this.subject = subject;
//    }
//
//    @Override
//    public void eat() {
//        beforeEat();
//        this.subject.eat();
//        afterEat();
//    }
//
//    public void beforeEat() {
//        System.out.println("坐宝马吃串串");
//    }
//
//    public void afterEat() {
//        System.out.println("走回来锻炼");
//    }
//}
//
//public class JiChuDaiLi {
//    public static void main(String[] args) {
//        ISubject subject = new ProxySubject(new RealSubject());
//        subject.eat();
//    }
//}
