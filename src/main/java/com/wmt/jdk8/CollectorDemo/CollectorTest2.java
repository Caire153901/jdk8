package com.wmt.jdk8.CollectorDemo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class CollectorTest2<T> implements Collector<T,Set<T>,Set<T>>{
    //用于提供一个空的容器
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet<T>::new;//要被Collector调用的空的容器
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return Set<T>::add;
    }
    //将并行流合并
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1,set2)->{
            set1.addAll(set2);
            return set1;
        };
    }
     //结果容器
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked!");
        //return t ->t;
        throw new UnsupportedOperationException();
    }
    //返回一个不可变的结果集合
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list =Arrays.asList("hello","world","hello world");
        Set<String> set =list.stream().collect(new CollectorTest2<>());
        System.out.println(set);
        //调用不一定执行了，其中finisher没有被调用
        //因为finisher的结果类型和中间类型一直，所以没有被调用
        /*supplier invoked!
         accumulator invoked!
         combiner invoked!
         characteristics invoked!
         characteristics invoked!
         [world, hello, hello world]*/
    }
}
