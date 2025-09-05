package com.nano.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalOps {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        // 1. collect
        List<Integer> list1 = list.stream().skip(1).toList();
        List<Integer> list2 = list.stream().skip(1).collect(Collectors.toList());
        System.out.println(list1);
        System.out.println();
        System.out.println(list2);
        System.out.println("SUM: " + (Integer) list.stream().mapToInt(x -> x).sum());
        System.out.println("averagingInt: " + list.stream().collect(Collectors.averagingInt(x->x)));
        // 2. forEach
        list.stream().forEach(System.out::println);
        System.out.println("forEach");
        list.forEach(System.out::println);
        // 3. reduce

        // 4. count

        // 5. anymatch, allMatch, noneMatch
        boolean b1 = list.stream().anyMatch(x->x%3==0);
        System.out.println(b1);
        boolean b2 = list.stream().allMatch(x->x%222==0);
        System.out.println(b2);
        boolean b3 = list.stream().noneMatch(x->x%3==0);
        System.out.println(b3);


        // 6. findFirst, findAny
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findFirst().get());

        // Examples
        //List<String>

        // stateful vs stateless peration
        // map is statelss
        // sorted is stateful
        String sentence = "Java is a language. java is versatile language.";
        Map<String, Long> frequency = Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println(frequency);

    }
}
