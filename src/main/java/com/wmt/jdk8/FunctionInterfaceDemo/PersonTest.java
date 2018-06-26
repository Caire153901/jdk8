package com.wmt.jdk8.FunctionInterfaceDemo;

import com.wmt.jdk8.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person person1=new Person("zhangsan",20);
        Person person2=new Person("lisi",30);
        Person person3=new Person("wangwu",40);
        List<Person> personList= Arrays.asList(person1,person2,person3);
        PersonTest personTest=new PersonTest();
        List<Person> personList1=personTest.getPersonsByUserName("lisi",personList);
        personList1.forEach(person -> System.out.println(person.getAge()));

        List<Person> personList2=personTest.getPersonsByAge(25,personList);
        personList2.forEach(person -> System.out.println(person.getUserName()));

        List<Person> personList3=personTest.getPersonByAge2(25,personList,(age,persons)->
                persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList()));
        personList3.forEach(person -> System.out.println(person.getUserName()));

    }

    /**
     * 查找符合姓名的集合
     * @param userName 要查找的姓名
     * @param personList 要查找的集合
     * @return
     */
    public List<Person> getPersonsByUserName(String userName,List<Person> personList){
        return personList.stream().filter(person -> person.getUserName().equals(userName)).collect(Collectors.toList());
    }

    /**
     * 查找大于某个年龄的集合
     * @param age
     * @param personList
     * @return
     */
    public List<Person> getPersonsByAge(int age, List<Person> personList){
        BiFunction<Integer,List<Person>,List<Person>> biFunction=(ageOfPerson,persons)->persons.stream()
                .filter(person -> person.getAge() > ageOfPerson)
                   .collect(Collectors.toList());
        return biFunction.apply(age,personList);
    }

    /**
     * 查找符合Bifunction的集合
     * @param age
     * @param persons
     * @param biFunction
     * @return
     */
    public List<Person> getPersonByAge2(int age,List<Person> persons,BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,persons);
    }

}
