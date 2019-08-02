package com.nanfeng;

import java.io.*;
import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/8/2
 */
public class ShuRuLiu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("E:\\比特\\JavaSE\\code\\test.txt")));
        scanner.useDelimiter("\n");     //自定义分隔符
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
