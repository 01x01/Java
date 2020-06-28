/*
 * @Description: Java 线程
 * @author: johnw;
 * @Created: 6/28/2020;
 */

public class ThreadTest {
    public static void main(String[] args) {
        // 第一种方式 使用继承，来实现多线程
        System.out.println("Main Thread started!");

        for(int i=0;i<5;i++){
            Thread t = new MyThread();
            t.start();
        }

        System.out.println("Main Thread end");

        // 第二种方式，使用参数的形式
        Thread t1 = new Thread(new MyRunable());
        t1.start();
    }
}

class MyThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread() + "start");
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "end\n");

    }
}

class MyRunable implements Runnable {
    public void run(){
        System.out.println("第二种形式的多线程"+Thread.currentThread() + "start");
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("第二种形式的多线程"+Thread.currentThread() + "end");
    }
}