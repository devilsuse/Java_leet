package com.nano.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
1512. Number of Good Pairs
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */

/////// ********* My Solution *******************************
public class NumberOfGoodPairs_1512 {

    public static void main(String[] args) {

    }
    public int numIdenticalPairs(int[] nums) {
        if(nums.length==1)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        //Number of pairs formed for x repetition of an integer is (sum of natural numbers till (x-1))...
        int sum=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            sum+=(value-1)*(value)/2;
        }
        return sum;
    }
}

/*

Approach 1: Check All Pairs
Intuition

The problem description defines a pair (i, j) as needing to have i < j. We can simply check all these pairs and count the number of pairs where nums[i] == nums[j].

Iterate i over the indices of nums. For each i, iterate over all j greater than i. If the numbers at the indices match, increment the answer.

Algorithm

Initialize ans = 0.
Iterate i from 0 until nums.length:
Iterate j from i + 1 until nums.length:
If nums[i] == nums[j], increment ans.
Return ans.
Implementation
class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        ans = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    ans += 1

        return ans

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}

Complexity Analysis

Given nnn as the length of nums,

Time complexity: O(n2)O(n^2)O(n
2
 )

We have a nested loop over the length of the input. The total iterations is 1 + 2 + 3 + 4 + ... + n, which is the partial sum of this series, which is equal to n⋅(n+1)2\frac{n \cdot (n + 1)}{2}
2
n⋅(n+1)
​
  = n2+n2\frac{n^2 + n}{2}
2
n
2
 +n
​
 . In big O, this is O(n2)O(n^2)O(n
2
 ) because the addition term in the numerator and the constant term in the denominator are both ignored.

Space complexity: O(1)O(1)O(1)

We aren't using any extra space except for a few integers.


Approach 2: Hash Map
Intuition

We can improve our performance by using a hash map to count the frequency of the encountered numbers during the traversal.

Let's say that we are iterating over the input, and we encounter a number x = 6. We also know that we have seen 6 three times before the current index. The current 6 could pair with any of the previous three to form a good pair.

In general, whenever we encounter a number, it can form k good pairs with previously traversed numbers, where k is the number of times we have seen the number previously.

Different from approach 1, while this approach doesn't track the indices of each number, we keep a count of their occurrences. This ensures that all good pairs are considered, and because the counts of each number are accumulated as it's traversed, it guarantees that good pairs are counted only once. This way, we avoid both undercounting and overcounting.

example


Algorithm

Initialize ans = 0 and a hash map counts.
Iterate over the input. For each num:
Increment ans by counts[num].
Increment counts[num].
Return ans.
Implementation
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;

        for (int num: nums) {
            ans += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        return ans;
    }
}

class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        counts = defaultdict(int)
        ans = 0

        for num in nums:
            ans += counts[num]
            counts[num] += 1

        return ans

Complexity Analysis

Given nnn as the length of nums,

Time complexity: O(n)O(n)O(n)

We iterate over the input once. At each iteration, we perform O(1)O(1)O(1) work since hash map operations run in constant time.

Space complexity: O(n)O(n)O(n)

In the worst case, the array contains at most nnn unique numbers, then counts will grow to a size of nnn.

*/