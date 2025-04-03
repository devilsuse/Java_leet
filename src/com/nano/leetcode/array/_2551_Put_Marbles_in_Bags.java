package com.nano.leetcode.array;

/*
You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.

Divide the marbles into the k bags according to the following rules:

No bag is empty.
If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
The score after distributing the marbles is the sum of the costs of all the k bags.

Return the difference between the maximum and minimum scores among marble distributions.

Example 1:

Input: weights = [1,3,5,1], k = 2
Output: 4
Explanation:
The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6.
The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10.
Thus, we return their difference 10 - 6 = 4.
Example 2:

Input: weights = [1, 3], k = 2
Output: 0
Explanation: The only distribution possible is [1],[3].
Since both the maximal and minimal score are the same, we return 0.


Constraints:

1 <= k <= weights.length <= 105
1 <= weights[i] <= 109
 */

import java.util.Arrays;

public class _2551_Put_Marbles_in_Bags {

    // Best explanation https://www.youtube.com/watch?v=RyJpH8cghrE

    //MINE
    public long putMarbles(int[] weights, int k) {
        int l = weights.length;
        long[] costArr = new long[l-1];
        for(int i=1;i<l;i++){
            //int cost=weight[i]+weight[i-1];
            costArr[i-1]=weights[i]+weights[i-1];
        }
        Arrays.sort(costArr);
        long max=0, min=0;
        for(int i=0;i<k-1;i++){ // for min take first k-1 elements sum & for Max last k sum
            min+=costArr[i];
            max+=costArr[l-2-i];
        }
        return max-min;
    }

    /*

        public long putMarbles(int[] weights, int k) {
            // We collect and sort the value of all n - 1 pairs.
            int n = weights.length;
            int[] pairWeights = new int[n - 1];
            for (int i = 0; i < n - 1; ++i) {
                pairWeights[i] = weights[i] + weights[i + 1];
            }
            // We will sort only the first (n - 1) elements of the array.
            Arrays.sort(pairWeights, 0, n - 1);

            // Get the difference between the largest k - 1 values and the
            // smallest k - 1 values.
            long answer = 0l;
            for (int i = 0; i < k - 1; ++i) {
                answer += pairWeights[n - 2 - i] - pairWeights[i];
            }

            return answer;
        }

        def putMarbles(self, weights: List[int], k: int) -> int:
        # We collect and sort the value of all n - 1 pairs.
        n = len(weights)
        pairWeights = [weights[i] + weights[i + 1] for i in range(n - 1)]

        # Since python's sort function sorts the whole list, we don't limit it to the first n-1 elements here.
        pairWeights.sort()

        # Get the difference between the largest k - 1 values and the smallest k - 1 values.
        answer = 0
        for i in range(k - 1):
            answer += pairWeights[n - 2 - i] - pairWeights[i]

        return answer

        class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.size();
        vector<int> pairWeights(n - 1, 0);
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] += weights[i] + weights[i + 1];
        }

        sort(pairWeights.begin(), pairWeights.end());

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long long answer = 0;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
};
    */

    /*
    Solution
Overview
As shown in the picture below, we put 4 marbles in k = 2 bags.

img

There are several ways to split marbles into two bags, we have shown two of them that bring the maximum cost 10 and the minimum cost 6. Therefore the difference between them is 10 - 6 = 4.

Approach: Sorting
Intuition
Let's start with a brute-force approach. Since we are looking for the maximum score and the minimum score, we shall try iterating over all possible splits. Splitting n marbles into k consecutive groups is a typical sticks-and-stones problem that has as many as (
k
n
​
 )=
k!(n−k)!
n!
​
  solutions, thus it is impractical to iterate over all possibilities.

We might also think of using dynamic programming to solve the subproblem (x, y): splitting previous x marbles into y bags, then moving on to the next larger subproblem (x + 1, y) or (x, y + 1), until we reach the best solution of the entire problem (n, k). However, given the size of the input array and the maximum value of k, dynamic programming brings at most O(n
2
 ) time thus it won't pass the time limit.


Let's shift our thinking a bit. Instead of focusing on how to partition the array of marbles, let's now focus on the boundary of each subarray, the splitting point and try to find the relation between the score and these splitting points.

In the picture below, we split the array into 4 subarrays (shown in different colors) and resulting in 3 splitting points, each of which is made of 2 adjacent ends.

What is the score of this split?

Since the score of a subarray only matters with its two ends, we can tell that the total score equals the sum of the first element, the last element, and the sum of every pair (two adjacent ends at each split).

img


In general, if we partition the array into k groups, we always make k - 1 splitting points regardless of how the array is partitioned.

img


Now we know how to find the maximum score, by finding the sum of the largest k - 1 pairs. Similarly, we can get the minimum score by finding the sum of the smallest k - 1 pairs. This can be done by collecting every pair sum in an array pairWeights and sorting them.

img

MaxScore=weights[0]+weights[n−1]+∑
i=n−k
n−1
​
 pairWeights[i] (if sorted the array pairWeights in non-decreasing order)

MinScore=weights[0]+weights[n−1]+∑
i=0
k−2
​
 pairWeights[i]

Then we have the difference between them as answer=MaxScore - MinScore
=∑
i=n−k
n−1
​
 pairWeights[i]−∑
i=0
k−2
​
 pairWeights[i]


Algorithm
Initialize n as the size of the weights array.
Create a array pairWeights of size n - 1 to store sums of adjacent pairs.
Iterate over weights:
For each pair of adjacent elements, store their sum in pairWeights.
Sort the pairWeights array in ascending order.
Initialize answer as 0 to store the difference between max and min sums.
Iterate over the first and last k - 1 elements of pairWeights:
Add the difference between the largest k - 1 sums and smallest k - 1 sums to answer.
Return answer as the result.
Implementation

Complexity Analysis
Let n be the size of the weights array.

Time complexity: O(nlogn)

The first loop iterates over the weights array to compute the pairWeights array, which takes O(n) time. Sorting the pairWeights array takes O(nlogn) time.

The final loop iterates over the first k−1 elements of the sorted pairWeights array, which takes O(k) time. Since k can be at most n, this loop is O(n) in the worst case.

Therefore, the overall time complexity is dominated by the sorting step, resulting in O(nlogn).

Space complexity: O(n+S)≈O(n)

The pairWeights array stores n−1 elements, which requires O(n) space.

The space taken by the sorting algorithm (S) depends on the language of implementation:

In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(logn).
In C++, the sort() function is implemented as a hybrid of Quick Sort, Heap Sort, and Insertion Sort, with a worst-case space complexity of O(logn).
In Python, the sort() method sorts a list using the Timsort algorithm which is a combination of Merge Sort and Insertion Sort and has a space complexity of O(n).
All other variables used by the algorithm take constant space. Thus, the space complexity is O(n+S)≈O(n).
     */

}

/*

 */