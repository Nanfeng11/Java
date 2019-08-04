package com.nanfeng.reflect;


import java.lang.reflect.Field;

/**
 * Author：nanfeng
 * Created:2019/8/4
 */
class Person2 {
    public String name;
    public int age;
}

class Student extends Person2 {
    private String school;
}

public class ReflectPro {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.nanfeng.reflect.Student");
        {
            //第一组：取得类中全部属性
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        System.out.println("---------------------------");
        {
            //第二组：取得类中全部属性
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
    }
}
