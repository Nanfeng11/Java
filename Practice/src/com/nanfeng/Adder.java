package com.nanfeng;

import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/8/8
 */
public class Adder {
    private static String add(String num1, String num2)
    {
        //Please write your code here
        //拆成字符串
        char[] arrNum1 = num1.toCharArray();
        char[] arrNum2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = arrNum1.length-1;
        int j = arrNum2.length-1;
        //进位
        int count = 0;
        while (i>=0 || j>=0){
            int sum = 0;
            if (i<0){
                sum = arrNum2[j--]+count-'0';
            }
            if (j<0){
                sum = arrNum2[i--]+count-'0';
            }
            if (i>=0 && j>=0){
                sum = arrNum1[i--]+arrNum2[j--]+count-2*'0';
            }
            //相加之和大于9，需要进位，本位减10
            if (sum>9){
                count=1;
                sum-=10;
            }else {
                count=0;
            }
            //拼接每一位
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

    // please don't modify any code below.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }
}