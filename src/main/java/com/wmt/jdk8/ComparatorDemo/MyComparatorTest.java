package com.wmt.jdk8.ComparatorDemo;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparatorTest {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("nihao","hello","world","welcome");
        //按字母升序排序
        Collections.sort(list);
        //按字符长度升序排
       // Collections.sort(list,(item1,item2)->item1.length()-item2.length());
        Collections.sort(list, Comparator.comparingInt(String::length));
        //按字符长度降序
        //Collections.sort(list,(item1,item2)->item2.length()-item1.length());
        Collections.sort(list,Comparator.comparingInt(String::length).reversed());
        //若写成下面这种则idea编译器无法自动识别，会认为item是Object
        //因为通常调用使用的是list.stream()生成一个stream类型，stream为泛型
        //而此处传入的第二个参数是ComparingInt(?),?为传入的类型是传入的参数类型或往上的父级类型
        //若不指定类型，则编译器默认为本身或往上的父级，String的上级为Object
        //此处指定类型需为String及以上类型
       // Collections.sort(list,Comparator.comparingInt(item->item.length()).reversed());
        //sort中传入是Comparator<? super E>，即传入参数为传入参数的类型或父类
        //此处会强转为E
        //去掉reversed即可推断出item的类型，但加上后会影响
        Collections.sort(list,Comparator.comparingInt((String item)->item.length()).reversed());
        list.sort(Comparator.comparingInt(String::length).reversed());
        //先按字符长度升序，若长度相同按照hash码排列
        //thenComparing的作用场景是，前面的比较器认为两者相等
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
        System.out.println("++++++++++++++++++++++++");
        Collections.sort(list,Comparator.comparingInt(String::length)
                .thenComparing((item1,item2)->item1.toLowerCase().compareToIgnoreCase(item2.toLowerCase())));
        System.out.println(list);
        System.out.println("----------------------");
        Collections.sort(list,Comparator.comparingInt(String::length)
                .thenComparing(Comparator.comparing(String::toLowerCase)));
        System.out.println(list);
        System.out.println("========================");
        //先按长度升序，若相同按照小写逆序
        Collections.sort(list,Comparator.comparingInt(String::length)
        .thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        System.out.println(list);
        System.out.println("11111111111111111111111111111");
        //先按长度逆序，若相同按小写逆序
        Collections.sort(list,Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        System.out.println(list);
        System.out.println(".............................");
        //多级排序
        //先按照长度降序，若相同按小写降序，若还相同再整体降序
        Collections.sort(list,Comparator.comparingInt(String::length).reversed()
        .thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder()))
                .thenComparing(Comparator.reverseOrder()));
    }
}
