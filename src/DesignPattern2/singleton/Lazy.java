package DesignPattern2.singleton;

//懒汉式
public class Lazy {
    private Lazy(){
        System.out.println(Thread.currentThread().getName());
    }

    private volatile static Lazy lazy;

    public static Lazy getInstance(){
        if(lazy==null){
            synchronized (Lazy.class){
                if(lazy==null) {
                    lazy = new Lazy();
                }
            }
        }
        return  lazy;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                getInstance();
            }).start();
        }
    }
}
