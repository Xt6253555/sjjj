package DesignPattern2.proxy.demo3;

public class Host implements Rent{
    @Override
    public void Rent() {
        System.out.println("出租房子");
    }
}
