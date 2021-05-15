package DesignPattern.singleton;
//懒汉式单例
public class LazySimpleSingleton {
    //私有构造方法
    private LazySimpleSingleton(){}
    //静态块，公共内存区域
    private static LazySimpleSingleton lazy = null;
    //双重锁(if(lazy == null))来解决多线程
    public static LazySimpleSingleton getInstance(){
        if(lazy == null) {
            synchronized (LazySimpleSingleton.class) {
                if(lazy == null) {
                    lazy = new LazySimpleSingleton();
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args) {
        LazySimpleSingleton a = new LazySimpleSingleton().getInstance();
        LazySimpleSingleton b = new LazySimpleSingleton().getInstance();
        System.out.println(a.equals(b));
    }
}
