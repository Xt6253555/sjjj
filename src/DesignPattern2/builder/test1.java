package DesignPattern2.builder;

public class test1 {
    public static void main(String[] args) {
        Director director = new Director();
        Product worker = director.Worker(new Worker());
        System.out.println(worker.toString());
    }
}
