package com.nano.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
3688. Bitwise OR of Even Numbers in an Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums.

Return the bitwise OR of all even numbers in the array.

If there are no even numbers in nums, return 0.



Example 1:

Input: nums = [1,2,3,4,5,6]

Output: 6

Explanation:

The even numbers are 2, 4, and 6. Their bitwise OR equals 6.

Example 2:

Input: nums = [7,9,11]

Output: 0

Explanation:

There are no even numbers, so the result is 0.

Example 3:

Input: nums = [1,8,16]

Output: 24

Explanation:

The even numbers are 8 and 16. Their bitwise OR equals 24.
Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

*/
public class _3688_Bitwise_OR_of_Even_Numbers_in_Array {

    /* Works in Java But without streams
    public int evenNumberBitwiseORs(int[] nums) {
        int count = 0;
        int result = 0;
        for(int x : nums){
            if(x%2==0){
                count++;
                result |= x;
            }
        }
        return count==0?0:result;
    }
    */

    public int evenNumberBitwiseORs(int[] nums) {
        return Arrays.stream(nums).filter(x-> x%2==0)
                .reduce((a,b)->a|b)
                .orElse(0);
    }
}
