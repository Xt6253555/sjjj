package DesignPattern.singleton;

public class LazyInnerClassSingleton {
    //默认使用 LazyInnerClassGeneral 的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private LazyInnerClassSingleton(){
        //防止反射调用破坏单例
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    //每一个关键字都不是多余的
    // static 是为了使单例的空间共享
    // 保证这个方法不会被重写
    public static final LazyInnerClassSingleton getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }
    //默认不加载
    //内部类一定是要在方法(getInstance())调用之前初始化
    //static final 是一个静态常量,存储在内存中的常量区,
    //在new之前会看常量里面是否有这个值,如果有,就不再执行new操作了
    private static class LazyHolder{
        //饿汉式创建对象
        private static final LazyInnerClassSingleton LAZY =
                new LazyInnerClassSingleton();
    }
}
