package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/16
 */
//public class JuXing {
//    public int RectCover(int target) {
//        if (target<=0)
//            return 0;
//        if (target == 1)
//            return 1;
//        if (target == 2)
//            return 2;
//        int f1 = 1;
//        int f2 = 2;
//        int result = 0;
//        for (int i=3; i<=target; i++){
//            result = f1 + f2;
//            f1 = f2;
//            f2 = result;
//        }
//        return result;
//    }
//}

//public class JuXing {
//    public int RectCover(int target) {
//        if (target<=0)
//            return 0;
//        if (target == 1)
//            return 1;
//        if (target == 2)
//            return 2;
//        return RectCover(target-1) + RectCover(target-2);
//    }
//}

public class JuXing {
    public int RectCover(int target) {
        if (target<=0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] arr = new int[target+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=target; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[target];
    }
}
