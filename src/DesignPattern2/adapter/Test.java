package DesignPattern2.adapter;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.toNet(new AdaptImpl(new NetLine()));
    }
}
