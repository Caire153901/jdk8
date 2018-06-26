package com.wmt.jdk8.Defaultmethod;
//MyInterface1Impl 的优先级高于 MyInterface1
public class MyClass1 extends MyInterface1Impl implements MyInterface1{
/*    *//**
     * 重写方法
     *//*
    @Override
    public void myMethod(){
        //注明使用的是哪一个类中的方法
        MyInterface2.super.myMethod();
        System.out.println("MyClass");
    }*/

    public static void main(String[] args) {
        MyClass1 myClass1=new MyClass1();
        myClass1.myMethod();
    }
}
