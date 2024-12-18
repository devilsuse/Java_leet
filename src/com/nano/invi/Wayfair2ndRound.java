package com.nano.invi;
/**
 Write a function, findMaxProductSubarray, which finds the subarray that has the largest product and returns the product:

 // Returns the product of the largest product subarray
 int findMaxProductSubarray(int[] nums)
 Input to the findMaxProductSubarray function is an integer array.

 Output of the findMaxProductSubarray function is an integer representing the product of the largest product subarray found in the input.
 Example 1:

 Input: nums = [2,3,-2,4]
 [2,3,-2,4]
 Output: 6

 Explanation: [2,3] has the largest product 6.

 Example 2:

 Input: nums = [-2,0,-1]

 Output: 0

 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 The subarray should contain at least one element.

 The test cases are generated so that the answer will fit in a 32-bit integer.

 */

/**
 Don’t make use of any existing BigInteger packages or other construct which allows you to convert the entire input numbers to integers, natively add them, and convert back to strings. The point of this problem is to implement addition on a digit-by-digit basis.

 Use of the internet for syntax and basic implementation questions

 Think out loud!  Describe your approach and discuss changes as new information surfaces

 Test-Driven Development is preferred but not required.  It is highly recommended to create a test runner function, assertAdd, which takes 3 inputs and displays whether the add function returns the third parameter when invoked with the first two parameters

 */

// Extension - Indices of Subarray
// Basic Test with indices assertFindMaxProductSubarray(new int[]{2, 3, -2, 4}, 6, new int[]{0, 1});

// Negative numbers with indices assertFindMaxProductSubarray(new int[]{-2, -3, -2, -4}, 48, new int[]{0, 3});

// Array with a single element with indices assertFindMaxProductSubarray(new int[]{5}, 5, new int[]{0, 0});

// Subarray with 3 elements with indices assertFindMaxProductSubarray(new int[]{-5, 2, -3}, 30, new int[]{0, 2});

// Subarray at the beginning with indices assertFindMaxProductSubarray(new int[]{3, 1, 4, 2, -5, 7}, 24, new int[]{0, 3});

// Subarray at the end with indices assertFindMaxProductSubarray(new int[]{1, -2, 3, -4, 5, -6}, 360, new int[]{2, 5});

// Array with all negative numbers with indices assertFindMaxProductSubarray(new int[]{-1, -2, -3, -4, -5}, 120, new int[]{1, 4});
/**
 // Asserts 'findMaxProductSubarray' operating correctly
 void assertFindMaxProductSubarray(int[] nums, int expectedProduct)
 Test Cases

 // Basic Test
 assertFindMaxProductSubarray(new int[]{2, 3, -2, 4}, 6);

 // Negative numbers
 assertFindMaxProductSubarray(new int[]{-2, -3, -2, -4}, 48);

 // Array with a single element
 assertFindMaxProductSubarray(new int[]{5}, 5);

 // Subarray with one element
 assertFindMaxProductSubarray(new int[]{-5, 2, -3}, 2);

 // Subarray at the beginning after zero
 assertFindMaxProductSubarray(new int[]{3, 0, 4, 2, -5, 7}, 8);

 // Subarray at the end
 assertFindMaxProductSubarray(new int[]{1, -2, 3, -4, 5, -6}, 360);

 // Array with all negative numbers of odd size
 assertFindMaxProductSubarray(new int[]{-1, -2, -3, -4, -5}, 120);

 // Edge case with empty input array
 assertFindMaxProductSubarray(new int[]{}, 0);

 // Edge case with a large array
 assertFindMaxProductSubarray(new int[]{1, 2, -3, 4, -5, 6, -7, 8}, 6720);

 // Edge case with all positive numbers
 assertFindMaxProductSubarray(new int[]{2, 3, 5, 7, 11}, 2310);

 // Edge case with all negative numbers except one positive number
 assertFindMaxProductSubarray(new int[]{-3, -7, -2, -5, -11, 13}, 10010);

 // Edge case with alternating positive and negative numbers
 assertFindMaxProductSubarray(new int[]{2, -3, 4, -5, 6, -7}, 840);
 */




import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Wayfair2ndRound {

    static int[] findMaxProductSubarray(int[] a) { //-5, 2, -3
        if(a==null || a.length==0)
            return new int[]{};
        int max = Integer.MIN_VALUE;
        int start =0;
        int end = 0;
        for(int i=0;i<a.length;i++){
            int product = a[i];//-5,2

            if(max<product){
                start =i;
                end=i;
                max=product;
            }
            //max=Math.max(max, product);//-5
            //System.out.println(max);
            for(int j=i+1;j<a.length;j++){
                product *= a[j];//-10
                if(max<product){
                    start =i;
                    end=j;
                    max=product;
                }
                // max=Math.max(max, product);//-5
            }
        }
        //System.out.println("Start=" )
        return new int[]{start,end}; //max;
        /*int count = 0;
        boolean isZero = false;
        for(int n: a){
            if(n<0){
                count++;
            }
            else if(n==0)
                isZero=true;
        }
        if(count%2==0 & !isZero)
            return product(a, 0, a.length-1);
            */

    }

    private int product(int[] a, int start, int end){
        int product =1;
        for(int i=start;i<=end;i++){
            product *=a[i];
        }
        return product;
    }
    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        int[] a1={2,3,3-2,4};
        int[] a2={-2, -3, -2, -4};
        int[] a3={5};
        int[] a4={-5, 2, -3};
        int[] a5={-5, 2, -3};*/
        // findMaxProductSubarray()
        // sum = addNumbers(a, b);
        //  System.out.println(sum);
        // Basic Test
        /*
System.out.println(assertFindMaxProductSubarray(new int[]{2, 3, -2, 4}, 6));

// Negative numbers
System.out.println(assertFindMaxProductSubarray(new int[]{-2, -3, -2, -4}, 48));

// Array with a single element
System.out.println(assertFindMaxProductSubarray(new int[]{5}, 5));

// Subarray with one element
System.out.println(assertFindMaxProductSubarray(new int[]{-5, 2, -3}, 30)); //failed

// Subarray at the beginning after zero
System.out.println(assertFindMaxProductSubarray(new int[]{3, 0, 4, 2, -5, 7}, 8));

// Subarray at the end
System.out.println(assertFindMaxProductSubarray(new int[]{1, -2, 3, -4, 5, -6}, 360));

// Array with all negative numbers of odd size
System.out.println(assertFindMaxProductSubarray(new int[]{-1, -2, -3, -4, -5}, 120));

// Edge case with empty input array
System.out.println(assertFindMaxProductSubarray(new int[]{}, 0)); //failed

// Edge case with a large array
System.out.println(assertFindMaxProductSubarray(new int[]{1, 2, -3, 4, -5, 6, -7, 8}, 6720));

// Edge case with all positive numbers
System.out.println(assertFindMaxProductSubarray(new int[]{2, 3, 5, 7, 11}, 2310));

// Edge case with all negative numbers except one positive number
System.out.println(assertFindMaxProductSubarray(new int[]{-3, -7, -2, -5, -11, 13}, 10010));

// Edge case with alternating positive and negative numbers
System.out.println(assertFindMaxProductSubarray(new int[]{2, -3, 4, -5, 6, -7}, 840));
*/
// Extension - Indices of Subarray
// Basic Test with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{2, 3, -2, 4}, 6, new int[]{0, 1}));

// Negative numbers with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{-2, -3, -2, -4}, 48, new int[]{0, 3}));

// Array with a single element with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{5}, 5, new int[]{0, 0}));

// Subarray with 3 elements with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{-5, 2, -3}, 30, new int[]{0, 2}));

// Subarray at the beginning with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{3, 1, 4, 2, -5, 7}, 24, new int[]{0, 3}));

        // Subarray at the end with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{1, -2, 3, -4, 5, -6}, 360, new int[]{2, 5}));

// Array with all negative numbers with indices
        System.out.println(assertFindMaxProductSubarray(new int[]{-1, -2, -3, -4, -5}, 120, new int[]{1, 4}));

    }

    private static boolean assertFindMaxProductSubarray(int[] a, int sum, int[] expected){
        return Arrays.equals(findMaxProductSubarray(a) , expected);
    }
}
