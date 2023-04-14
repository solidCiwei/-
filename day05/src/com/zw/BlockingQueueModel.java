package com.zw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> BlockingQueueModel </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/13 13:06
 */
public class BlockingQueueModel implements Model {

    private final BlockingQueue<Task> queue;

    private final AtomicInteger taskNo = new AtomicInteger(0);


    public BlockingQueueModel(int cap) {
        queue = new LinkedBlockingQueue<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProductImpl();
    }

    private class ConsumerImpl extends AbstractConsumer {

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume：" + task.no);
        }
    }

    private class ProductImpl extends AbstractProduct {

        @Override
        public void product() throws InterruptedException {
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(taskNo.getAndIncrement());
            System.out.println("produce：" + task.no);
            queue.put(task);
        }
    }

    public static void main(String[] args) {
        Model model = new BlockingQueueModel(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
}
