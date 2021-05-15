package DesignPattern2.adapter;
//实现适配器去连接网线
public class AdaptImpl implements Adapter{
    private NetLine netLine;

    public AdaptImpl(NetLine netLine) {
        this.netLine = netLine;
    }

    @Override
    public void connectNetLine() {
        this.netLine.linkNet();
    }
}
