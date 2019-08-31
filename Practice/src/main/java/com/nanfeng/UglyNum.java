package com.nanfeng;

import java.util.ArrayList;

/**
 * Author：nanfeng
 * Created:2019/8/31
 */
public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int t2 = 0, t3 = 0, t5 = 0;
        while (list.size() < index) {
            int m2 = list.get(t2) * 2;
            int m3 = list.get(t3) * 3;
            int m5 = list.get(t5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2)
                t2++;
            if (min == m3)
                t3++;
            if (min == m5)
                t5++;
        }
        return list.get(list.size() - 1);
    }
}
