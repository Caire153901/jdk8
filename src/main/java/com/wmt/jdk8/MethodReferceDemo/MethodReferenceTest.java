package com.wmt.jdk8.MethodReferceDemo;

import com.wmt.jdk8.model.Students;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public  String getString(Supplier<String> supplier){
        return supplier.get()+"test";
    }
    public String getString2(String str, Function<String,String> function){
        return function.apply(str);
    }
    public static void main(String[] args) {
        Students students1 =new Students("zhangsan",10);
        Students students2 =new Students("lisi",90);
        Students students3=new Students("wangwu",50);
        Students students4 =new Students("zhaoliu",80);
        List<Students> students= Arrays.asList(students1,students2,students3,students4);

        /**
         * 使用 类名::静态方法名
         */
        System.out.println("使用 类名::静态方法名");
        students.sort((studentParam1,studentParam2)->
                Students.compareStudentByScore(studentParam1,studentParam2));
        students.forEach(student->System.out.println(student.getName()));
        System.out.println("---------------------------------");
        students.sort(Students::compareStudentByScore);
        students.forEach(student-> System.out.println(student.getName()));
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        System.out.println("使用 引用名（对象名）::实例方法名");
        StudentComparator studentComparator=new StudentComparator();
        students.sort((studentParam1,studentParam2)->studentComparator
                .compareStudentByScore(studentParam1,studentParam2));
        students.forEach(student-> System.out.println(student.getScore()));
        System.out.println("------------------------------");
        students.sort(studentComparator::compareStudentByScore);
        students.forEach(student-> System.out.println(student.getScore()));
        System.out.println("++++++++++++++++++++++++++++++++++");

        System.out.println("类名::实例方法名");
        students.sort(Students::compareByScore);
        students.forEach(student-> System.out.println(student));
        System.out.println("++++++++++++++++++++++++++++++++++");
        List<String> cities =Arrays.asList("beijing","chengdu","guangzhou","shanghai","hangzhou");
        Collections.sort(cities,(city1,city2)->city1.compareToIgnoreCase(city2));
        cities.forEach(city-> System.out.println(city));
        Collections.sort(cities,String::compareToIgnoreCase);
        cities.forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("构造方法引用:类名::new");
        MethodReferenceTest methodReferenceTest=new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello",String::new));

    }
}
