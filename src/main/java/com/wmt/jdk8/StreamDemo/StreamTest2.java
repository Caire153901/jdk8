package com.wmt.jdk8.StreamDemo;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.stream.IntStream;

//流所能带来的简化
public class StreamTest2 {
    public static void main(String[] args) {
        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++");

        //构建了一个3到7的int集合
        IntStream.range(3,8).forEach(System.out::println);
        //3-8的int集合
        IntStream.rangeClosed(3,8).forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
    }
}
