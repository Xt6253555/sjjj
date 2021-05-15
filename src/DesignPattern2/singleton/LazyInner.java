package DesignPattern2.singleton;
//静态内部类
public class LazyInner {
    private LazyInner(){}
    public static final LazyInner getInstance(){
        return LazyHolder.LAZY_INNER;
    }
    public static class LazyHolder{
        //饿汉式创建对象
        private static final LazyInner LAZY_INNER = new LazyInner();
    }

}
