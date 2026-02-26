package com.nano.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDevDotJava {
    public static void main(String[] args) {
        List<String> strings = List.of("one","two","three","four");

        var map = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

        System.out.println("======================================================================");
        map();
    }

    private static void map(){
        List<String> strings = List.of("one", "two", "three", "four");

        List<Integer> lengths = strings.stream()
                .map(String::length)
                .toList();

        System.out.println("lengths = " + lengths);
    }
}
