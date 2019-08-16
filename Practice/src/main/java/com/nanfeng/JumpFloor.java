package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/16
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int f1 = 1;
        int f2 = 2;
        int result = 0;
        for(int i=3; i<=target; i++){
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
}
