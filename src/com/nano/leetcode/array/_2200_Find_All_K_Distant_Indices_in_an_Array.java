package com.nano.leetcode.array;

import java.util.*;


/*
2200. Find All K-Distant Indices in an Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.

Return a list of all k-distant indices sorted in increasing order.

 

Example 1:

Input: nums = [3,4,9,1,3,9,5], key = 9, k = 1
Output: [1,2,3,4,5,6]
Explanation: Here, nums[2] == key and nums[5] == key.
- For index 0, |0 - 2| > k and |0 - 5| > k, so there is no j where |0 - j| <= k and nums[j] == key. Thus, 0 is not a k-distant index.
- For index 1, |1 - 2| <= k and nums[2] == key, so 1 is a k-distant index.
- For index 2, |2 - 2| <= k and nums[2] == key, so 2 is a k-distant index.
- For index 3, |3 - 2| <= k and nums[2] == key, so 3 is a k-distant index.
- For index 4, |4 - 5| <= k and nums[5] == key, so 4 is a k-distant index.
- For index 5, |5 - 5| <= k and nums[5] == key, so 5 is a k-distant index.
- For index 6, |6 - 5| <= k and nums[5] == key, so 6 is a k-distant index.
Thus, we return [1,2,3,4,5,6] which is sorted in increasing order. 
Example 2:

Input: nums = [2,2,2,2,2], key = 2, k = 2
Output: [0,1,2,3,4]
Explanation: For all indices i in nums, there exists some index j such that |i - j| <= k and nums[j] == key, so every index is a k-distant index. 
Hence, we return [0,1,2,3,4].
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
key is an integer from the array nums.
1 <= k <= nums.length
*/

public class _2200_Find_All_K_Distant_Indices_in_an_Array {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        for( int i=0; i<nums.length;i++){
            if(nums[i]==key)
                indices.add(i);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<indices.size();i++){
            int j=k;
            while(j>=0){
                int index = indices.get(i)-j>0 ? indices.get(i)-j : j-indices.get(i);
                if(index>=0 && index<nums.length)
                    set.add(index);
                index = indices.get(i)+j;
                if(index>=0 && index<nums.length)
                    set.add(index);
                j--;
            }
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    /*
    Approach 2: One-time Traversal
Intuition
Let's assume the length of the array nums is n. Then, for any index j that satisfies nums[j]=key, 
all indices within the closed interval [max(0,j−k),min(n−1,j+k)] are K-neighbor indices (the maximum 
and minimum functions are used here to ensure the indices are valid).

So, we can find all indices j such that nums[j]=key by traversing the array nums once, and then 
adding the integers within the corresponding interval to res. However, this can still lead to the 
possibility of duplicate indices being added to the answer array. To avoid this, we can use r to 
represent the smallest index that has not yet been determined to be a K-nearest neighbor index. 
Before the traversal begins, let r=0. Whenever we reach an index j that satisfies the condition, 
we just need to add all indices within the closed interval [max(0,j−k),min(n−1,j+k)] in order to res, 
starting from r, and at the same time, update r to min(n−1,j+k)+1. After the traversal is complete, 
res will contain all K-nearest neighbor indices, sorted in ascending order and without duplicates.

Complexity Analysis
Let n be the length of the array nums.

Time complexity: O(n).

We only need to traverse the array once.

Space complexity: O(1).

The output array is not counted in the space complexity.


     * class Solution {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int r = 0; // unjudged minimum index
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}

# Go
func findKDistantIndices(nums []int, key int, k int) []int {
	var res []int
	r := 0 // unjudged minimum index
	n := len(nums)
	for j := 0; j < n; j++ {
		if nums[j] == key {
			l := max(r, j-k)
			r = min(n-1, j+k) + 1
			for i := l; i < r; i++ {
				res = append(res, i)
			}   
		}
	}
	return res
}

//Rust
impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        let mut res = Vec::new();
        let mut r = 0; // unjudged minimum index
        let n = nums.len();
        for j in 0..n {
            if nums[j] == key {
                let l = r.max(j as i32 - k);
                r = (n as i32 - 1).min(j as i32 + k) + 1;
                for i in l..r {
                    res.push(i);
                }
            }
        }
        res
    }
}

#py
class Solution:
    def findKDistantIndices(
        self, nums: List[int], key: int, k: int
    ) -> List[int]:
        res = []
        r = 0  # unjudged minimum index
        n = len(nums)
        for j in range(n):
            if nums[j] == key:
                l = max(r, j - k)
                r = min(n - 1, j + k) + 1
                for i in range(l, r):
                    res.append(i)
        return res

   #typescript
    function findKDistantIndices(nums: number[], key: number, k: number): number[] {
    const res: number[] = [];
    let r = 0; // unjudged minimum index
    const n = nums.length;
    for (let j = 0; j < n; ++j) {
        if (nums[j] === key) {
            const l = Math.max(r, j - k);
            r = Math.min(n - 1, j + k) + 1;
            for (let i = l; i < r; ++i) {
                res.push(i);
            }
        }
    }
    return res;
}    

# c++
class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        vector<int> res;
        int r = 0;  // unjudged minimum index
        int n = nums.size();
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = max(r, j - k);
                r = min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.push_back(i);
                }
            }
        }
        return res;
    }
};

#javascript

var findKDistantIndices = function (nums, key, k) {
    const res = [];
    let r = 0; // unjudged minimum index
    const n = nums.length;
    for (let j = 0; j < n; ++j) {
        if (nums[j] === key) {
            const l = Math.max(r, j - k);
            r = Math.min(n - 1, j + k) + 1;
            for (let i = l; i < r; ++i) {
                res.push(i);
            }
        }
    }
    return res;
};

C#
public class Solution {
    public IList<int> FindKDistantIndices(int[] nums, int key, int k) {
        List<int> res = new List<int>();
        int r = 0;  // unjudged minimum index
        int n = nums.Length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.Max(r, j - k);
                r = Math.Min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.Add(i);
                }
            }
        }
        return res;
    }
}

     */
}