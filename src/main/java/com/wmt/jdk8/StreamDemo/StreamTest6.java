package com.wmt.jdk8.StreamDemo;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        Stream<String> stream =Stream.generate(UUID.randomUUID()::toString);
        //这种写法是对的，因为不确定是否为空
        stream.findFirst().ifPresent(System.out::println);
        //从开始，每一个元素+2，输出前6个
        Stream.iterate(1,item->item +2).limit(6).forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //找出该流中大于2的元素，然后每个元素乘以2，然后忽略掉流的前两个元素，然后再取出流中的前两个元素，
        //最后求出流中元素的总和
        Stream<Integer> stream1 = Stream.iterate(1,item->item +2).limit(6);
        System.out.println(stream1.filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).sum());

        Stream<Integer> stream2 =stream1;
        //取最大/最小值，判断是否会为空
        stream2.filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).min().ifPresent(System.out::println);
        Stream<Integer> stream3 =stream1;
        //取出统计数据
       IntSummaryStatistics intSummaryStatistics= stream3.filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.toString());//结果：：IntSummaryStatistics{count=2, sum=32, min=14, average=16.000000, max=18}
    }
}
