package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/16
 */
public class FindBinaryOne {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            //判断每一位是不是1
            count += (n&1);
            n >>>= 1;
        }
        return count;
    }
}
