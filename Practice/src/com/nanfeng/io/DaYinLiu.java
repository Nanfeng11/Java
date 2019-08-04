package com.nanfeng.io;

import java.io.*;

/**
 * Author：nanfeng
 * Created:2019/8/2
 */
class Printutil {
    private OutputStream out;

    //由外部传入要输出的目标终端
    public Printutil(OutputStream out) {
        this.out = out;
    }

    //核心功能就一个
    public void print(String str) {
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str) {
        this.print(str + "\n");
    }

    public void print(int data) {
        this.print(String.valueOf(data));
    }

    public void println(int data) {
        this.println(String.valueOf(data));
    }

    public void print(double data) {
        this.print(String.valueOf(data));
    }

    public void println(double data) {
        this.println(String.valueOf(data));
    }
}

//public class DaYinLiu {
//    public static void main(String[] args) throws FileNotFoundException {
//        Printutil printutil = new Printutil(new FileOutputStream(new File("E:\\比特\\JavaSE\\code\\test.txt")));
//        printutil.print("姓名：");
//        printutil.println("Nanfeng");
//        printutil.print("年龄：");
//        printutil.println(21);
//        printutil.print("工资：");
//        printutil.println(10.000000000000000001);
//    }
//}

public class DaYinLiu {
    public static void main(String[] args) throws FileNotFoundException {
        String name = "Nanfeng";
        int age = 21;
        double salary = 1.1063726327;
        String str = String.format("姓名：%s,年龄：%d,工资：%1.2f", name, age, salary);
        System.out.println(str);
    }
}
