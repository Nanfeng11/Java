package com.nanfeng.reflect;

import java.lang.reflect.Field;

/**
 * Author：nanfeng
 * Created:2019/8/4
 */
//通过反射操作属性
//class Person3 {
//    private String name;
//}
//
//public class GetReflectPro {
//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        Class<?> cls = Class.forName("com.nanfeng.reflect.Person3");
//        //实例化本类对象
//        Object obj = cls.newInstance();
//        //操作name属性
//        Field nameField = cls.getDeclaredField("name");
//        nameField.set(obj, "Nanfeng");   //等价于：对象.name = "Nanfeng"
//        System.out.println(nameField.get(obj));
//    }
//}


//动态设置封装
//class Person3 {
//    private String name;
//}
//
//public class GetReflectPro {
//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        Class<?> cls = Class.forName("com.nanfeng.reflect.Person3");
//        //实例化本类对象
//        Object obj = cls.newInstance();
//        //操作name属性
//        Field nameField = cls.getDeclaredField("name");
//        //取消封装
//        nameField.setAccessible(true);
//        //---------------
//        nameField.set(obj, "Nanfeng");   //等价于：对象.name = "Nanfeng"
//        System.out.println(nameField.get(obj));
//    }
//}


//取得属性类型
class Person3 {
    private String name;
}

public class GetReflectPro {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Class.forName("com.nanfeng.reflect.Person3");
        //实例化本类对象
        Object obj = cls.newInstance();
        //操作name属性
        Field nameField = cls.getDeclaredField("name");
        //包.类
        System.out.println(nameField.getType().getName());
        //类名称
        System.out.println(nameField.getType().getSimpleName());
    }
}
