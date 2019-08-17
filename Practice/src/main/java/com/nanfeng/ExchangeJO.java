package com.nanfeng;

import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/8/17
 */
public class ExchangeJO {
    public void reOrderArray(int [] array) {
        int one = 0;
        int two = 0;
        while(two < array.length){
            if((array[two] & 1) == 1){
                int tmp = array[two];
                for(int i=two; i>one; i--){
                    array[i] = array[i-1];
                }
                array[one] = tmp;
                one++;
                two++;
            }else{
                two++;
            }
        }
    }
}

//方法一：使用两个数组
//public static int[] reOrderArray(int[] array) {
//    int len = array.length;
//    int[] newArr = new int[len];
//    int j = 0;
//    for (int i = 0; i < len; i++) {
//        if ((array[i] & 1) == 1) {
//            newArr[j] = array[i];
//            j++;
//        }
//    }
//    for (int i = 0; i < len; i++) {
//        if ((array[i] & 1) == 0) {
//            newArr[j] = array[i];
//            j++;
//        }
//    }
//    return newArr;
//}
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //输入几个数字
//        int n = scanner.nextInt();
//        int[] array = new int[n];
//        for (int i=0; i<n; i++){
//            array[i] = scanner.nextInt();
//        }
//        int[] arr = reOrderArray(array);
//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j]+" ");
//        }
//    }

//方法二：只要偶数在奇数前面就进行交换
//public void reOrderArray2(int[] array) {
//    for (int i = 0; i < array.length; i++) {
//        for (int j = 0; j < array.length - 1; j++) {
//            if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
//                int temp = array[j];
//                array[j] = array[j + 1];
//                array[j + 1] = temp;
//            }
//        }
//    }
//}





