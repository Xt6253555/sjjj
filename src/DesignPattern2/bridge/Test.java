package DesignPattern2.bridge;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Desktop(new Apple());
        computer.info();
    }
}
