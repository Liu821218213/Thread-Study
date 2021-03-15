package com.kuang.Thread01_Create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//练习，多线程同步下载图片

// 方式1：继承Thread类
//public class TestThread2 extends Thread {

// 方式2：实现Runnable接口
class TestThread2 implements Runnable {
    private String url;//图片下载的地址
    private String name;//保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片的执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载了图片名为" + name);
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\82121\\IdeaProjects\\Thread-Study\\src\\com\\kuang\\Thread01_Create\\";
        TestThread2 t1 = new TestThread2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", path + "1.jpg");
        TestThread2 t2 = new TestThread2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", path + "2.jpg");
        TestThread2 t3 = new TestThread2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", path + "3.jpg");
// 方式1：继承Thread类
//        t1.start();
//        t2.start();
//        t3.start();

        // 方式2：实现Runnable接口
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

//下载器
class WebDownLoader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            //url变成文件
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}