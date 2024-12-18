package com.nano.leetcode.array;

import java.util.*;

/*
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1


Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

 */
public class _136_SingleNumber {
/*
Approach 4: Bit Manipulation
Concept

If we take XOR of zero and some bit, it will return that bit
a⊕0=a
If we take XOR of two same bits, it will return 0
a⊕a=0
a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
So we can XOR all bits together to find the unique number.
---GO
// Golang
func singleNumber(nums []int) int {
    a := 0
    for _, i := range nums {
        a ^= i
    }
    return a
}

-----Py
class Solution(object):
    def singleNumber(self, nums: List[int]) -> int:
        a = 0
        for i in nums:
            a ^= i
        return a
---typescript
// TypeScript
function singleNumber(nums: number[]): number {
    let a = 0;
    for (let i of nums) {
        a ^= i;
    }
    return a;
}


 */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

/*
Approach 3: Math
Concept
2∗(a+b+c)−(a+a+b+b+c)=c
----GO
func singleNumber(nums []int) int {
    set := make(map[int]bool)
    sumOfSet, sumOfNums := 0, 0
    for _, num := range nums {
        if !set[num] {
            set[num] = true
            sumOfSet += num
        }
        sumOfNums += num
    }
    return 2*sumOfSet - sumOfNums
}
-------PY
class Solution(object):
    def singleNumber(self, nums: List[int]) -> int:
        return 2 * sum(set(nums)) - sum(nums)

--typecript
function singleNumber(nums: number[]): number {
    let setSum = 0,
        numsSum = 0;
    const set = new Set<number>();
    for (const num of nums) {
        if (!set.has(num)) {
            set.add(num);
            setSum += num;
        }
        numsSum += num;
    }
    return 2 * setSum - numsSum;
}
----
 */
public int singleNumber3(int[] nums) {
    int sumOfSet = 0, sumOfNums = 0;
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
        if (!set.contains(num)) {
            set.add(num);
            sumOfSet += num;
        }
        sumOfNums += num;
    }
    return 2 * sumOfSet - sumOfNums;
    }

/*
Approach 2: Hash Table
Algorithm

We use hash table to avoid the
O(n) time required for searching the elements.

Iterate through all elements in nums and set up key/value pair.
Return the element which appeared only once.

-----------GO
func singleNumber(nums []int) int {
    hash_table := make(map[int]int)
    for _, num := range nums {
        hash_table[num]++
    }
    for _, num := range nums {
        if hash_table[num] == 1 {
            return num
        }
    }
    return 0
}
---------py---
from collections import defaultdict


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        hash_table = defaultdict(int)
        for i in nums:
            hash_table[i] += 1

        for i in hash_table:
            if hash_table[i] == 1:
                return i
-----Typescript
function singleNumber(nums: number[]): number {
    let hash_table: { [key: number]: number } = {};
    for (let num of nums) {
        if (hash_table[num]) {
            hash_table[num]++;
        } else {
            hash_table[num] = 1;
        }
    }
    for (let num of nums) {
        if (hash_table[num] == 1) {
            return num;
        }
    }
    return 0;
}
 */
     public int singleNumber2(int[] nums) {
            HashMap<Integer, Integer> hash_table = new HashMap<>();

            for (int i : nums) {
                hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
            }
            for (int i : nums) {
                if (hash_table.get(i) == 1) {
                    return i;
                }
            }
            return 0;
        }

/*
Approach 1: List operation
Algorithm

1. Iterate over all the elements in nums
2. If some number in nums is new to array, append it
3. If some number is already in the array, remove it

-----------GO
func singleNumber(nums []int) int {
    no_duplicate_list := []int{}
    for _, i := range nums {
        found := false
        for j, x := range no_duplicate_list {
            if i == x {
                found = true
                no_duplicate_list = append(
                    no_duplicate_list[:j],
                    no_duplicate_list[j+1:]...)
                break
            }
        }
        if !found {
            no_duplicate_list = append(no_duplicate_list, i)
        }
    }
    return no_duplicate_list[0]
}
---------py
class Solution(object):
    def singleNumber(self, nums: List[int]) -> int:
        no_duplicate_list = []
        for i in nums:
            if i not in no_duplicate_list:
                no_duplicate_list.append(i)
            else:
                no_duplicate_list.remove(i)
        return no_duplicate_list.pop()
---typescript
function singleNumber(nums: number[]): number {
    let no_duplicate_list: number[] = [];
    for (let i of nums) {
        if (!no_duplicate_list.includes(i)) {
            no_duplicate_list.push(i);
        } else {
            no_duplicate_list.splice(no_duplicate_list.indexOf(i), 1);
        }
    }
    return no_duplicate_list[0];
}

 */
        public int singleNumber4(int[] nums) {
            List<Integer> no_duplicate_list = new ArrayList<>();

            for (int i : nums) {
                if (!no_duplicate_list.contains(i)) {
                    no_duplicate_list.add(i);
                } else {
                    no_duplicate_list.remove(Integer.valueOf(i));
                }
            }
            return no_duplicate_list.get(0);
        }

}
