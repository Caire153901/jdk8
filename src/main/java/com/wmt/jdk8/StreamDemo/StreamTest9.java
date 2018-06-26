package com.wmt.jdk8.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>(5000000);
        for(int i=0;i<5000000;++i){
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序：");
        long start = System.nanoTime();
        list.stream().sorted().count();//串行
        final long count = list.parallelStream().sorted().count();//并行

        long end =System.nanoTime();
        long mill = TimeUnit.NANOSECONDS.toMillis(end-start);
        System.out.println("排序耗时："+mill);
    }
}
