package DesignPattern2.factory;

public class WulingFactory {
    public Car getCar() {
        return new Wuling();
    }
}
