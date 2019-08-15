package com.nanfeng;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author：nanfeng
 * Created:2019/8/15
 */
//方法一：
//时间复杂度：O(n)
//空间复杂度：O(1)
//public class FingMin {
//    public int minNumberInRotateArray(int [] array) {
//        int n = array.length;
//        if (n == 0)
//            return 0;
//        for (int i=0; i<n-1; i++){
//            if (array[i]>array[i+1]){
//                return array[i+1];
//            }
//        }
//        return array[0];
//    }
//}

//方法二：
//时间复杂度：O(nlogn)
//空间复杂度：O(1)
//public class FingMin {
//    public int minNumberInRotateArray(int [] array) {
//        int n = array.length;
//        if (n == 0)
//            return 0;
//        Arrays.sort(array);
//        return array[0];
//    }
//}

//方法三：优先级队列
//时间复杂度：O(n)
//空间复杂度：O(n)
public class FingMin {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (n == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<n; i++){
            queue.add(array[i]);
        }
        return queue.poll();
    }
}

