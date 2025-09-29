package com.nano.leetcode.array;

import java.util.Arrays;

/*
976. Largest Perimeter Triangle
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

Example 1:

Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
Example 2:

Input: nums = [1,2,1,10]
Output: 0
Explanation:
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.


Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106
 */
public class _976_Largest_Perimeter_Triangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-3;i>=0;i--){
            if(nums[i]+nums[i+1]>nums[i+2])
                return nums[i]+nums[i+1]+nums[i+2];
        }
        return 0;
    }

    /*
Approach 1: Sort
Intuition

Without loss of generality, say the sidelengths of the triangle are a≤b≤c. The necessary and sufficient condition for these lengths to form a triangle of non-zero area is a+b>c.

Say we knew c already. There is no reason not to choose the largest possible a and b from the array. If a+b>c, then it forms a triangle, otherwise it doesn't.

Algorithm

This leads to a simple algorithm: Sort the array. For any c in the array, we choose the largest possible a≤b≤c: these are just the two values adjacent to c. If this forms a triangle, we return the answer.

    class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
}

    class Solution(object):
    def largestPerimeter(self, A):
        A.sort()
        for i in xrange(len(A) - 3, -1, -1):
            if A[i] + A[i+1] > A[i+2]:
                return A[i] + A[i+1] + A[i+2]
        return 0

Complexity Analysis

Time Complexity: O(NlogN), where N is the length of A.

Space Complexity: O(1).
     */
}
