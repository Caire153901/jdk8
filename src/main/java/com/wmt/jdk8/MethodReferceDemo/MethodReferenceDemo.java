package com.wmt.jdk8.MethodReferceDemo;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("hello","world","hello word");
        list.forEach(item-> System.out.println(item));
        list.forEach(System.out::println);//此处为方法引用
    }
}
