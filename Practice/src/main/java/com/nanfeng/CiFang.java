package com.nanfeng;

import static java.lang.Math.pow;

/**
 * Author：nanfeng
 * Created:2019/8/16
 */
//public class CiFang {
//    public double Power(double base, int exponent) {
//        double result = 1.0;
//        if(exponent == 0){
//            return 1;
//        }else if(exponent > 0){
//            for(int i=1; i<=exponent; i++){
//                result *= base;
//            }
//        }else{
//            for(int i=1; i<= -exponent; i++){
//                result *= base;
//            }
//        }
//        return exponent>0? result: 1/result;
//    }
//}

public class CiFang {
    public double Power(double base, int exponent) {
        double res = 1;
        double cur = base;
        int n;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            n = -exponent;
        } else {
            return 1;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= cur;
            }
            cur *= cur;
            n >>= 1;
        }
        return exponent > 0 ? res : 1 / res;
    }
}
