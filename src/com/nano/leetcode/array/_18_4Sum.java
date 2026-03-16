package com.nano.leetcode.array;
/*
18. 4Sum
Medium
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class _18_4Sum {

    
/*
Solution
This problem is a follow-up of 3Sum, so take a look at that problem first if you haven't. 4Sum and 3Sum are very similar; the difference is that we are looking for unique quadruplets instead of triplets.

As you see, 3Sum just wraps Two Sum in an outer loop. As it iterates through each value v, it finds all pairs whose sum is equal to target - v using one of these approaches:

Two Sum uses a hash set to check for a matching value.
Two Sum II uses the two pointers pattern in a sorted array.
Following a similar logic, we can implement 4Sum by wrapping 3Sum in another loop. But wait - there is a catch. If an interviewer asks you to solve 4Sum, they can follow-up with 5Sum, 6Sum, and so on. What they are really expecting at this point is a kSum solution. Therefore, we will focus on a generalized implementation here.

Approach 1: Two Pointers
Intuition

The two pointers pattern requires the array to be sorted, so we do that first. Also, it's easier to deal with duplicates if the array is sorted: repeated values are next to each other and easy to skip.

For 3Sum, we enumerate each value in a single loop, and use the two pointers pattern for the rest of the array. For kSum, we will have k - 2 nested loops to enumerate all combinations of k - 2 values.

Algorithm

We can implement k - 2 loops using a recursion. We will pass the starting point and k as the parameters. When k == 2, we will call twoSum, terminating the recursion.

For the main function:

Sort the input array nums.
Call kSum with start = 0, k = 4, and target, and return the result.
For kSum function:

At the start of the kSum function, we will check three conditions:
Have we run out of numbers to choose from?
Is the smallest number remaining greater than target / k?
If so, then any k numbers we choose will be too large.
Is the largest number remaining smaller than target / k?
If so, then any k numbers we choose will be too small.
If any of these conditions is true, there is no need to continue as no combination of the remaining elements can sum to target.
If k equals 2, call twoSum and return the result.
Iterate i through the array from start:
If the current value is the same as the one before, skip it.
Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i].
For each returned subset of values:
Include the current value nums[i] into subset.
Add subset to the result res.
Return the result res.
For twoSum function:

Set the low pointer lo to start, and high pointer hi to the last index.
While low pointer is smaller than high:
If the sum of nums[lo] and nums[hi] is less than target, increment lo.
Also increment lo if the value is the same as for lo - 1.
If the sum is greater than target, decrement hi.
Also decrement hi if the value is the same as for hi + 1.
Otherwise, we found a pair:
Add it to the result res.
Decrement hi and increment lo.
Return the result res.

Implementation
Typescript:
function fourSum(nums: number[], target: number): number[][] {
    nums.sort((a, b) => a - b);
    return kSum(nums, target, 0, 4);
}
function kSum(
    nums: number[],
    target: number,
    start: number,
    k: number,
): number[][] {
    let res: number[][] = [];
    // If we have run out of numbers to add, return res.
    if (start === nums.length) {
        return res;
    }
    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    let average_value = target / k;
    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
        return res;
    }
    if (k === 2) {
        return twoSum(nums, target, start);
    }
    for (let i = start; i < nums.length; i++) {
        if (i === start || nums[i - 1] !== nums[i]) {
            for (let subset of kSum(nums, target - nums[i], i + 1, k - 1)) {
                res.push([nums[i], ...subset]);
            }
        }
    }
    return res;
}
function twoSum(nums: number[], target: number, start: number): number[][] {
    let res: number[][] = [];
    let lo: number = start,
        hi: number = nums.length - 1;
    while (lo < hi) {
        let curr_sum: number = nums[lo] + nums[hi];
        if (curr_sum < target || (lo > start && nums[lo] === nums[lo - 1])) {
            ++lo;
        } else if (
            curr_sum > target ||
            (hi < nums.length - 1 && nums[hi] === nums[hi + 1])
        ) {
            --hi;
        } else {
            res.push([nums[lo++], nums[hi--]]);
        }
    }
    return res;
}

Python3:
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:

        def kSum(nums: List[int], target: int, k: int) -> List[List[int]]:
            res = []

            # If we have run out of numbers to add, return res.
            if not nums:
                return res

            # There are k remaining values to add to the sum. The
            # average of these values is at least target // k.
            average_value = target // k

            # We cannot obtain a sum of target if the smallest value
            # in nums is greater than target // k or if the largest
            # value in nums is smaller than target // k.
            if average_value < nums[0] or nums[-1] < average_value:
                return res

            if k == 2:
                return twoSum(nums, target)

            for i in range(len(nums)):
                if i == 0 or nums[i - 1] != nums[i]:
                    for subset in kSum(nums[i + 1 :], target - nums[i], k - 1):
                        res.append([nums[i]] + subset)

            return res

        def twoSum(nums: List[int], target: int) -> List[List[int]]:
            res = []
            lo, hi = 0, len(nums) - 1

            while lo < hi:
                curr_sum = nums[lo] + nums[hi]
                if curr_sum < target or (lo > 0 and nums[lo] == nums[lo - 1]):
                    lo += 1
                elif curr_sum > target or (
                    hi < len(nums) - 1 and nums[hi] == nums[hi + 1]
                ):
                    hi -= 1
                else:
                    res.append([nums[lo], nums[hi]])
                    lo += 1
                    hi -= 1

            return res

        nums.sort()
        return kSum(nums, target, 4)

Go:
func fourSum(nums []int, target int) [][]int {
    sort.Ints(nums)
    return kSum(nums, target, 0, 4)
}

func kSum(nums []int, target int, start int, k int) [][]int {
    res := [][]int{}
    // If we have run out of numbers to add, return res.
    if start == len(nums) {
        return res
    }
    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    average_value := target / k
    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if nums[start] > average_value || average_value > nums[len(nums)-1] {
        return res
    }
    if k == 2 {
        return twoSum(nums, target, start)
    }
    for i := start; i < len(nums); i++ {
        if i == start || nums[i-1] != nums[i] {
            for _, subset := range kSum(nums, target-nums[i], i+1, k-1) {
                res = append(res, append([]int{nums[i]}, subset...))
            }
        }
    }
    return res
}

func twoSum(nums []int, target int, start int) [][]int {
    res := [][]int{}
    lo := start
    hi := len(nums) - 1
    for lo < hi {
        curr_sum := nums[lo] + nums[hi]
        if curr_sum < target || (lo > start && nums[lo] == nums[lo-1]) {
            lo++
        } else if curr_sum > target || (hi < len(nums)-1 && nums[hi] == nums[hi+1]) {
            hi--
        } else {
            res = append(res, []int{nums[lo], nums[hi]})
            lo++
            hi--
        }
    }
    return res
}

Javascript:
var fourSum = function (nums, target) {
    nums.sort((a, b) => a - b);
    return kSum(nums, target, 0, 4);
};
function kSum(nums, target, start, k) {
    let res = [];
    // If we have run out of numbers to add, return res.
    if (start === nums.length) {
        return res;
    }
    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    let average_value = target / k;
    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
        return res;
    }
    if (k === 2) {
        return twoSum(nums, target, start);
    }
    for (let i = start; i < nums.length; i++) {
        if (i === start || nums[i - 1] !== nums[i]) {
            for (let subset of kSum(nums, target - nums[i], i + 1, k - 1)) {
                res.push([nums[i], ...subset]);
            }
        }
    }
    return res;
}
function twoSum(nums, target, start) {
    let res = [];
    let lo = start,
        hi = nums.length - 1;
    while (lo < hi) {
        let curr_sum = nums[lo] + nums[hi];
        if (curr_sum < target || (lo > start && nums[lo] === nums[lo - 1])) {
            ++lo;
        } else if (
            curr_sum > target ||
            (hi < nums.length - 1 && nums[hi] === nums[hi + 1])
        ) {
            --hi;
        } else {
            res.push([nums[lo++], nums[hi--]]);
        }
    }
    return res;
}

C#:
public class Solution {
    public IList<IList<int>> FourSum(int[] nums, int target) {
        Array.Sort(nums);
        return KSum(nums, target, 0, 4);
    }

    public IList<IList<int>> KSum(int[] nums, long target, int start, int k) {
        List<IList<int>> res = new List<IList<int>>();
        if (start == nums.Length) {
            return res;
        }

        long average_value = target / k;
        if (nums[start] > average_value ||
            average_value > nums[nums.Length - 1]) {
            return res;
        }

        if (k == 2) {
            return TwoSum(nums, target, start);
        }

        for (int i = start; i < nums.Length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                foreach (var subset in KSum(nums, target - nums[i], i + 1,
                                            k - 1)) {
                    var list = new List<int> { nums[i] };
                    list.AddRange(subset);
                    res.Add(list);
                }
            }
        }

        return res;
    }

    public IList<IList<int>> TwoSum(int[] nums, long target, int start) {
        List<IList<int>> res = new List<IList<int>>();
        int lo = start, hi = nums.Length - 1;
        while (lo < hi) {
            int curr_sum = nums[lo] + nums[hi];
            if (curr_sum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (curr_sum > target ||
                       (hi < nums.Length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.Add(new List<int> { nums[lo++], nums[hi--] });
            }
        }

        return res;
    }
}

Java:
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > average_value || average_value > nums[nums.length - 1]
        ) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (
                currSum > target ||
                (hi < nums.length - 1 && nums[hi] == nums[hi + 1])
            ) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }
}

C++:
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(begin(nums), end(nums));
        return kSum(nums, target, 0, 4);
    }

    vector<vector<int>> kSum(vector<int>& nums, long long target, int start,
                             int k) {
        vector<vector<int>> res;

        // If we have run out of numbers to add, return res.
        if (start == nums.size()) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums.back()) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.size(); ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (vector<int>& subset :
                     kSum(nums, static_cast<long long>(target) - nums[i], i + 1,
                          k - 1)) {
                    res.push_back({nums[i]});
                    res.back().insert(end(res.back()), begin(subset),
                                      end(subset));
                }
            }
        }

        return res;
    }

    vector<vector<int>> twoSum(vector<int>& nums, long long target, int start) {
        vector<vector<int>> res;
        int lo = start, hi = int(nums.size()) - 1;

        while (lo < hi) {
            int curr_sum = nums[lo] + nums[hi];
            if (curr_sum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (curr_sum > target ||
                       (hi < nums.size() - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.push_back({nums[lo++], nums[hi--]});
            }
        }

        return res;
    }
};


Complexity Analysis

Time Complexity: O(nk−1), or O(n3 ) for 4Sum. We have k−2 loops, and twoSum is O(n).

Note that for k>2, sorting the array does not change the overall time complexity.

Space Complexity: O(n). We need O(k) space for the recursion. k can be the same as n in the worst case for the generalized algorithm.

Note that, for the purpose of complexity analysis, we ignore the memory required for the output.

Approach 2: Hash Set
Intuition

Since elements must sum up to the exact target value, we can also use the Two Sum: One-pass Hash Table approach.

In 3Sum: Hash Set, we solved the problem without sorting the array. To do that, we needed to sort values within triplets, and track them in a hash set. Doing the same for k values could be impractical.

So, for this approach, we will also sort the array and skip duplicates the same way as in the Two Pointers approach above. Thus, the code will only differ in the twoSum implementation.

Algorithm

twoSum implementation here is almost the same as in Two Sum: One-pass Hash Table. The only difference is the check to avoid duplicates. Since the array is sorted, we can just compare the found pair with the last one in the result res.

Implementation

c++
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(begin(nums), end(nums));
        return kSum(nums, target, 0, 4);
    }

    vector<vector<int>> kSum(vector<int>& nums, long long target, int start,
                             int k) {
        vector<vector<int>> res;

        // If we have run out of numbers to add, return res.
        if (start == nums.size()) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums.back()) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.size(); ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (vector<int>& subset :
                     kSum(nums, static_cast<long>(target) - nums[i], i + 1,
                          k - 1)) {
                    res.push_back({nums[i]});
                    res.back().insert(end(res.back()), begin(subset),
                                      end(subset));
                }
            }
        }

        return res;
    }

    vector<vector<int>> twoSum(vector<int>& nums, long long target, int start) {
        vector<vector<int>> res;
        unordered_set<long long> s;

        for (int i = start; i < nums.size(); ++i) {
            if (res.empty() || res.back()[1] != nums[i]) {
                if (s.count(target - nums[i])) {
                    res.push_back({int(target - nums[i]), nums[i]});
                }
            }
            s.insert(nums[i]);
        }

        return res;
    }
};

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > average_value || average_value > nums[nums.length - 1]
        ) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList((int) target - nums[i], nums[i]));
                }
            }
            s.add((long) nums[i]);
        }

        return res;
    }
}

C#
public class Solution {
    public IList<IList<int>> FourSum(int[] nums, int target) {
        Array.Sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private IList<IList<int>> kSum(int[] nums, long target, int start, int k) {
        List<IList<int>> res = new List<IList<int>>();
        if (start == nums.Length) {
            return res;
        }

        long averageValue = target / k;
        if (nums[start] > averageValue ||
            averageValue > nums[nums.Length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.Length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                foreach (List<int> subset in kSum(nums, target - nums[i], i + 1,
                                                  k - 1)) {
                    List<int> temp = new List<int> { nums[i] };
                    temp.AddRange(subset);
                    res.Add(temp);
                }
            }
        }

        return res;
    }

    public IList<IList<int>> twoSum(int[] nums, long target, int start) {
        List<IList<int>> res = new List<IList<int>>();
        HashSet<long> s = new HashSet<long>();
        for (int i = start; i < nums.Length; ++i) {
            if (res.Count == 0 || res[res.Count - 1][1] != nums[i]) {
                if (s.Contains(target - nums[i])) {
                    res.Add(new List<int> { (int)target - nums[i], nums[i] });
                }
            }

            s.Add(nums[i]);
        }

        return res;
    }
}

Javascript
const fourSum = function (nums, target) {
    function twoSum(start, target) {
        let res = [];
        let s = new Set();
        for (let i = start; i < nums.length; i++) {
            if (res.length == 0 || res[res.length - 1][1] != nums[i]) {
                if (s.has(target - nums[i])) {
                    res.push([target - nums[i], nums[i]]);
                }
            }
            s.add(nums[i]);
        }
        return res;
    }
    function kSum(start, target, k) {
        let res = [];
        // If we have run out of numbers to add, return res.
        if (start === nums.length) {
            return res;
        }
        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        let averageValue = Math.floor(target / k);
        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > averageValue ||
            averageValue > nums[nums.length - 1]
        ) {
            return res;
        }
        if (k === 2) {
            return twoSum(start, target);
        }
        for (let i = start; i < nums.length; i++) {
            if (i === start || nums[i - 1] !== nums[i]) {
                kSum(i + 1, target - nums[i], k - 1).forEach((set) => {
                    res.push([nums[i]].concat(set));
                });
            }
        }
        return res;
    }
    nums.sort((a, b) => a - b);
    return kSum(0, target, 4);
};

Go:
func fourSum(nums []int, target int) [][]int {
    sort.Ints(nums)
    return kSum(nums, target, 0, 4)
}

func twoSum(nums []int, target int, start int) [][]int {
    res := make([][]int, 0)
    s := make(map[int]bool)
    for i := start; i < len(nums); i++ {
        if len(res) == 0 || res[len(res)-1][1] != nums[i] {
            if s[target-nums[i]] {
                res = append(res, []int{target - nums[i], nums[i]})
            }
        }
        s[nums[i]] = true
    }
    return res
}

func kSum(nums []int, target int, start int, k int) [][]int {
    res := make([][]int, 0)
    // If we have run out of numbers to add, return res.
    if start == len(nums) {
        return res
    }
    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    average_value := target / k
    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if nums[start] > average_value || average_value > nums[len(nums)-1] {
        return res
    }
    if k == 2 {
        return twoSum(nums, target, start)
    }
    for i := start; i < len(nums); i++ {
        if i == start || nums[i-1] != nums[i] {
            for _, subset := range kSum(nums, target-nums[i], i+1, k-1) {
                res = append(res, append([]int{nums[i]}, subset...))
            }
        }
    }
    return res
}

Python3:
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:

        def kSum(nums: List[int], target: int, k: int) -> List[List[int]]:
            res = []

            # If we have run out of numbers to add, return res.
            if not nums:
                return res

            # There are k remaining values to add to the sum. The
            # average of these values is at least target // k.
            average_value = target // k

            # We cannot obtain a sum of target if the smallest value
            # in nums is greater than target // k or if the largest
            # value in nums is smaller than target // k.
            if average_value < nums[0] or nums[-1] < average_value:
                return res

            if k == 2:
                return twoSum(nums, target)

            for i in range(len(nums)):
                if i == 0 or nums[i - 1] != nums[i]:
                    for subset in kSum(nums[i + 1 :], target - nums[i], k - 1):
                        res.append([nums[i]] + subset)

            return res

        def twoSum(nums: List[int], target: int) -> List[List[int]]:
            res = []
            s = set()

            for i in range(len(nums)):
                if len(res) == 0 or res[-1][1] != nums[i]:
                    if target - nums[i] in s:
                        res.append([target - nums[i], nums[i]])
                s.add(nums[i])

            return res

        nums.sort()
        return kSum(nums, target, 4)

Typescript:
function fourSum(nums: number[], target: number): number[][] {
    function twoSum(start: number, target: number): number[][] {
        let res = [];
        let s = new Set<number>();
        for (let i = start; i < nums.length; i++) {
            if (res.length == 0 || res[res.length - 1][1] != nums[i]) {
                if (s.has(target - nums[i])) {
                    res.push([target - nums[i], nums[i]]);
                }
            }
            s.add(nums[i]);
        }
        return res;
    }
    function kSum(start: number, target: number, k: number): number[][] {
        let res = [];
        // If we have run out of numbers to add, return res.
        if (start === nums.length) {
            return res;
        }
        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        let averageValue = Math.floor(target / k);
        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > averageValue ||
            averageValue > nums[nums.length - 1]
        ) {
            return res;
        }
        if (k === 2) {
            return twoSum(start, target);
        }
        for (let i = start; i < nums.length; i++) {
            if (i === start || nums[i - 1] !== nums[i]) {
                kSum(i + 1, target - nums[i], k - 1).forEach((set) => {
                    res.push([nums[i]].concat(set));
                });
            }
        }
        return res;
    }
    nums.sort((a, b) => a - b);
    return kSum(0, target, 4);
}

Complexity Analysis

Time Complexity: O(nk−1 ), or O(n3 ) for 4Sum. We have k−2 loops iterating over n elements, and twoSum is O(n).

Note that for k>2, sorting the array does not change the overall time complexity.

Space Complexity: O(n) for the hash set. The space needed for the recursion will not exceed O(n).
     */
}
