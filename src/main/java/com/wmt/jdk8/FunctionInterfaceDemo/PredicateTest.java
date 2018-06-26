package com.wmt.jdk8.FunctionInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
/*        Predicate<String> predicate=p->p.length()>5;
        System.out.println(predicate.test("gasdaa"));
        Predicate<String> predicate1=p->p.length()<10;
        System.out.println(predicate.and(predicate1));*/
        PredicateTest predicateTest=new PredicateTest();
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //偶数
        System.out.println("偶数:");
        predicateTest.conditionFiter(list,item->item % 2 ==0);
        System.out.println("-----------------------------");
        System.out.println("奇数：");
        predicateTest.conditionFiter(list,item->item % 2 !=0);
        System.out.println("-----------------------------");
        System.out.println("大于5的：");
        predicateTest.conditionFiter(list,item->item>5);
        System.out.println("-----------------------------");
        System.out.println("小于3的：");
        predicateTest.conditionFiter(list,item->item<3);
        System.out.println("-----------------------------");
        System.out.println("全部：");
        predicateTest.conditionFiter(list,item->true);
        System.out.println("-----------------------------");
        System.out.println("不输出");
        predicateTest.conditionFiter(list,item->false);

        predicateTest.conditionFiter2(list,item->item % 2==0,item2->item2>5);

    }

    public void conditionFiter(List<Integer> list,Predicate<Integer> predicate){
        list.forEach(integer -> {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        });
    }

    public void conditionFiter2(List<Integer> list,Predicate<Integer> predicate1,Predicate<Integer> predicate2){
        list.forEach(integer -> {
            if (predicate1.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

}
