package com.nano.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,42);
        int c =3;
        System.out.println();
        System.out.println(numbers.stream().filter(x->x%2==0).count());


        // Creating Streams
        // 1. From Collections
        List<Integer> l = Arrays.asList(1,2,3,4,56,6,7);
        Stream<Integer> stream = l.stream();

        // 2. From Arrays
        String[] array = {"a","b", "c"};
        Stream<String> aStream = Arrays.stream(array);

        //3. Using Stream.of()
        Stream<String> stream2 = Stream.of("a","c");

        // 4. Infinite Stream:
        // 1) Using generate() method on Stream
        Stream<Integer> stream3 = Stream.generate(() -> 1);
        // 2) Using iterate() method on Stream
        Stream<Integer> stream4 = Stream.iterate(1, x -> x+ 1);
        Collectors.toList();
    }
 }
