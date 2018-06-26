package com.wmt.jdk8.Defaultmethod;

public interface MyInterface2 {
    default void myMethod(){
        System.out.println("MyInterface2");
    }
}
