package DesignPattern2.proxy.demo2;

public class UserImpl implements User{
    @Override
    public void add() {
        System.out.println("增加");
    }

    @Override
    public void detele() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void select() {
        System.out.println("查询");
    }
}
