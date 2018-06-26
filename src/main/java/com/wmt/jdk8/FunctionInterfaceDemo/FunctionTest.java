package com.wmt.jdk8.FunctionInterfaceDemo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test=new FunctionTest();
        System.out.println("Function---------------------compute");
        System.out.println(test.compute(2,value->value*3,value->value*value));
        System.out.println("Function-----------------------andTen");
        System.out.println(test.compute2(2,value->value*3,value->value*value));
        System.out.println("BiFunction----------------------apply");
        System.out.println(test.compute3(2,3,(value1,value2)->value1+value2));
        System.out.println("BiFunction----------------------andThen");
        System.out.println(test.compute4(2,3,(value1,value2)->value1+value2,value->value*value+1));
    }
    public int compute(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }
    public int compute2(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }
    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> function3){
        return function3.apply(a,b);
    }
    public int compute4(int a, int b, BiFunction<Integer,Integer,Integer> function3,Function<Integer,Integer> function4){
        return function3.andThen(function4).apply(a,b);
    }

}
