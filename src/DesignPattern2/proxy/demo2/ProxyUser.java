package DesignPattern2.proxy.demo2;

public class ProxyUser implements User{
    private UserImpl user;

    public void setUser(UserImpl user) {
        this.user = user;
    }

    @Override
    public void add() {
        log();
        user.add();
    }

    @Override
    public void detele() {

    }

    @Override
    public void update() {

    }

    @Override
    public void select() {

    }

    public void log(){
        System.out.println("日志");
    }
}
