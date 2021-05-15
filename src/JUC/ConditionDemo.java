package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Condition实现线程通信
public class ConditionDemo {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                data.decrement();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                data.increment();
            }
        },"b").start();
    }
}
class Data{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition =  lock.newCondition();
    public void increment(){
        lock.lock();
        try {
            while (num!=0){
                //等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"="+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try {
            while (num==0){
                 condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"="+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
