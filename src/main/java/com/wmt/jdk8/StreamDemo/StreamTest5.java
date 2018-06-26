package com.wmt.jdk8.StreamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world","test");
        //全部大写输出
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("----------------------------------------------");
        List<Integer> list1 =Arrays.asList(1,2,3,4,5);
        //全部求平方
        list1.stream().map(item->item * item).forEach(System.out::println);
        System.out.println("----------------------------------------------");
         //flatMap
        Stream<List<Integer>> listStream =Stream.of(Arrays.asList(1),
                Arrays.asList(2,3),Arrays.asList(4,5,6));
        //每一个数都平方
        listStream.flatMap(theList->theList.stream()).map(item ->item *item).forEach(System.out::println);


    }
}
