package com.wmt.jdk8.StreamDemo;

import com.wmt.jdk8.model.Student;
import com.wmt.jdk8.model.Students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");
        /*Students student1 =new Students("zhangsan",16);
        Students student2 =new Students("lisi",15);
        Students student3 =new Students("wangwu",18);
        Students student4 =new Students("maliu",20);
        List<Students> studentsList = Arrays.asList(student1,student2,student3,student4);
        studentsList.stream().sorted((a,b) -> b.getName().compareTo(a.getName())).forEach(s-> System.out.println(s.getName()));*/
        list.stream().sorted(Comparator.reverseOrder());

        //首字母大写
      //  list.stream().map(item->item.substring(0,1).toUpperCase()+item.substring(1)).forEach(System.out::println);
        //test被输出了5次，但其实只循环了一次，只是中间操作逐个进行应用并储存了，待到终止操作出现，一并执行
        list.stream().map(item->{
           String result =item.substring(0,1).toUpperCase()+item.substring(1);
           System.out.println("test");//若没有forEach，则没有输出
            //因为上一句属于中间操作，不执行，forEach为终止操作
           return result;
        }).forEach(System.out::println);


    }
}
