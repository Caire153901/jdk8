package com.wmt.jdk8.FunctionInterfaceDemo;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);

        long a=System.currentTimeMillis();
        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i));
        }
        long b=System.currentTimeMillis();
        System.out.println(b-a);
        System.out.println("----------------------");

        long c =System.currentTimeMillis();
        for(Integer i:list){
            System.out.println(i);
        }
        long d=System.currentTimeMillis();
        System.out.println(d-c);
        System.out.println("----------------------");

       long e=System.currentTimeMillis();
        list.forEach(System.out::println);
        long f=System.currentTimeMillis();
        System.out.println(f-e);
        System.out.println("----------------------");
        long g=System.currentTimeMillis();
        list.stream().forEach(System.out::println);
        long h=System.currentTimeMillis();
        System.out.println(h-g);
        System.out.println("----------------------");
        long m=System.currentTimeMillis();
        list.parallelStream().forEach(System.out::println);
        long n=System.currentTimeMillis();
        System.out.println(n-m);
        System.out.println("----------------------");
        long o=System.currentTimeMillis();
        list.parallelStream().map(integer ->integer.toString()).forEach(System.out::println);
        long p=System.currentTimeMillis();
        System.out.println(p-o);

    }
}
