package com.nano.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamDevoxxVenkat {

    public static void main(String[] args) {
        System.out.println(sqrtOfFirst100Primes());
        System.out.println("===========================================");
    }
    private static List<Double> sqrtOfFirst100Primes(){
        return Stream.iterate(1, e->e+1)
                .filter(Utils::isPrime)
                .map(Math::sqrt)
                .limit(100)
                .collect(toList());
    }
}

class Utils{
    public static boolean isPrime(int n){
        return n> 1 && IntStream.range(2, n)
                .noneMatch(i -> n%i==0);
    }
}
