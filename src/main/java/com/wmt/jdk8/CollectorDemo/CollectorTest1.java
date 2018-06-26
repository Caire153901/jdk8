package com.wmt.jdk8.CollectorDemo;

import com.wmt.jdk8.model.CollectorStudent;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorTest1 {
    public static void main(String[] args) {
        CollectorStudent streamStudent1 =new CollectorStudent("zhangsan",100);
        CollectorStudent streamStudent2 =new CollectorStudent("lisi",90);
        CollectorStudent streamStudent3 =new CollectorStudent("wangwu",90);
        CollectorStudent streamStudent4 =new CollectorStudent("zhangsan",80);
        List<CollectorStudent> students = Arrays.asList(streamStudent1,streamStudent2,streamStudent3,streamStudent4);
        List<CollectorStudent> students1 =students.stream().collect(Collectors.toList());
        students1.forEach(System.out::println);
        students.stream().collect(counting());
        //最低分数
        students.stream().collect(minBy(Comparator.comparingInt(CollectorStudent::getScore))).ifPresent(System.out::println);
        //最高分数
        students.stream().collect(maxBy(Comparator.comparingInt(CollectorStudent::getScore))).ifPresent(System.out::println);
        //加和
        students.stream().collect(summarizingInt(CollectorStudent::getScore));
        //均值
        students.stream().collect(averagingInt(CollectorStudent::getScore));
        //统计指标
        IntSummaryStatistics intSummaryStatistics= students.stream().collect(summarizingInt(CollectorStudent::getScore));
        System.out.println(intSummaryStatistics);
        System.out.println("--------------------------------------------");
        //拼接
        students.stream().map(CollectorStudent::getName).collect(joining());
        //以,拼接
        System.out.println(students.stream().map(CollectorStudent::getName).collect(joining(",")));
        //以<begin>开始，以<end>结束，以，拼接
        System.out.println(students.stream().map(CollectorStudent::getName).collect(joining(",","<begin>","<end>")));
        System.out.println("---------------------------------------------");
        //以score分组，再以name分组
        Map<Integer,Map<String,List<CollectorStudent>>> mapMap=students.stream().collect(groupingBy(CollectorStudent::getScore,groupingBy(CollectorStudent::getName)));
        System.out.println(mapMap);
        //根据分数是否大于80分区
        Map<Boolean,List<CollectorStudent>> map=students.stream().collect(partitioningBy(student->student.getScore()>80));
        System.out.println(map);
        //先根据分数大于80分区，再根据分数大于90分区
        Map<Boolean,Map<Boolean,List<CollectorStudent>>> map1=students.stream().collect(partitioningBy(student->student.getScore()>80,partitioningBy(student->student.getScore()>90)));
        System.out.println(map1);

        Map<Boolean,Long> map2=students.stream().collect(partitioningBy(student->student.getScore()>80,counting()));
        System.out.println(map2);
        //根据名字分组，在得到学生的分数
Map<String,CollectorStudent> map3= students.stream()
        .collect(groupingBy(CollectorStudent::getName,
                collectingAndThen(minBy(Comparator.comparingInt(CollectorStudent::getScore)),Optional::get)));
        System.out.println(map3);



    }
}
