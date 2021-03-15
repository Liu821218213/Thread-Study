package com.kuang.Thread03_State;

//守护线程
public class TestDaeman {
    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();

        Thread thread = new Thread(god);
        //默认是false表示用户线程，正常线程都是用户线程
        thread.setDaemon(true);
        //神护线程启动
        thread.start();
        //用户线程启动
        new Thread(person).start();
    }
}

//God
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("God");
        }
    }
}

//Person
class Person implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("人开心地活着" + i);
        }
        System.out.println("====Goodbye,World!-_-");
    }
}