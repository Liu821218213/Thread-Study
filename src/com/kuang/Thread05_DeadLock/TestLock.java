package com.kuang.Thread05_DeadLock;

import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock可重入锁，JDK5.0以后

/*测试lock锁*/
public class TestLock {
    public static void main(String[] args) {
        LockTest2 lockTest2 = new LockTest2();
        new Thread(lockTest2).start();
        new Thread(lockTest2).start();
        new Thread(lockTest2).start();
    }
}

class LockTest2 implements Runnable {

    int ticketNums = 10;
    //定义lock锁
    //private是让锁私有化，安全，final是让其成为一个常量
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //加锁
                lock.lock();
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }
}