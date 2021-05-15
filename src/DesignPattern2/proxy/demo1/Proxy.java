package DesignPattern2.proxy.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        seaHouse();
    }
    public void seaHouse(){
        System.out.println("看房");
    }
}
