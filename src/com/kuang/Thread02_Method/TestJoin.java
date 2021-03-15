package com.kuang.Thread02_Method;

/**
 * @Author Orust
 * @Create 2021/3/15 16:04
 */

//测试join方法，插队
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动我们的主线程
        TestJoin TestJoin = new TestJoin();
        Thread thread = new Thread(TestJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();//插队
            }
            System.out.println("main" + i);
        }
    }
}