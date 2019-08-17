package com.nanfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/8/17
 */
public class Num {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] str = s.toCharArray();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                buf.append(str[i]);
            }
        }
        String st = buf.toString();
        char[] result = st.toCharArray();
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
