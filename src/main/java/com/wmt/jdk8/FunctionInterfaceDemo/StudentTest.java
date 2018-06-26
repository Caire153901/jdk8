package com.wmt.jdk8.FunctionInterfaceDemo;

import com.wmt.jdk8.model.Student;

import java.util.function.Supplier;

public class StudentTest {
    public static void main(String[] args) {
        Supplier<Student> supplier =() -> new Student();
        System.out.println(supplier.get().getName());
        System.out.println("--------上下一样--------");
        Supplier<Student> supplier1=Student::new;
        System.out.println(supplier1.get().getName());
    }
}
