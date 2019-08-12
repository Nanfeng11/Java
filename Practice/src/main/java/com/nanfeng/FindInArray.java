package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/12
 */
public class FindInArray {
    public boolean Find(int target, int [][] array) {
        for(int i = 0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if (array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
