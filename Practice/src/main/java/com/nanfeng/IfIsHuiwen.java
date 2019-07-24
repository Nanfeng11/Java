package com.nanfeng;

import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/7/25
 */
public class IfIsHuiwen {
    private static boolean isHuiwen(String s){
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int count = 0;
        for (int i=0;i<=str1.length();i++){
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            if (isHuiwen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
