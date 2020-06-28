/*
 * @Description: Queue + Thread
 * @author: johnw;
 * @Created: 6/28/2020;
 */

import java.util.LinkedList;
import java.util.Queue;


public class QueueThread {
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        Q.offer(2);
        Q.offer(3);

        for(int i : Q){
            Thread t = new Thread(new MyRunable2(i));
            t.start();
        }

    }
}
class MyRunable2 implements Runnable{
    private int i;
    public MyRunable2(int i){
        this.i = i;
    }

    @Override
    public void run() {
        int j = this.i + 1;
        System.out.println(Thread.currentThread() + "得出结果为： "+ j+ "\n");

        try{
            System.out.println("暂停中....");
            Thread.sleep(10000);
        }catch (Exception e){

        }
        System.out.println("结束了");
    }
}