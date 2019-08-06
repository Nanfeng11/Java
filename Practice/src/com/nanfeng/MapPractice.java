package com.nanfeng;

import java.util.*;

/**
 * Author：nanfeng
 * Created:2019/8/6
 */
////Map基本操作
//public class MapPractice {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "Hello");
//        map.put(1, "hello");
//        map.put(3, "Java");
//        map.put(2, "Nanfeng");
//        System.out.println(map);
//        //根据key取得value
//        System.out.println(map.get(2));
//        //查找不到返回null
//        System.out.println(map.get(99));
//    }
//}

//取得Map中所有key信息
//public class MapPractice {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "Hello");
//        map.put(1, "hello");
//        map.put(3, "Java");
//        map.put(2, "Nanfeng");
//        Set<Integer> set = map.keySet();
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//    }
//}

//观察Hashtable
//public class MapPractice {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new Hashtable<>();
//        map.put(1, "Hello");
//        map.put(1, "hello");
//        map.put(3, "Java");
//        map.put(2, "Nanfeng");
//        System.out.println(map);
//    }
//}

//观察TreeMap
//public class MapPractice {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new TreeMap<>();
//        map.put(2, "C");
//        map.put(0, "A");
//        map.put(1, "B");
//        System.out.println(map);
//    }
//}

//通过Iterator输出Map集合
//public class MapPractice {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "Hello");
//        map.put(3, "Java");
//        map.put(2, "Nanfeng");
//        //1.将Map集合转为Set集合
//        Set<Map.Entry<Integer, String>> set = map.entrySet();
//        //2.获取Iterator对象
//        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
//        //3.输出
//        while (iterator.hasNext()) {
//            //4.取出每一个Map.Entry对象
//            Map.Entry<Integer, String> entry = iterator.next();
//            //5.取得key和value
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//    }
//}

//自定义类作为key，系统类作为value
class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ",name='" + name + "\'" + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return Objects.equals(age, person.age) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}

public class MapPractice {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person(15, "张三"), "zs");
        System.out.println(map.get(new Person(15, "张三")));
    }
}