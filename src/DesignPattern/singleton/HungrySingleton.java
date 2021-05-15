package DesignPattern.singleton;
//饿汉式单例
public class HungrySingleton {
    private HungrySingleton(){};
    private static final HungrySingleton hungrySingleton =
            new HungrySingleton();
    public static HungrySingleton  getInstance(){
        return hungrySingleton;
    }
}
