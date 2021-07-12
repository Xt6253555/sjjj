package DesignPattern2.proxy.demo2;

public class test {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        ProxyUser proxyUser = new ProxyUser();
        proxyUser.setUser(user);
        proxyUser.add();
    }
}
