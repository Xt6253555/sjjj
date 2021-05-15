package DesignPattern2.builder;

public abstract class Builder {
    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();
    abstract Product getProduct();
}
