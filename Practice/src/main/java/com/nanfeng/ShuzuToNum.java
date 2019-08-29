package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/29
 */
public class ShuzuToNum {
    public String PrintMinNumber(int [] numbers) {
        int tmp = 0;
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                String str1 = numbers[i]+""+numbers[j];
                String str2 = numbers[j]+""+numbers[i];
                if (str1.compareTo(str2)>0){
                    tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        String str = "";
        for (int i=0; i<numbers.length; i++){
            str += String.valueOf(numbers[i]);
        }
        return str;
    }
}
