package com.nanfeng;

import java.util.Arrays;

/**
 * Author：nanfeng
 * Created:2019/9/5
 */
public class CountYouXuNum {
    public int GetNumberOfK(int[] array, int k) {
        int index = Arrays.binarySearch(array, k);
        if (index < 0) {
            return 0;
        }
        int count = 1;
        for (int i = index + 1; i < array.length && array[i] == k; i++) {
            count++;
        }
        for (int i = index - 1; i > 0 && array[i] == k; i--) {
            count++;
        }
        return count;
    }
}
