package com.nanfeng;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author：nanfeng
 * Created:2019/8/26
 */
public class FindMinNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k>input.length){
            return list;
        }
        Arrays.sort(input);
        for(int i = 0; i<k; i++){
            list.add(input[i]);
        }
        return list;
    }
}
