package com.nano.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream s = IntStream.of(1,10);
        Stream<Integer> ss = IntStream.of(1,10).boxed();
    }
}
