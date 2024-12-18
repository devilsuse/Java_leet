package com.nano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given two string arrays words1 and words2.
A string b is a subset of string a if every letter in b occurs in a including multiplicity.
For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.
Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]


Constraints:
1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.


 */
public class Test {

    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"le","o"};

        System.out.println(getUniversal(words1, words2));

        String[] w1 = {"amazon","apple","facebook","google","leetcode"};
        String[] w2 = {"l","e"};
        System.out.println(getUniversal(w1, w2));

        String s1="abc";
        String s2="abc";
        System.out.println("s1 == s2 " + (s1 == s2));

        System.out.println('b' + 'y' + 't' + 'e');
        System.out.println("*********OUTPUT*******");
        output();
    }

    private static void output(){
        int[] x={7,8,9};
        int[] y={7,7,7};
        System.out.println(Arrays.compare(x,y));
        System.out.println(Arrays.mismatch(x,y));
    }
    private static List<String> getUniversal(String[] w1, String[] w2){
        List<int[]> counts = new ArrayList<>(w2.length);
        for(String w: w2){
            counts.add(getCountArray(w));
        }
        List<String> result = new ArrayList<>();
        for(String w : w1){
            int[] w1Count  = getCountArray(w);
            boolean containsAll = true;
            for(int[] w2Count : counts){
                if(!containsAll(w1Count, w2Count)){
                    containsAll=false;
                    break;
                }
            }
            if(containsAll)
                result.add(w);
        }
        return result;
    }

    private static boolean containsAll(int[] superset, int[] sub){
        for(int i=0;i<sub.length;i++){
            if(superset[i]<sub[i])
                return false;
        }
        return true;
    }

    private static int[] getCountArray(String w){
        int[] count = new int[26];
        for(int i=0;i<w.length();i++){
            count[w.charAt(i)-'a']++;
        }
        return count;
    }
}

/*
You are given two string arrays words1 and words2.
A string b is a subset of string a if every letter in b occurs in a including multiplicity.
For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.
Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]


Constraints:
1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.

What’s the difference between a raw type collection—e.g. Collection x—and an unbounded wildcard type collection—e.g. Collection<?> x?


threadlocal


@Function
@interface MyFunction{
	void do(int a);
}

List<Integer> l = new ArrayList();
Processor.complete(a->MyFunction::do);


public class Student{
	private int id
  private String name;
  private int age;
  private String department;
  private String city;

  private Student(){

  }

  public static class StudentBuilder{
  private int id
  private String name;
  private int age;
  private String department;
  private String city;

  public Student build()
  	Student s = new Student();
    s.setId(id);
    s.setName(name);
    s.setAge(age);
    s.setDepartment(department);
    s.setCity(city);
    return s;
  }

  public void id(int id){
  	this.id=id;
  }
  public void name(String name){
  	this.name=name;
  }
  }

}


Student s = StudentBuilder.id(1).age(4).build();
Student s1 = StudentBuilder.id(1).name("sss").build();
 */