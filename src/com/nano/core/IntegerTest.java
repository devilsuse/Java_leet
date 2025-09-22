package com.nano.core;

public class IntegerTest {
    public static void main(String[] args) {
        Integer i = new Integer("1");
        System.out.println(i);
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b); // false

        Integer x = 1;
        Integer y = 1;
        System.out.println(x == y); // true
    }
}
