package DesignPattern2.prototype;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        User a = new User(1, "a");
        User clone = (User) a.clone();
        System.out.println(a);
        System.out.println(clone);
    }
}
