package DesignPattern2.bridge;

public abstract class Computer {
    private Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }
    //连接品牌
    public void info(){
        brand.info();
    }
}
class Desktop extends Computer{
    public Desktop(Brand brand) {
        super(brand);
    }
    //重写连接品牌和类型
    public void info(){
        super.info();
        System.out.println("台式机");
    }
}
class Laptop extends Computer{
    public Laptop(Brand brand) {
        super(brand);
    }
    public void info(){
        super.info();
        System.out.println("笔记本");
    }
}
