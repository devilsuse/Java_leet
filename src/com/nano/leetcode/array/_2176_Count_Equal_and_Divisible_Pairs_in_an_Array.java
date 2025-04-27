package com.nano.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2176. Count Equal and Divisible Pairs in an Array
 * Easy
 * Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,2,2,1,3], k = 2
 * Output: 4
 * Explanation:
 * There are 4 pairs that meet all the requirements:
 * - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
 * - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
 * - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
 * - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 1
 * Output: 0
 * Explanation: Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i], k <= 100
 */
public class _2176_Count_Equal_and_Divisible_Pairs_in_an_Array {

    // My solution
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i], f -> new ArrayList<>()).add(i);
        }

        int result =0;
        for(Map.Entry<Integer, List<Integer>> e : map.entrySet()){
            List<Integer> list = e.getValue();
            for(int i=0; i<list.size(); i++){
                for(int j=i+1;j<list.size();j++){
                    if((list.get(i)*list.get(j))%k == 0)
                        result++;
                }
            }
        }
        return result;
    }

    /**
     * Approach 1: Traverse number pairs
     * Intuition
     * We use n to represent the length of the array nums. To count the number of pairs that meet the requirements, we can use two nested loops to traverse all pairs (i, j) that satisfy 0≤i<j<n, and check individually whether i×jmodk is equal to 0 and whether nums[i] is equal to nums[j].
     *
     * At the same time, we use res to count the number of pairs of numbers that meet the requirements. If a pair of numbers (i,j) meets the requirements, we add 1 to res. Finally, we return res as the number of pairs of numbers that meet the requirements.
     *
     * Implementation
     *
     * class Solution {
     *
     *     public int countPairs(int[] nums, int k) {
     *         int n = nums.length;
     *         int res = 0; // number of pairs meeting the requirements
     *         for (int i = 0; i < n - 1; ++i) {
     *             for (int j = i + 1; j < n; ++j) {
     *                 if ((i * j) % k == 0 && nums[i] == nums[j]) {
     *                     ++res;
     *                 }
     *             }
     *         }
     *         return res;
     *     }
     * }
     * Py
     * class Solution:
     *     def countPairs(self, nums: List[int], k: int) -> int:
     *         n = len(nums)
     *         res = 0  # number of pairs meeting the requirements
     *         for i in range(n - 1):
     *             for j in range(i + 1, n):
     *                 if (i * j) % k == 0 and nums[i] == nums[j]:
     *                     res += 1
     *         return res
     *
     *   Rust:
     *   impl Solution {
     *     pub fn count_pairs(nums: Vec<i32>, k: i32) -> i32 {
     *         let n = nums.len();
     *         let mut res = 0;   // number of pairs meeting the requirements
     *         for i in 0..n - 1 {
     *             for j in i + 1..n {
     *                 if (i * j) % k as usize == 0 && nums[i] == nums[j] {
     *                     res += 1;
     *                 }
     *             }
     *         }
     *         res
     *     }
     * }
     * Go:
     * func countPairs(nums []int, k int) int {
     * 	n := len(nums)
     * 	res := 0 // number of pairs meeting the requirements
     * 	for i := 0; i < n-1; i++ {
     * 		for j := i + 1; j < n; j++ {
     * 			if (i*j)%k == 0 && nums[i] == nums[j] {
     * 				res++
     * 			}
     * 		}
     * 	}
     * 	return res
     *
     *
     * Complexity Analysis
     * Let n be the length of the array nums.
     *
     * Time complexity: O(n
     * 2
     *  ).
     * This is the time complexity for traversing number pairs and counting the number of pairs that meet the requirements.
     *
     * Space complexity: O(1).
     * Only a few additional variables are needed.
     */
}
