package com.kuang.Thread01_Create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Orust
 * @Create 2021/3/15 17:41
 */

//这里是线程创建的总结
public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread1().start();//1.继承Thread类

        new Thread(new MyThread2()).start();//2.实现Runnable接口，无返回值

        //FutureTask是Callable的一个实现类，是Runnable的实现类RunnableFuture的实现类
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread3());//3.实现Callable接口
        new Thread(futureTask).start();
        Integer integer = futureTask.get();//可以捕获返回值
        System.out.println(integer);
    }
}

//1.继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

//2.实现Runnable接口
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

//3.实现Callable接口
class MyThread3 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 100;
    }
}