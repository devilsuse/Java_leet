package com.nano.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate Operations transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invked

        // 1. filter
        List<String> l = Arrays.asList("Akshay", "Ram", "Ram", "Shyram");
        // No filtering done at this stage as Intermediate operations are lazy and Not invoked until terminal opration is called
        Stream<String> filteredStream = l.stream().filter(s->s.endsWith("m"));
        System.out.println(filteredStream.count());

        // 2. map
        Stream<String> stringStream = l.stream().map(String::toUpperCase);


        // 3. sorted
        Stream<String> sortedStream = l.stream().sorted();
        Stream<String> sortedStream1 = l.stream().sorted((a,b)-> a.length() - b.length());

        // 4. distinct
        System.out.println(l.stream().filter(x->x.endsWith("m")).distinct().count());

        // 5. limit
        System.out.println(Stream.iterate(1, x->x+1).limit(100).count());

        // 6. skip
        System.out.println("skip");
        Stream.iterate(1, x->x+1).skip(10).limit(100).forEach(System.out::println);


    }
}
