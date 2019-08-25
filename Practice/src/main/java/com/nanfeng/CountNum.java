package com.nanfeng;

import java.util.*;

/**
 * Author：nanfeng
 * Created:2019/8/25
 */
public class CountNum {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (map == null) {
                map.put(array[i], 1);
            } else {
                if (map.containsKey(array[i])) {
                    int count = map.get(array[i]);
                    map.put(array[i], count + 1);
                } else {
                    map.put(array[i], 1);
                }
            }
        }
        //排序
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() > array.length / 2) {
                return entry.getKey();
            }
        }
        return 0;

    }

    //方法二

//    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//    public int MoreThanHalfNum_Solution(int[] array) {
//        if (array.length == 0 || array == null) {
//            return 0;
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (map == null) {
//                map.put(array[i], 1);
//            } else {
//                if (map.containsKey(array[i])) {
//                    //map中已经存有该元素
//                    //获取该元素在map有几份,也就是在数组中出现了几次
//                    int count = map.get(array[i]);
//                    map.put(array[i], count + 1);
//                } else {
//                    //新元素
//                    map.put(array[i], 1);
//                }
//
//            }
//        }
//        //按照值进行排序
//        ArrayList<Map.Entry<Integer, Integer>> list = sortMap(map);
//        if (list.get(0).getValue() > array.length / 2) {
//            return list.get(0).getKey();
//        } else {
//            return 0;
//        }
//    }
//
//    public ArrayList<Map.Entry<Integer, Integer>> sortMap(Map map) {
//        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
//        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
//                return obj2.getValue() - obj1.getValue();
//            }
//        });
//        return (ArrayList<Map.Entry<Integer, Integer>>) entries;
//    }

    //方法三
//    public int MoreThanHalfNum_Solution(int [] array) {
//        Arrays.sort(array);
//        int len = array.length;
//        int num = array[len/2];
//        int count = 0;
//        for(int i=0; i<len; i++){
//            if(array[i] == num){
//                count++;
//            }
//        }
//        return count>(len/2)?num:0;
//    }
}
