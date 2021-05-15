package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache_ReadWriteLock mycache = new MyCache_ReadWriteLock();
        //写入
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                mycache.put(String.valueOf(finalI),String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
        //读取
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                mycache.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
    }
}
class MyCache_ReadWriteLock{
    private volatile Map<String,String> map=new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock lock = new ReentrantLock();
    public void put(String key ,String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始写入");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }
    public String get(String key){
        readWriteLock.readLock().lock();
        String s = null;
        try {
            System.out.println(Thread.currentThread().getName()+" 线程 开始读取");
            s = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 线程 读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return s;
    }
}
