package com.nanfeng;

import java.io.*;

/**
 * Author：nanfeng
 * Created:2019/8/2
 */
class CopyFileUtil {
    private CopyFileUtil() {
    }

    //判断要拷贝的源路径是否存在
    public static boolean fileIsExists(String path) {
        return new File(path).exists();
    }

    //根据传入的路径判断父路径是否存在
    public static void createParentDir(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    //文件拷贝
    public static boolean copyFile(String sourcePath, String destPath) {
        File inFile = new File(sourcePath);
        File outFile = new File(destPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(inFile);
            fileOutputStream = new FileOutputStream(outFile);
            //完成具体文件拷贝
            copyFileHandle(fileInputStream, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //文件拷贝
    private static void copyFileHandle(InputStream inputStream, OutputStream outputStream) throws IOException {
        long start = System.currentTimeMillis();
//        int temp = 0;
//        while ((temp = inputStream.read()) != -1) {
//            outputStream.write(temp);
//        }
        byte[] data = new byte[1024];   //开辟缓冲区一次性读入多个内容
        int len = 0;
        //len=inputStream.read(data)!=-1表示将数据读取到字节数组中，然后返回读取个数
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);     //将字节数组的部分内容写到目标文件
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝文件所花费的时间：" + (end - start));
    }
}

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("非法操作，命令为：java CopyFile 源文件路径 目标文件路径");
            return;
        }
        String soucePath = args[0]; //取得源文件路径
        String destPath = args[1];  //取得目标路径
        if (CopyFileUtil.fileIsExists(soucePath)) {
            CopyFileUtil.createParentDir(soucePath);    //创建目录
            System.out.println(CopyFileUtil.copyFile(soucePath, destPath) ? "文件拷贝成功" : "文件拷贝失败");
        } else {
            System.out.println("源文件不存在，无法进行拷贝");
        }
    }
}
