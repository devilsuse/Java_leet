package com.nano.invi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abbaa"));
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(printEvenSquares(list));
    }

    private static boolean isPalindrome(String s){
        if(s==null || s.length()==0)
            return false;

        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private static List<Integer> printEvenSquares(List<Integer> list){
        if(list==null)
            return new ArrayList<>();
        return list.stream().filter(n -> n % 2 == 0).map(n-> n*n).collect(Collectors.toList());
    }
}
