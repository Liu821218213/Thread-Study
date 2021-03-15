package com.kuang.Thread01_Create;

//创建线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入Runnable接口实现类，调用start方法
public class TestThread3 implements Runnable {
    // 线程入口点
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        TestThread3 threadTest3 = new TestThread3();
        //创建线程对象，通过线程对象开启我们的线程代理
        new Thread(threadTest3).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}
