package DesignPattern2.abstractFactory;

public class XiaomiFactory implements ProductFactory{

    @Override
    public PhoneProduct PHONE_PRODUCT() {
        return new XiaomiPhone();
    }

    @Override
    public RouterProduct ROUTER_PRODUCT() {
        return new XiaomiRouter();
    }
}
