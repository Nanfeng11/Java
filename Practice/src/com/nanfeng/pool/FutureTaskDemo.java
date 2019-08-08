package com.nanfeng.pool;


import java.util.concurrent.*;

/**
 * Author：nanfeng
 * Created:2019/8/7
 */
class CallableDemo implements Callable<String> {
    private int ticket = 20;


    @Override
    public String call() throws Exception {
        for (int i = 0; i < 20; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "还剩下" + ticket-- + "票");
            }
        }
        return "票已卖完，下次见";
    }
}

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new CallableDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> submit = null;
        for (int i = 0; i < 3; i++) {
            submit = executorService.submit(callable);
            //System.out.println(submit.get());     ---位置1
        }
        System.out.println(submit.get());   //  ---位置2
        executorService.shutdown();
    }
}