package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//lock锁的使用
public class LockDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 40; i++) {
            new Thread(()->{
                ticket.sale();
            }).start();
        }
    }
}
class Ticket{
    private int num = 10;
    Lock lock= new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            Thread.sleep(2);
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"获取第"+num+"张票");
                num--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
