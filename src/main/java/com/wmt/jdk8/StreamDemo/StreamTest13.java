package com.wmt.jdk8.StreamDemo;

import com.wmt.jdk8.model.StreamStudent;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组
 */
public class StreamTest13 {
    public static void main(String[] args) {
        StreamStudent streamStudent1 =new StreamStudent("zhangsan",100,20);
        StreamStudent streamStudent2 =new StreamStudent("lisi",90,20);
        StreamStudent streamStudent3 =new StreamStudent("wangwu",90,30);
        StreamStudent streamStudent4 =new StreamStudent("zhangsan",80,40);
        //按照姓名分组
        List<StreamStudent> students = Arrays.asList(streamStudent1,streamStudent2,streamStudent3,streamStudent4);
        Map<String,List<StreamStudent>> map =students.stream().collect(Collectors.groupingBy(StreamStudent::getName));
        System.out.println(map);
        //按姓名分组计数
        Map<String,Long> map1= students.stream().collect(Collectors.groupingBy(StreamStudent::getName,Collectors.counting()));
        System.out.println(map1);
        //按姓名分组并求分数的均值
        Map<String,Double> map2=students.stream().collect(Collectors.groupingBy(StreamStudent::getName,Collectors.averagingDouble(StreamStudent::getScore)));
        System.out.println(map2);
        //分区,会按照条件分成两部分
       Map<Boolean,List<StreamStudent>> map3= students.stream()
               .collect(Collectors.partitioningBy(student->student.getScore() >=90));
        System.out.println(map3);
    }
}
