package com.zw;

/**
 * <p> Model </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/13 11:12
 */
public interface Model {

    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
