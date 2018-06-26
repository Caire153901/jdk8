package com.wmt.jdk8.StreamDemo;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {
    public static void main(String[] args) {
        //获取集合中长度为5的元素，并输出第一个
        List<String> list = Arrays.asList("hello","world","hello world");
        list.stream().mapToInt(item->item.length()).filter(l->l==5).findFirst().ifPresent(System.out::println);//输出了长度5
        System.out.println("-----------------------------");
        list.stream().filter(item->item.length()==5).findFirst().ifPresent(System.out::println);//输出了元素
        System.out.println("++++++++++++++++++++++++++++");
        list.stream().mapToInt(item->{
            int length =item.length();
            System.out.println(item);//输出了元素
            return length;
        }).filter(l->l==5).findFirst().ifPresent(System.out::println);//输出了长度5
    }
}
