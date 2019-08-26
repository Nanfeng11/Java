package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/26
 */
public class FindMinSonXulie {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0){
            return -1;
        }
        int sum = array[0];
        int maxSum = array[0];
        for (int i=1; i<array.length; i++){
            sum = (sum>0) ? (sum+array[i]) : array[i];
            maxSum = (sum<maxSum) ? maxSum : sum;
        }
        return maxSum;
    }
}
