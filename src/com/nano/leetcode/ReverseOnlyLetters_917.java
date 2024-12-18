package com.nano.leetcode;

public class ReverseOnlyLetters_917 {
    public static void main(String[] args) {
        String[] arr = new String[]{"as123"}; //{"1234","as123", "a12s23d3f2g4h5j6k", "my12name897is7Anna9123Yo"};
        for(String s : arr) {
            System.out.println(s + " == " + reverseOnlyLetters(s));
        }
    }

    public static String reverseOnlyLetters(String s) {
        int n=s.length();
        int i=0, j=n-1;
        StringBuilder sb = new StringBuilder(n);

        while(i<j){
            char a; // = s.charAt(i);
            while(i<n && i<j){
                a = s.charAt(i);
                 if( !Character.isLetter(a)) {
                     System.out.println(a);
                     sb.insert(i, a);
                     i++;
                 }
                 else{
                     break;
                 }
            }
            char b; // = s.charAt(j);
            while(j>=0 && i<j){
                b = s.charAt(j);
                if(!Character.isLetter(b)) {
                    System.out.println(b);
                    sb.insert(j, b);
                    j--;
                }
                else{
                    break;
                }
            }
            if(i<n && j>=0){
                if(i==j){
                    sb.insert(i, s.charAt(i));
                }
                else {
                    sb.insert(i, s.charAt(j));
                    System.out.println(i + " : " + j);
                    sb.insert(j, s.charAt(i));
                    i++;j--;
                }
            }
        }
        return sb.toString();
    }
}
