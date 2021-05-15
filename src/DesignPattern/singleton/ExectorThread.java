package DesignPattern.singleton;

public class ExectorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        //HungrySingleton singleton1 = HungrySingleton.getInstance();
        //EnumSingleton singleton2 = EnumSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
        //System.out.println(Thread.currentThread().getName() + ":" + singleton1);
        //System.out.println(Thread.currentThread().getName() + ":" + singleton2);
    }
}
