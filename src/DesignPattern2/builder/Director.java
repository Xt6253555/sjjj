package DesignPattern2.builder;

public class Director {
    public Product Worker(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
