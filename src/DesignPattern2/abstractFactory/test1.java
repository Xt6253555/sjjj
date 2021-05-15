package DesignPattern2.abstractFactory;

public class test1 {
    public static void main(String[] args) {
        PhoneProduct phoneProduct = new XiaomiFactory().PHONE_PRODUCT();
        RouterProduct routerProduct = new XiaomiFactory().ROUTER_PRODUCT();
        phoneProduct.Start();
        phoneProduct.End();
        routerProduct.Start();
        routerProduct.End();
    }
}
