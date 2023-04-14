package com.zw;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * <p> ThreadLocalExample </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/13 14:00
 */
public class ThreadLocalExample implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> local =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(example,""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name="+Thread.currentThread().getName()+"default Formatter ="+local.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        local.set(new SimpleDateFormat());
        System.out.println("Thread Name="+Thread.currentThread().getName()+"default Formatter ="+local.get().toPattern());
    }
}
