package DesignPattern2.singleton;

import java.util.FormatFlagsConversionMismatchException;

//饿汉式单例
public class Hungry {
    //私有化构造方法
    private Hungry(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                getInstance();
            }).start();
        }

    }
}
