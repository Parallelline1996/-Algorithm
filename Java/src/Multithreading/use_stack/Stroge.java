package Multithreading.use_stack;

import java.util.LinkedList;

public class Stroge {

    // 用于存放生产出来的产品
    private LinkedList<String> list;
    // 记录最大的容量
    private int maxSize;

    public Stroge(LinkedList<String> list, int maxSize) {
        this.list = list;
        this.maxSize = maxSize;
    }

    // 生产函数
    public void produce() {
        try {
            synchronized (list) {
                // 生产者可能被其他生产者唤醒，唤醒之后判断数目，如果无需生产，继续 wait()
                while (list.size() == maxSize) {
                    list.wait();
                }
                // 生产一个产品
                list.add(System.currentTimeMillis() + "");
                System.out.println(Thread.currentThread().getName() + " 生产一个产品，当前总数： " + this.list.size());
                // 唤醒其他的线程
                list.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 消费产品
    public String consume() {
        try {
            synchronized (list) {
                // 消费者可能被其他消费者唤醒，唤醒之后判断数目，没有可消费的，继续 wait()
                while (list.size() == 0) {
                    list.wait();
                }
                // 取走一个产品
                String consume = list.remove();
                System.out.println(Thread.currentThread().getName() + " 消费一个产品，当前总数： " + this.list.size());
                // 唤醒其他的线程
                list.notifyAll();
                return consume;
            }
        } catch (InterruptedException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Stroge stroge = new Stroge(linkedList, 10);
        // 下面创建两个消费者跟两个生产者
        Consumer consumer1 = new Consumer(stroge);
        Consumer consumer2 = new Consumer(stroge);
        Producer producer1 = new Producer(stroge);
        Producer producer2 = new Producer(stroge);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        Thread produceThread1 = new Thread(producer1);
        Thread produceThread2 = new Thread(producer2);
        consumerThread1.setName("消费者1");
        consumerThread2.setName("消费者2");
        produceThread1.setName("生产者1");
        produceThread2.setName("生产者2");
        consumerThread1.start();
        consumerThread2.start();
        produceThread1.start();
        produceThread2.start();
    }
}

class Producer implements Runnable {

    private Stroge stroge;

    public Producer(Stroge stroge) {
        this.stroge = stroge;
    }

    public void run() {
        while (true) {
            stroge.produce();
        }
    }

}

class Consumer implements Runnable {
    private Stroge stroge;

    public Consumer(Stroge stroge) {
        this.stroge = stroge;
    }

    public void run() {
        while (true) {
            stroge.consume();
        }
    }

}
