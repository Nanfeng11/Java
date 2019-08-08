package com.nanfeng.pool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread girlThread = new Thread(() -> {
            try {
                String str = exchanger.exchange("我喜欢你...");
                System.out.println("女生说:" + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread boyThread = new Thread(() -> {
            System.out.println("女神缓缓映入眼帘...");
            try {
                TimeUnit.SECONDS.sleep(1);
                String str = exchanger.exchange("跟我好吧!");
                System.out.println("男生说:" + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        girlThread.start();
        boyThread.start();
    }
}
