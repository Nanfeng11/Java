package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/21
 */
public class isSearchTreeHouXu {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int[] array, int start, int last) {
        if (start >= last) {
            return true;
        }

        int i = last;

        //右子树
        while (i > start && array[i - 1] > array[last]) {
            i--;
        }

        //左子树
        for (int j = i - 1; j >= start; j--) {
            if (array[j] > array[last]) {
                return false;
            }
        }

        return judge(array, start, i - 1) && judge(array, i, last - 1);
    }
}
