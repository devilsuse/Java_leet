package com.nano.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static  java.util.stream.Collectors.*;
import java.util.stream.Stream;

public class ModifyStreamAfterCreationBeforeTermination {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));
        System.out.println(s);
    }


}
