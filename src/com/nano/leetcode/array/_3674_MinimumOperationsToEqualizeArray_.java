package com.nano.leetcode.array;

public class _3674_MinimumOperationsToEqualizeArray_ {
    // If all elements are equal return ZERO as no need of any operations
    // Else return 1 as AND all elements together and replace them ONCE, no need to do AND again
    public int minOperations(int[] nums) {
        int i=1;
        while(i<nums.length) {
            if (nums[i] == nums[i - 1])
                i++;
            else
                break;
        }
        return (i==nums.length)?0:1;
    }
}
