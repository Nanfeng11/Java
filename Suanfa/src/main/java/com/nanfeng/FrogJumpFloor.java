package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/7/21
 */
public class FrogJumpFloor {

    //一次只能跳一级或者两级
    private static int methodCount(int n){
        if (n<=0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int result = 0;
        for (int i=3;i<=n;i++){
            result = f1+f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }

    //一次可以跳1级，2级，...，n级
    private static int methodCount2(int n){
        if (n<=0){
            return 0;
        }
        int total = 1;
        for (int i=2;i<=n;i++){
            total *= 2;
        }
        return total;
    }
    //优化
    private static int methodCount3(int n){
        if (n<=0){
            return 0;
        }
        return 1<<(n-1);
    }

    public static void main(String[] args) {
        System.out.println(methodCount(4));
        System.out.println(methodCount2(4));
        System.out.println(methodCount3(4));
    }
}
