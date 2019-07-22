package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/7/22
 */
public class JuXingFuGai {

    private static int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }

    private static int RectCover2(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] arr = new int[target + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target];
    }


    private static int RectCover3(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int fn1 = 1;
        int fn2 = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = fn1 + fn2;
            fn1 = fn2;
            fn2 = result;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(RectCover(4));
        System.out.println(RectCover2(4));
        System.out.println(RectCover3(4));
    }
}
