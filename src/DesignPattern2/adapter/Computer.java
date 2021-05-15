package DesignPattern2.adapter;

public class Computer {
    //连接适配器
    public void toNet(Adapter adapter){
        adapter.connectNetLine();
    }
}
