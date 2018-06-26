package com.wmt.jdk8.FunctionInterfaceDemo;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest=new BinaryOperatorTest();
        binaryOperatorTest.complie(1,2,(a,b)->a+b);
        System.out.println("-----------------------------");
        System.out.println(binaryOperatorTest.getShort("hello123","world", Comparator.comparingInt(String::length)));

    }
    public Integer complie(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

    public String getShort(String a,String b,Comparator<String> comparator){
        return  BinaryOperator.minBy(comparator).apply(a,b);
    }
}
