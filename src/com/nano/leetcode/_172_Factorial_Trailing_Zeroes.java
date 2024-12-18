package com.nano.leetcode;

/*
172. Factorial Trailing Zeroes
Medium

3013

1918

Add to List

Share
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.



Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0


Constraints:

0 <= n <= 104


Follow up: Could you write a solution that works in logarithmic time complexity?

https://youtu.be/YIFMY724HTA?si=Z0U5xkFX2NMeLlc7&t=4847
 */
public class _172_Factorial_Trailing_Zeroes {

    public int trailingZeroes(int n) {
        int multiplier=5;
        int result=0;
        while(n/multiplier!=0){
            result+=n/multiplier;
            multiplier*=5;
        }
        return result;
    }

    public int trailingZeroesDiscuss(int n) {
        int result = 0;
        //count all the 5's and store that
        for(int i = 5 ; i<=n; i*=5)
            result += n / i;
        return result;
    }
}
