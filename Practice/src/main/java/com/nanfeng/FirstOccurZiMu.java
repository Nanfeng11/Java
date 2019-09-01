package com.nanfeng;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：nanfeng
 * Created:2019/9/1
 */
public class FirstOccurZiMu {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (int i=0; i<str.length(); i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        for (int i=0; i<str.length(); i++){
            if (map.get(arr[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
