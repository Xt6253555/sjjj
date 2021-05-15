package DesignPattern2.abstractFactory;

public class XiaomiRouter implements RouterProduct {
    @Override
    public void Start() {
        System.out.println("路由器开始");
    }

    @Override
    public void End() {
        System.out.println("路由器结束");
    }
}
