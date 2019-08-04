package com.nanfeng.reflect;

/**
 * Author：nanfeng
 * Created:2019/8/3
 */
interface IFruit {

}

interface IMessage {

}

class CLS implements IFruit, IMessage {
}

public class Reflect {
    public static void main(String[] args) {
        Class<?> cls = CLS.class;   //取得class对象
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getSuperclass().getName());
        Class<?>[] iClass = cls.getInterfaces();
        for (Class<?> class1 : iClass) {
            System.out.println(class1.getName());
        }
    }
}
