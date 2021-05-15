package DesignPattern2.factory;

public class Test {
    public static void main(String[] args) {
        Car car = new WulingFactory().getCar();
        car.name();
    }
}
