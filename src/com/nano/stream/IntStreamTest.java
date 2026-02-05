package com.nano.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamTest {

    record A(int a, int b){}
    public static void main(String[] args) {
        IntStream s = IntStream.of(1,10);


        //IntStream.of(1,10).forEach(System::println);

        Stream<Integer> ss = IntStream.of(1,10).boxed();
    }
    public interface Polygon { }
    public class Triangle { }

    public void work(Triangle t) {
        Polygon p = (Polygon) t;
    }

}
