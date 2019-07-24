package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/7/24
 */
public class maxZiXuLieSum {
    private static int maxSum(int[] array){
        if (array.length == 0){
            return -1;
        }
        int sum = array[0];
        int maxsum = array[0];
        for (int i=0;i<array.length;i++){
            sum = (sum>0)?sum+array[i]:array[i];
            maxsum = (sum<maxsum)?maxsum:sum;
        }
        return maxsum;
    }

}
