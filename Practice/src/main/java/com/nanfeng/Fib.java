package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/16
 */
//public class Fib {
//    public int fibo(int n){
//        if (n<=1)
//            return n;
//        return fibo(n-1) + fibo(n-2);
//    }
//}

//public class Fib {
//    public int fibo(int n){
//        int[] arr = new int[100];
//        arr[0] = 0;
//        arr[1] = 1;
//        for(int i=2; i<=n; i++){
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        return arr[n];
//    }
//}

public class Fib {
    public int fibo(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int sum = 0;
        int one = 0;
        int two = 1;
        for(int i=2; i<=n; i++){
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
