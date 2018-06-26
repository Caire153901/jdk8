package com.wmt.jdk8.CollectorDemo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 *  输入Set<String>,输出Map<String,String>
 * @param <T>
 */
public class MyCollector<T> implements Collector<T,Set<T>,Map<T,T>>{

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (set,item)-> set.add(item);
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1,set2)->{
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return set->{
            Map<T,T> map =new HashMap<>();
            set.stream().forEach(item->map.put(item,item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        //UNORDERED无序
        //若添加 CONCURRENT或IDENTITY_FINISH 会抛出类型转换异常
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
         List<String> list =Arrays.asList("hello","world","welcome","a","b","c");
         Set<String > set =new HashSet<>();
         set.addAll(list);
         //串行流
        // Map<String,String> map =set.stream().collect(new MyCollector<>());
        //并行流
         Map<String,String> map =set.parallelStream().collect(new MyCollector<>());
        System.out.println(map);
        //因为结果数据类型和中间数据类型不一样，所以finisher被调用
        /* supplier invoked!
           accumulator invoked!
           combiner invoked!
           characteristics invoked!
           characteristics invoked!
           finisher invoked!
           {a=a, b=b, world=world, c=c, hello=hello, welcome=welcome}*/

    }
}
