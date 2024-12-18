package com.nano.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
1441. Build an Array With Stack Operations
Medium

851

433

Add to List

Share
You are given an integer array target and an integer n.

You have an empty stack with the two following operations:

"Push": pushes an integer to the top of the stack.
"Pop": removes the integer on the top of the stack.
You also have a stream of the integers in the range [1, n].

Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:

If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
If the stack is not empty, pop the integer at the top of the stack.
If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.



Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation: Initially the stack s is empty. The last element is the top of the stack.
Read 1 from the stream and push it to the stack. s = [1].
Read 2 from the stream and push it to the stack. s = [1,2].
Pop the integer on the top of the stack. s = [1].
Read 3 from the stream and push it to the stack. s = [1,3].
Example 2:

Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]
Explanation: Initially the stack s is empty. The last element is the top of the stack.
Read 1 from the stream and push it to the stack. s = [1].
Read 2 from the stream and push it to the stack. s = [1,2].
Read 3 from the stream and push it to the stack. s = [1,2,3].
Example 3:

Input: target = [1,2], n = 4
Output: ["Push","Push"]
Explanation: Initially the stack s is empty. The last element is the top of the stack.
Read 1 from the stream and push it to the stack. s = [1].
Read 2 from the stream and push it to the stack. s = [1,2].
Since the stack (from the bottom to the top) is equal to target, we stop the stack operations.
The answers that read integer 3 from the stream are not accepted.


Constraints:

1 <= target.length <= 100
1 <= n <= 100
1 <= target[i] <= n
target is strictly increasing.
 */
public class _1441_Build_an_Array_With_Stack_Operations {
        public List<String> buildArray(int[] target, int n) {
            List<String> result = new ArrayList<>();
            int j=0;
            for(int i=1;i<=n;i++){
                if(j==target.length){
                    break;
                }
                if(i==target[j]){
                    result.add("Push");
                    j++;
                }
                else{
                    result.add("Push");
                    result.add("Pop");
                }
            }
            return result;
        }
}

/*
Approach: Simulate
        Intuition

        In this problem, we are given two stack operations:

        Push a number to the stack
        Pop off the top of the stack
        The numbers that we push to the stack are ordered from 1 to n. Each number is available only once, so if we pop a number from the stack, that number is permanently gone. This means we want to pop every number that does not appear in target and should never pop any number that does appear in target.

        We stop once the stack is equal to target and we are allowed to return any valid answer. Because target is always sorted and the stream of numbers always comes in ascending order, we can build target one element at a time, starting with the first element.

        Let's use an integer i that represents the most recently pushed number. Initially, i = 0 as no numbers have been pushed yet.

        example

        In this example, the first number we need to reach in target is 3. Before we can reach 3, we need to go through 1, 2. However, we don't want either 1 or 2 in the answer, so we can immediately pop 1 after pushing it, and pop 2 after pushing it. Essentially, we are only pushing them to move forward until we reach 3.

        example

        example

        Now, we are ready to push 3, so we do so.

        example

        To get to the next number 6, we must first go through 4, 5. Again, we don't want either 4 or 5 in the answer, so we can immediately pop 4 after pushing it, and pop 5 after pushing it.

        example

        example

        Now, we are ready to push 6, so we do so.

        example

        We continue this process for each number in target. This brings us to our solution. We iterate over each num in target:

        We push and immediately pop the current number, then increment i, and repeat the process until we are ready to push num.
        When are we ready to push num? Recall that i represents the most recently pushed number. Thus, we are ready to push num when the most recently pushed number is i = num - 1.
        Once we are ready, we simply push and increment i.
        Algorithm

        Initialize the answer ans and the integer i = 0.
        For each num in target:
        While i < num - 1:
        Add "Push" to ans.
        Add "Pop" to ans.
        Increment i.
        Add "Push" to ans.
        Increment i.
        Return ans.
        Implementation

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        int i = 0;

        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }

            ans.add("Push");
            i++;
        }

        return ans;
    }
}

class Solution:
        def buildArray(self, target: List[int], n: int) -> List[str]:
        ans = []
        i = 0

        for num in target:
        while i < num - 1:
        ans.append("Push")
        ans.append("Pop")
        i += 1

        ans.append("Push")
        i += 1

        return ans

        Complexity Analysis

        Time complexity:
        �
        (
        �
        )
        O(n)

        Let k denote the largest (final) element in target. We push (and maybe pop) every number from 1 until k. This gives us a maximum of
        2
        �
        2k operations. In the worst case scenario, k = n, which gives us a time complexity of
        �
        (
        �
        )
        O(n).

        Space complexity:
        �
        (
        1
        )
        O(1)

        We don't count the answer as part of the space complexity. Thus, we aren't using any extra space other than the integer i.

 */