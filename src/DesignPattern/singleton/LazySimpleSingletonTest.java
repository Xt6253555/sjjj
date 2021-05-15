package DesignPattern.singleton;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(new ExectorThread());
            Thread t2 = new Thread(new ExectorThread());
            t1.start();
            t2.start();
        }
        System.out.println("End");
    }
}
