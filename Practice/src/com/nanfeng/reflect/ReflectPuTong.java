package com.nanfeng.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author：nanfeng
 * Created:2019/8/4
 */
//class Person1 {
//    private String name;
//    private int age;
//
//    public Person1() {
//    }
//
//    public Person1(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [name=" + name + ",age=" + age + "]";
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}

//通过反射调用setter、getter方法
class Person1 {
    private String name;
    private int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ",age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ReflectPuTong {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.拿到PersonClass对象
        Class<?> cls = Person1.class;
        //2.创建Person实例化对象
        Person1 per = (Person1) cls.newInstance();
        //3.拿到setName的Method对象
        Method setMethod = cls.getMethod("setName", String.class);
        //4.通过invoke进行调用
        setMethod.invoke(per, "Nanfeng");
        System.out.println(per);
    }
}
