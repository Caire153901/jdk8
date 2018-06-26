package com.wmt.jdk8.StreamDemo;

import java.util.Arrays;
import java.util.List;

//对流的进一步应用
public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        //map相当于是中间操作，reduce相当于终止操作
        System.out.println(list.stream().map(i ->2*i).reduce(0,Integer::sum));
    }
}
