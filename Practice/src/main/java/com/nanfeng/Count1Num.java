package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/26
 */
public class Count1Num {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
