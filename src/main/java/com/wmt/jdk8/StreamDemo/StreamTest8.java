package com.wmt.jdk8.StreamDemo;

import java.util.stream.IntStream;

public class StreamTest8 {
    public static void main(String[] args) {
        //一旦执行，程序将死循环
        IntStream.iterate(0,i->(i+1)% 2).distinct().limit(6).forEach(System.out::println);
        //下面这种是正确的，注意执行顺序
        IntStream.iterate(0,i->(i+1)% 2).limit(6).distinct().forEach(System.out::println);
    }
}
