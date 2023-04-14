package com.zw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> WaitAndNotifyModel </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/13 13:26
 */
public class WaitAndNotifyModel implements Model{
    //定义一个对象锁
    private final Object BUFFER_LOCK = new Object();
    //缓冲区
    private final Queue<Task> buffer = new LinkedList<>();

    private int cap;

    private final AtomicInteger taskNo = new AtomicInteger(0);

    public WaitAndNotifyModel(int cap) {
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProductImpl();
    }

    private class ConsumerImpl extends AbstractConsumer{
        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK){
                while (buffer.size()==0){
                    BUFFER_LOCK.wait();
                }
                Task task = buffer.poll();
                assert task!=null;
                Thread.sleep(500+(long)(Math.random()*500));
                System.out.println("consume："+task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class ProductImpl extends AbstractProduct{
        @Override
        public void product() throws InterruptedException {
            Thread.sleep((long) Math.random()*1000);
            synchronized (BUFFER_LOCK){
                while (buffer.size() == cap){
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(taskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("product："+task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Model model = new WaitAndNotifyModel(3);

        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableProducer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
}
