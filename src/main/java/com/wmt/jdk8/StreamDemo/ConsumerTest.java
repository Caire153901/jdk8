package com.wmt.jdk8.StreamDemo;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {
    public void test(Consumer<Integer> consumer){
        consumer.accept(100);
    }
    public static void main(String[] args) {
        ConsumerTest consumerTest=new ConsumerTest();
        Consumer<Integer> consumer=i-> System.out.println(i);
        IntConsumer intConsumer =i -> System.out.println(i);
        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        consumerTest.test(consumer);//面向对象方式
        //编译不通过，会报错
        //consumerTest.test(intConsumer);
        //编译通过，但运行报错
       // consumerTest.test((Consumer)intConsumer);
        //函数式方式，下面两种可以
        consumerTest.test(consumer::accept);
        consumerTest.test(((Consumer) intConsumer)::accept);

    }
}
