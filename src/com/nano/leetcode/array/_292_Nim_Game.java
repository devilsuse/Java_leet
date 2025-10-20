package com.nano.leetcode.array;

/*
292. Nim Game
Easy

You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.



Example 1:

Input: n = 4
Output: false
Explanation: These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.
Example 2:

Input: n = 1
Output: true
Example 3:

Input: n = 2
Output: true


Constraints:

1 <= n <= 231 - 1
 */
public class _292_Nim_Game {

    /*
    Python:

    class Solution(object):
    def canWinNim(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n%4!=0


     Gemini Chat solution analysis:
     This problem is a classic example of an impartial game that can be solved by finding losing positions
     (L-positions)—the states from which the current player loses if the opponent plays optimally.Here is the
     thinking process to arrive at the solution:1. Analyze Small Cases (Pattern Recognition)The core idea is to
     see which pile sizes are "safe" (losing) for the current player, assuming optimal play. A position is an
     L-position if every possible move leads to an opponent's winning position (W-position).Stones (n)Possible
     Next StatesOutcomeReason (for current player)1$\rightarrow 0$Win (W)Takes 1, wins immediately.2$\rightarrow 1, 0$Win (W)Takes 2, wins immediately.3$\rightarrow 2, 1, 0$Win (W)Takes 3, wins immediately.4$\rightarrow 3, 2, 1$Lose (L)Every move leaves the opponent with 1, 2, or 3 stones. The opponent wins from any of these states.5$\rightarrow 4, 3, 2$Win (W)Can move to $n=4$ (an L-position for the opponent).6$\rightarrow 5, 4, 3$Win (W)Can move to $n=4$ (an L-position for the opponent).7$\rightarrow 6, 5, 4$Win (W)Can move to $n=4$ (an L-position for the opponent).8$\rightarrow 7, 6, 5$Lose (L)Every move leaves the opponent with a W-position (5, 6, or 7).2. Identify the Critical PatternListing the outcomes reveals a strong pattern:n123456789101112...OutcomeWWWLWWWLWWWL...The losing positions are all multiples of 4: $\{4, 8, 12, \dots, 4k\}$.The hypothesis is: The current player loses if and only if the number of stones $n$ is divisible by 4.3. Formulate the Optimal Strategy (Proof)The maximum number of stones a player can remove is 3, and the minimum is 1. This means that in one move, a player can change the pile size by 1, 2, or 3.Case A: $n$ is a Multiple of 4 ($n = 4k$)You move first and remove $m \in \{1, 2, 3\}$ stones.The remaining pile size $n' = 4k - m$.$n'$ will never be a multiple of 4, as $4k-1$, $4k-2$, and $4k-3$ all have remainders of 3, 2, or 1, respectively.Since you cannot leave your opponent with a multiple of 4, the opponent is now in a Winning Position (Case B), and you are in a Losing Position.Case B: $n$ is NOT a Multiple of 4 ($n = 4k + r$, where $r \in \{1, 2, 3\}$)You move first and remove exactly $r$ stones.If $n=4k+1$, you take 1 stone.If $n=4k+2$, you take 2 stones.If $n=4k+3$, you take 3 stones.The remaining pile size is $n' = (4k + r) - r = 4k$.You have successfully left your opponent with a pile size that is a multiple of 4 (an L-Position).By always forcing the opponent into a multiple of 4, you guarantee that you will eventually take the last stone, making the starting position a Winning Position.4. Final Conclusion and ImplementationThe starting player can always win if the number of stones $n$ is not a multiple of 4.The problem asks if you (the starting player) can win, so the answer is true if $n \pmod 4 \neq 0$, and false if $n \pmod 4 = 0$.Pythondef canWinNim(n: int) -> bool:
    # If the number of stones is a multiple of 4, the starting player loses.
    # Otherwise, the starting player can always win.
    return n % 4 != 0
     */
}
