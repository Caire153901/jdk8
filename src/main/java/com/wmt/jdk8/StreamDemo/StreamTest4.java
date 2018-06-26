package com.wmt.jdk8.StreamDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream =Stream.of("hello","world","hello world","hello");
       //将流转为数组形式
        String[] stringArray = stream.toArray(length->new String[length]);
        //与上相同
        String[] strings =stream.toArray(String[]::new);
        //将数组转为集合形式并逐一输出
        Arrays.asList(stringArray).forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        Stream<String> streams =Stream.of("hello","world","hello world");
        List<String> list = streams.collect(Collectors.toList());
        list.forEach(System.out::println);
        List<String> list1 = streams.collect(()-> new ArrayList<>(),(theList,item)->theList.add(item)
                , (theList1,theList2)->theList1.addAll(theList2));
        list1.forEach(System.out::println);
        //上下作用一样
        List<String> list2 =streams.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        list2.forEach(System.out::println);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        //拼接字符
        String a = streams.collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString();
        System.out.println(a);
        //与上面一样
        String str =streams.collect(Collectors.joining()).toString();
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        //转arraylist
        List<String> list3 =stream.collect(Collectors.toCollection(ArrayList::new));
        list3.forEach(System.out::println);
        //转set
        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        set.forEach(System.out::println);





    }
}
