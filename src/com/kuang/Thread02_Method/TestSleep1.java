package com.kuang.Thread02_Method;

/**
 * @Author Orust
 * @Create 2021/3/15 15:51
 */

//模拟网络延时，放大问题的发生性
public class TestSleep1 implements Runnable {
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 1) {
                break;
            }
            try {
                //模拟延时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //拿到线程名字
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestSleep1 ticket = new TestSleep1();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();
    }
}

