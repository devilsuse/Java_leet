package com.nano.core;

import java.util.*;
import java.util.stream.Stream;

public class TestClass {

    private Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static void main(String[] args) {
        Stream<String> stream;
        HashMap<String, String> m;
        Hashtable<?,?> ht;
        Integer a[] = new Integer[] { 10, 20, 30, 40 };
        System.out.println("RUN");
        ArrayList<Integer> aL = new ArrayList<>(); //Arrays.asList(a); removed it becoz Exception in thread "main" java.lang.ClassCastException: class java.util.Arrays$ArrayList cannot be cast to class java.util.ArrayList (java.util.Arrays$ArrayList and java.util.ArrayList are in module java.base of loader 'bootstrap')
        //at com.nano.core.TestClass.main(com.nano.core.TestClass.java:12)
        for(int i : a){
            aL.add(i);
        }
        //System.out.println(solve(aL));
        ArrayList<Integer> r = solve(aL);
        for(int i : r){
            System.out.println(i);
        }

        System.out.println("***findNumbers*****");
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
        System.out.println(addNullHashMapAndSet());

        TransientHashcodeTest t = new TransientHashcodeTest("a", 1, 2);
        System.out.println("com.nano.core.TransientHashcodeTest hashcode: " + t.hashCode()); //18228
        StringBuilder sb = new StringBuilder(5);
        sb.setCharAt(1, 'a');
        LinkedList ll;

    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        for(int i=1;i<A.size();i++){
            A.set(i, A.get(i)+A.get(i-1));
        }
        return A;
    }

    private static Map<String, String> addNullHashMapAndSet(){
        Map<String, String> m = new HashMap<>();
        m.put(null,"a");
        m.put("b","b");
        m.put("c","c");
        m.put(null,"d");
        return m;
    }

    public static int findNumbers(int[] nums) {
        int ans=0;
        for(int i: nums){
            int count=0;
            while(i>=10){
                System.out.println(i);
                count++;
                i=i%10;
            }
            if(count%2==1)
                ans++;
        }
        return ans;
    }
}
