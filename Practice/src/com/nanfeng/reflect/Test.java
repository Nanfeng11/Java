package com.nanfeng.reflect;

/**
 * Author：nanfeng
 * Created:2019/8/5
 */
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(test()); //3
//    }
//
//    public static int test() {
//        int i = 0;
//        try {
//            i = 1;
//            return i;
//        } catch (Exception e) {
//            i = 2;
//            return i;
//        } finally {
//            i = 3;
//            return i;
//        }
//    }
//}

public class Test {
    public static void main(String[] args) {
        System.out.println(test()); //1
    }

    public static int test() {
        int i = 0;
        try {
            i = 1;
            return i;
        } catch (Exception e) {
            i = 2;
            return i;
        } finally {
            i = 3;
        }
    }
}
