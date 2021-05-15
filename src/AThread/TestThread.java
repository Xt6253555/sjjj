package AThread;

public class TestThread extends Thread{
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("多线程"+i);
        }
    }
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("主线程"+i);
        }
    }
}
