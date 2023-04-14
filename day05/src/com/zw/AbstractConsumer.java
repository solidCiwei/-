package com.zw;

/**
 * <p> AbstractConsumer </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/13 11:12
 */
public abstract class AbstractConsumer implements Runnable, Consumer {

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
