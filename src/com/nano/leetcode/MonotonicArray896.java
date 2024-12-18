package com.nano.leetcode;

/*
896. Monotonic Array
Easy
2.8K
85
company
Amazon
company
TikTok
company
Facebook
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.
Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false
Constraints:
1 <= nums.length <= 105
-105 <= nums[i] <= 105
 */
//My solution
public class MonotonicArray896 {
    public boolean isMonotonic(int[] a) {
        if(a.length==1)
            return true;
        int i=1;
        int n = a.length;
        while(i<n && a[i-1]==a[i]){
            i++;
        }
        if(i==n){
            return true;
        }
        if(a[i-1]<a[i]){
            for(i=i+1;i<n;i++){
                if(a[i-1]>a[i])
                    return false;
            }
        }
        else{
            for(i=i+1;i<n;i++){
                if(a[i-1]<a[i])
                    return false;
            }
        }
        return true;
    }
}

/*
Approach 1: Two Pass
Intuition

An array is monotonic if it is monotone increasing, or monotone decreasing. Since a <= b and b <= c implies a <= c, we only need to check adjacent elements to determine if the array is monotone increasing (or decreasing, respectively). We can check each of these properties in one pass.

Algorithm

To check whether an array A is monotone increasing, we'll check A[i] <= A[i+1] for all i. The check for monotone decreasing is similar.

class Solution {
    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] > A[i+1]) return false;
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] < A[i+1]) return false;
        return true;
    }
}

class Solution(object):
    def isMonotonic(self, A):
        return (all(A[i] <= A[i+1] for i in xrange(len(A) - 1)) or
                all(A[i] >= A[i+1] for i in xrange(len(A) - 1)))

Complexity Analysis

Time Complexity: O(N)O(N)O(N), where NNN is the length of A.

Space Complexity: O(1)O(1)O(1).



Approach 2: One Pass
Intuition

To perform this check in one pass, we want to handle a stream of comparisons from {−1,0,1}\{-1, 0, 1\}{−1,0,1}, corresponding to <, ==, or >. For example, with the array [1, 2, 2, 3, 0], we will see the stream (-1, 0, -1, 1).

Algorithm

Keep track of store, equal to the first non-zero comparison seen (if it exists.) If we see the opposite comparison, the answer is False.

Otherwise, every comparison was (necessarily) in the set {−1,0}\{-1, 0\}{−1,0}, or every comparison was in the set {0,1}\{0, 1\}{0,1}, and therefore the array is monotonic.
class Solution(object):
    def isMonotonic(self, A):
        store = 0
        for i in xrange(len(A) - 1):
            c = cmp(A[i], A[i+1])
            if c:
                if c != store != 0:
                    return False
                store = c
        return True

class Solution {
    public boolean isMonotonic(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }
}

Complexity Analysis

Time Complexity: O(N)O(N)O(N), where NNN is the length of A.

Space Complexity: O(1)O(1)O(1).



Approach 3: One Pass (Simple Variant)
Intuition and Algorithm

To perform this check in one pass, we want to remember if it is monotone increasing or monotone decreasing.

It's monotone increasing if there aren't some adjacent values A[i], A[i+1] with A[i] > A[i+1], and similarly for monotone decreasing.

If it is either monotone increasing or monotone decreasing, then A is monotonic.
class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}

class Solution(object):
    def isMonotonic(self, A):
        increasing = decreasing = True

        for i in xrange(len(A) - 1):
            if A[i] > A[i+1]:
                increasing = False
            if A[i] < A[i+1]:
                decreasing = False

        return increasing or decreasing

Complexity Analysis

Time Complexity: O(N)O(N)O(N), where NNN is the length of A.

Space Complexity: O(1)O(1)O(1).
*/