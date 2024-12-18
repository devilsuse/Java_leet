package com.nano.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class LinkedInJavaTest {

    public static void main(String[] args) {
        que1();
    }

    public static void que1(){
        List<String> song = Arrays.asList("humble","element","dns");
        Function<String,String> capitalize = str->str.toUpperCase();
        song.stream().map(capitalize).forEach(System.out::println);
    }
}
