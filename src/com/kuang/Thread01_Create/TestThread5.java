package com.kuang.Thread01_Create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Author Orust
 * @Create 2021/3/15 14:31
 */

//线程创建方式三：实现Callable接口
//有点：1.可以定义返回值 2.可以抛出异常
class ThreadTest5 implements Callable<Boolean> {

    private String url;//图片下载的地址
    private String name;//保存的文件名

    public ThreadTest5(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片的执行体
    @Override
    public Boolean call() {
        WebDownLoader2 webDownLoader2 = new WebDownLoader2();
        WebDownLoader2.downloader(url, name);
        System.out.println("下载了图片名为" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String path = "C:\\Users\\82121\\IdeaProjects\\Thread-Study\\src\\com\\kuang\\Thread01_Create\\";
        ThreadTest5 t1 = new ThreadTest5("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", path + "1.jpg");
        ThreadTest5 t2 = new ThreadTest5("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", path + "2.jpg");
        ThreadTest5 t3 = new ThreadTest5("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", path + "3.jpg");
        //创建执行服务：线程池
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行，后运行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取运行结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();
    }
}

//下载器
class WebDownLoader2 {
    //下载方法
    public static void downloader(String url, String name) {
        try {
            //url变成文件
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}