package com.zw;

/**
 * <p> AbstractProduct </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/13 11:12
 */
public abstract class AbstractProduct implements Runnable,Product{

    @Override
    public void run() {
        while (true){
            try {
                product();
            }catch (Exception e){
                e.printStackTrace();
                break;
            }
        }

    }
}
