package com.nanfeng.reflect;

/**
 * Author：nanfeng
 * Created:2019/8/5
 */
//public class ExceptionTest {
//    int age;
//
//    public static void main(String[] args) {
//        System.out.println(test().age); //30
//        //引用类型，指向同一块堆空间，只new一次
//    }
//
//    public static ExceptionTest test() {
//        ExceptionTest test = new ExceptionTest();
//        try {
//            test.age = 10;
//            return test;
//        } catch (Exception e) {
//            test.age = 20;
//            return test;
//        } finally {
//            test.age = 30;
//        }
//    }
//}

public class ExceptionTest {
    int age;

    public static void main(String[] args) {
        System.out.println(test().age); //10
        //引用类型，指向同一块堆空间，只new一次
    }

    public static ExceptionTest test() {
        ExceptionTest test = new ExceptionTest();
        try {
            test.age = 10;
            return test;
        } catch (Exception e) {
            test.age = 20;
            return test;
        } finally {
            test = new ExceptionTest();
            test.age = 30;
        }
    }
}
