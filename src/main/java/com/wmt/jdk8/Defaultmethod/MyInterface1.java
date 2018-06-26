package com.wmt.jdk8.Defaultmethod;

public interface MyInterface1 {
    default void myMethod(){
        System.out.println("MyInterface1");
    }
}
