package DesignPattern2.abstractFactory;

public class XiaomiPhone implements PhoneProduct {
    @Override
    public void Start() {
        System.out.println("手机开始");
    }

    @Override
    public void End() {
        System.out.println("手机结束");
    }
}
