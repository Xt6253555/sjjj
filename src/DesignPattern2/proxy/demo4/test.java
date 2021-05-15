package DesignPattern2.proxy.demo4;

import DesignPattern2.proxy.demo2.User;
import DesignPattern2.proxy.demo2.UserImpl;

public class test {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(user);
        User proxy = (User) pih.getProxy();
        proxy.add();
    }
}
