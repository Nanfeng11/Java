package com.nanfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/8/15
 */
public class FindNum {

    public static int Finds(int[] arr, int start, int end, int num) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                return Finds(arr, mid + 1, end, num);
            } else {
                return Finds(arr, start, mid - 1, num);
            }
        } else {
            return -1;
        }
    }

    public static int Find(int[] arr, int num) {
        return Finds(arr, 0, arr.length, num);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 13, 15, 17, 19, 21};
        int index = Find(arr, 15) + 1;
        System.out.println(index);
    }
}



