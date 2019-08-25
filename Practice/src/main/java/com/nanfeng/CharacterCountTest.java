package com.nanfeng;


import java.util.*;

/**
 * Author：nanfeng
 * Created:2019/8/25
 */

public class CharacterCountTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(";");

        String str = strs[0];
        char one = str.charAt(0);
        char[] two = strs[1].toCharArray();

//        ArrayList<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < two.length; i++) {
            if (two[i] != one) {
//                list.add(two[i]);
            set.add(two[i]);
            }
        }

        System.out.println(set);

    }

//    //方法一
//    public static void method1(String s) {
//        Integer count;
//        Map<Character, Integer> map = new HashMap<>();
//        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
//        // 拆分字符串，统计字符个数
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            count = map.get(ch);
//            if (count == null) {
//                map.put(ch, 1);
//            } else {
//                map.put(ch, ++count);
//            }
//        }
//        // 遍历map，存到list中
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            list.add(entry);
//        }
//        // 根据字符个数进行比较
//        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                //return o1.getValue() - o2.getValue(); // 升序
//                return o2.getValue() - o1.getValue(); // 降序
//            }
//        });
//        // 遍历排序后输出
//        for (Map.Entry<Character, Integer> entry : list) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//    }
//
//    //方法二
//    public static void method2(String s) {
//        if (s==null){
//            System.out.println(-1);
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
//        // 拆分字符串，统计字符个数
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (map.containsKey(ch)) {
//                map.put(ch, map.get(ch) + 1);
//            } else {
//                map.put(ch, 1);
//            }
//        }
//        // 遍历map，存到list中
//        list.addAll(map.entrySet());
//        // 根据字符个数进行比较
//        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                //return o1.getValue() - o2.getValue(); // 升序
//                return o2.getValue() - o1.getValue(); // 降序
//            }
//        });
//        // 遍历排序后输出
//        for (Map.Entry<Character, Integer> entry : list) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//    }


}




