package com.kuang.Thread02_Method;

/**
 * @Author Orust
 * @Create 2021/3/15 15:44
 */
public class TestStop implements Runnable {
    //设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run....." + i++);
        }
    }

    //设置一个方法停止线程，转换标识位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop stopTest = new TestStop();
        new Thread(stopTest).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                //调用stop方法，停止线程
                stopTest.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}