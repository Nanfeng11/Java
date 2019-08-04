package com.nanfeng.io;

import java.io.*;

/**
 * Author：nanfeng
 * Created:2019/8/2
 */
class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name = " + name + ", age = " + age + "]";
    }
}

public class XuLieHua {
    public static final File FILE = new File("E:\\比特\\JavaSE\\code\\testSer.txt");

    public static void main(String[] args) throws IOException {
        ser(new Person("Nanfeng", 21));
    }

    public static void ser(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
        oos.writeObject(obj);
        oos.close();
    }
}
