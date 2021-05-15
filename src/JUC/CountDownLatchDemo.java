package JUC;

import java.util.concurrent.CountDownLatch;

//这是一个计数器  减法
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();//-1操作
            }).start();
        }
        countDownLatch.await();  //等待计数器归零  然后向下执行
        System.out.println("执行完成");

    }
}
