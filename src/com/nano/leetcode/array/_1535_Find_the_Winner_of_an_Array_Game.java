package com.nano.leetcode.array;

/*
1535. Find the Winner of an Array Game
Medium

1171

54

Add to List

Share
Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.



Example 1:

Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation: Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
Example 2:

Input: arr = [3,2,1], k = 10
Output: 3
Explanation: 3 will win the first 10 rounds consecutively.


Constraints:

2 <= arr.length <= 105
1 <= arr[i] <= 106
arr contains distinct integers.
1 <= k <= 109
 */
public class _1535_Find_the_Winner_of_an_Array_Game {
    // MY SOLUTION
    public int getWinner(int[] arr, int k) {
        int count=0;
        int n = arr.length;
        int i=1;
        while(true){
            if(i==n)// Handles testcase [3,2,1] 10 --> 10 times win with 3 elements so start from 1
                i=1;
            if(arr[0]>arr[i]){
                count++;
                if(count==k)
                    return arr[0];
                i++;
            }
            else{
                count=1;
                if(count==k) // this will handle k==1 case
                    return arr[i];
                swap(0,i,arr);
                i++;
            }
        }
        //return 0;
    }

    private void swap(int i, int j, int[] arr){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}

/*
Approach 1: Simulate Process With Queue
Intuition

We have an interesting game here. Let's try to fully understand it so that we can simulate it.

In each round, two players face each other. The player with a larger value wins.
The problem states that arr has distinct integers, so we don't need to worry about tiebreaks.
The game ends when someone wins k rounds in a row.
The game starts between the first two elements of arr. The other elements of arr represent a line.
After each round, the next round is played between the winner and the next player in line.
The loser goes to the end of the line.
The functionality of a line can be implemented using a queue. We remove from the front of the queue to determine the next player, and we add to the back of the queue when a player loses. Using a queue and some integers, we can simulate the game.

Let curr represent the winner of the most recent round. Initially, curr = arr[0].
Let winstreak represent the winstreak of the current player. Initially, winstreak = 0.
Let queue represent the line. Initially, queue holds all the elements of arr in order, except for the first element.
Now, let's simulate the game. At each round:

Remove from the front of queue and let this value be opponent.
If curr > opponent, the current player wins. Add opponent to the back of queue and increment winstreak.
Otherwise, opponent wins. Add curr to the back of queue, update curr = opponent, and set winstreak = 1.
If winstreak = k, the current player has won k rounds in a row. We can return curr.
Current
1 / 7
This simulation process works, but there is an issue. If we examine the constraints, we find that
�
k can be up to 1 billion! If we tried to simulate a billion rounds, we would exceed the time limit. How do we solve this?

We can make another observation: let the player with the largest value in arr be maxElement. Since the elements in the array are all unique, this player will never lose a round, so if the current player ever becomes maxElement, it will surely end up winning so many games as long as the simulation continues, no matter how large the required k is. Thus, if curr = maxElement, we can immediately return curr without actually simulating all the games, because we know that all future games will result in curr winning!

Algorithm

Initialize:
maxElement as the maximum element in arr.
queue as a queue with every element in arr except the first one.
curr = arr[0].
winstreak = 0.
While queue is not empty (could also do while True):
Pop opponent from the front of queue.
If curr > opponent:
Push opponent to the back of queue.
Increment winstreak.
Else:
Push curr to the back of queue.
Set curr = opponent.
Set winstreak = 1.
If winstreak = k or curr = maxElement, return curr.
The code should never reach this point since there is guaranteed to be a winner. Return anything.
Implementation
class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        max_element = max(arr)
        queue = deque(arr[1:])
        curr = arr[0]
        winstreak = 0

        while queue:
            opponent = queue.popleft()
            if curr > opponent:
                queue.append(opponent)
                winstreak += 1
            else:
                queue.append(curr)
                curr = opponent
                winstreak = 1

            if winstreak == k or curr == max_element:
                return curr

class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            queue.offer(arr[i]);
        }

        int curr = arr[0];
        int winstreak = 0;

        while (!queue.isEmpty()) {
            int opponent = queue.poll();

            if (curr > opponent) {
                queue.offer(opponent);
                winstreak++;
            } else {
                queue.offer(curr);
                curr = opponent;
                winstreak = 1;
            }

            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }

        return -1;
    }
}

Complexity Analysis

Given
�
n as the length of arr,

Time complexity:
�
(
�
)
O(n)

We spend
�
(
�
)
O(n) to find maxElement and to initialize queue.

Then, we perform a while loop. Each iteration of the while loop costs
�
(
1
)
O(1). The number of iterations is limited to
�
(
�
)
O(n), since we visit the elements of arr in order and terminate if we find maxElement. Thus, the while loop costs up to
�
(
�
)
O(n).

Note that the value of
�
k is not relevant. If
�
<
�
k<n, then it wouldn't change the time complexity. If
�
>
�
k>n, we would terminate before
�
k operations anyway, as we must find maxElement within
�
n rounds.

Space complexity:
�
(
�
)
O(n)

queue has a size of
�
(
�
)
O(n).


Approach 2: No Queue
Intuition

Each player that is not maxElement has two possibilities:

They come after maxElement in arr.
They come before maxElement in arr.
If a player comes after maxElement, they will not play any rounds in our simulation, since we immediately terminate upon finding maxElement.

If a player comes before maxElement and loses, they will move to the back of the line behind maxElement. This means they will never appear in the simulation again, because maxElement will play before them, and we immediately terminate the simulation once maxElement plays.

Thus, in our simulation, when a player loses, they never play again. That means we don't actually need the queue to maintain their positions at all! We can simply use a for loop to iterate over the opponents while implementing the same simulation.

Algorithm

Initialize:
maxElement as the maximum element in arr.
curr = arr[0].
winstreak = 0.
Iterate i over the indices of arr, starting from 1:
Set opponent = arr[i].
If curr > opponent:
Increment winstreak.
Else:
Set curr = opponent.
Set winstreak = 1.
If winstreak = k or curr = maxElement, return curr.
The code should never reach this point since we would surely find maxElement. Return anything.
Implementation
class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }

        int curr = arr[0];
        int winstreak = 0;

        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];

            if (curr > opponent) {
                winstreak++;
            } else {
                curr = opponent;
                winstreak = 1;
            }

            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }

        return -1;
    }
}

class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        max_element = max(arr)
        curr = arr[0]
        winstreak = 0

        for i in range(1, len(arr)):
            opponent = arr[i]
            if curr > opponent:
                winstreak += 1
            else:
                curr = opponent
                winstreak = 1

            if winstreak == k or curr == max_element:
                return curr

Complexity Analysis

Given
�
n as the length of arr,

Time complexity:
�
(
�
)
O(n)

We spend
�
(
�
)
O(n) to find maxElement.

Then, we perform a for loop over the indices of arr. Each iteration costs
�
(
1
)
O(1), so this loop costs
�
(
�
)
O(n) in total.

Space complexity:
�
(
1
)
O(1)

We are only using a few integer variables.
 */