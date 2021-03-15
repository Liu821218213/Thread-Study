package com.kuang.Thread01_Create;


// 方式1：继承Thread类
//public class TestThread2 extends Thread {
public class TestThread1 extends Thread {

    // 线程入口点
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // main线程，主线程

        // 创建一个线程对象
        TestThread1 testThread01 = new TestThread1();
        // 调用start()方法开启线程
        testThread01.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}