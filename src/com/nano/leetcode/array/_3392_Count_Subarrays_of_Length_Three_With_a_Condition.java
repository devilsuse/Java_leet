package com.nano.leetcode.array;

/**
 * 3392. Count Subarrays of Length Three With a Condition
 * Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.
 * Example 1:
 *
 * Input: nums = [1,2,1,4,1]
 *
 * Output: 1
 *
 * Explanation:
 *
 * Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1]
 *
 * Output: 0
 *
 * Explanation:
 *
 * [1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.
 * Constraints:
 *
 * 3 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class _3392_Count_Subarrays_of_Length_Three_With_a_Condition {
        public int countSubarrays(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 1; i < n - 1; ++i) {
                if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                    ++ans;
                }
            }
            return ans;
        }

        /*
        Python3:

        class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(1, n - 1):
            if nums[i] == (nums[i - 1] + nums[i + 1]) * 2:
                ans += 1
        return ans


        Rust:
        impl Solution {
    pub fn count_subarrays(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut ans = 0;
        for i in 1..n-1 {
            if nums[i] == (nums[i - 1] + nums[i + 1]) * 2 {
                ans += 1;
            }
        }
        ans
    }
}

#Go
func countSubarrays(nums []int) int {
	n := len(nums)
	ans := 0
	for i := 1; i < n-1; i++ {
		if nums[i] == (nums[i-1]+nums[i+1])*2 {
			ans++
		}
	}
	return ans
}

#C
int countSubarrays(int* nums, int numsSize) {
    int ans = 0;
    for (int i = 1; i < numsSize - 1; ++i) {
        if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
            ++ans;
        }
    }
    return ans;
}
         */

}
