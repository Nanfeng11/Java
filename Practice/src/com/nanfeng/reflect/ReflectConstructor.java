package com.nanfeng.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author：nanfeng
 * Created:2019/8/4
 */
//Class类通过反射实例化对象，必须有无参构造
//class Person {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [name=" + name + ",age=" + age + "]";
//    }
//}

//Constructor类通过反射实例化对象
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ",age=" + age + "]";
    }
}

public class ReflectConstructor {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Person.class;
        //取得指定参数类型的构造方法对象
        Constructor<?> cons = cls.getConstructor(String.class, int.class);
        System.out.println(cons.newInstance("Nanfeng", 21));
    }
}
