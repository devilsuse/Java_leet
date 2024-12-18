package com.nano.invi;

import java.util.HashMap;
import java.util.Map;

/*
1111
2121


 */
public class LargeSum {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String chars = "0123456789";
        for(int i=0;i<10;i++){
            map.put(chars.charAt(i), i);
        }

        String a = "99";
        String b = "1";

        String aa = a.replaceAll(",","");
        String bb = b.replaceAll(",","");
        String sum = add(aa,bb);

        System.out.println(formatWithCommas(sum));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(31));
        System.out.println(fibonacci(100));
    }

    private static String fibonacci(int n){
        if(n<3)
            return "1";

        String a="1";
        String b="1";
        int i=3;
        String result="";
        while(i<=n){
            result=formatWithCommas(add(a,b));
            a=b.replaceAll(",","");
            b = result.replaceAll(",","");
            i++;
        }
         return result;
    }


    private static String formatWithCommas(String s){
        if(s.length()<4)
            return s;
        StringBuilder sb = new StringBuilder();
        //10, 000, 000, 000
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(count%3==0 && i!=s.length()-1){
                sb.append(',');
            }
            sb.append(s.charAt(i));
            count++;
        }

        return sb.reverse().toString();
    }

    private static String add(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1, j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0){
            int x=0;
            if(i>=0){
                x=map.get(a.charAt(i));
                i--;
            }
            int y=0;
            if(j>=0){
                y=map.get(b.charAt(j));;
                j--;
            }
            int z=x+y+carry;
            carry=z/10;
            sb.append(z%10);

        }
        if(carry>0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
