package com.wmt.jdk8.StreamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        //Stream的静态方法
        Stream stream1 = Stream.of("hello","world","hello world");
        //通过数组构建一个流
        String[] myArray = new String[]{"hello","world","hello world"};
        Stream stream2 = Stream.of(myArray);//of的实现为下面的Arrays.stream
        Stream stream3 = Arrays.stream(myArray);
        //通过集合构建一个流
        List<String> list =Arrays.asList(myArray);
        Stream stream4 =list.stream();
    }
}
