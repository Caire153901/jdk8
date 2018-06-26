package com.wmt.jdk8.OptionalDemo;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optiona=Optional.of("ahsdja");
        optiona.ifPresent(item-> System.out.println(item));
        System.out.println("---------------");
        System.out.println(optiona.orElse("xxxxxxx"));
        System.out.println("---------------");
        System.out.println(optiona.orElseGet(()->"asdad"));
    }
}
