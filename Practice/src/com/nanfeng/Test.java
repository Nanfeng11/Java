package com.nanfeng;

import java.util.*;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */

class Person2 implements Comparable<Person2> {
    private Integer age;
    private String name;

    public Person2(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person2 o) {
        if (this.age < o.age)
            return 1;
        else if (this.age > o.age)
            return -1;
        return 0;
    }
}

//年龄升序比较器
class AgeSec implements Comparator<Person2> {

    @Override
    public int compare(Person2 o1, Person2 o2) {
        if (o1.getAge() < o2.getAge())
            return -1;
        else if (o1.getAge() > o2.getAge())
            return 1;
        else
            return 0;
    }
}

//年龄降序比较器
class AgeDesc implements Comparator<Person2> {
    @Override
    public int compare(Person2 o1, Person2 o2) {
        if (o1.getAge() < o2.getAge())
            return 1;
        else if (o1.getAge() > o2.getAge())
            return -1;
        else
            return 0;
    }
}

public class Test {
    public static void main(String[] args) {
        AgeSec ageSec = new AgeSec();
        Set<Person2> set = new TreeSet<>(ageSec);
        Person2 per1 = new Person2(20, "张三");
        Person2 per2 = new Person2(21, "张三");
        set.add(per1);
        set.add(per2);
        System.out.println(set);
    }
}

//class Person2 {
//    private Integer age;
//    private String name;
//
//    public Person2(Integer age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        else if (!(obj instanceof Person2))
//            return false;
//        //此时obj确实是Person的对象且与当前对象不是一个地址
//        Person2 per = (Person2) obj;
//        return this.name.equals(per.name) && this.age.equals(per.age);
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        Person2 per1 = new Person2(20, "张三");
//        Person2 per2 = new Person2(20, "张三");
//        System.out.println(per1.equals(per2));
//
//    }
//}

//public class Test {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        //modCount=1
//        list.add("hello");
//        list.add("bit");
//        list.add("hello");
//        //modCount=4
//        list.add("Java");iterator
//        //expectedModCount = modCount = 4
//        Iterator<String> iterator = list.();
//        while (iterator.hasNext()) {
//            String str = iterator.next();
//            if (str.equals("bit")) {
//                //modCount = 5
//                //调用next方法迭代便伦理的时候，会首先进行判断，modCount != expectedModCount说明集合已经被修改，抛出并发修改异常
//                list.remove(str);
//            }
//            System.out.println(str);
//        }
//    }
//}
