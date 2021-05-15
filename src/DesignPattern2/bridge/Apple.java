package DesignPattern2.bridge;

public class Apple implements Brand{
    @Override
    public void info() {
        System.out.println("苹果");
    }
}
