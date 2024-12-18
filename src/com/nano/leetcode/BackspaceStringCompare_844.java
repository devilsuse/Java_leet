package com.nano.leetcode;

import java.util.Stack;

public class BackspaceStringCompare_844 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bbcd";
        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = removeBackspace(s);
        Stack<Character> s2 = removeBackspace(t);
        if(s1.size()!=s2.size())
            return false;
        int i=0;
        int l=s1.size();
        while(i<l){ ///Initially I had cond -> i<s1.size() which wasted my 30 mins... As we are popping size is dynamic so it cann't it used like that.
            if(s1.pop()!=s2.pop())
               return false;
            i++;
        }
        return true;
    }

    private static Stack<Character> removeBackspace(String s){
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int l = s.length();
        while(i<l){
            while(i<l && s.charAt(i)=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                i++;
            }
            if(i<l){
                stack.push(s.charAt(i));
                i++;
            }
        }
        return stack;
    }

}

/*
Approach #1: Build String [Accepted]
Intuition

Let's individually build the result of each string (build(S) and build(T)), then compare if they are equal.

Algorithm

To build the result of a string build(S), we'll use a stack based approach, simulating the result of each keystroke.
class Solution(object):
    def backspaceCompare(self, S, T):
        def build(S):
            ans = []
            for c in S:
                if c != '#':
                    ans.append(c)
                elif ans:
                    ans.pop()
            return "".join(ans)
        return build(S) == build(T)

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}

Complexity Analysis

Time Complexity: O(M+N)O(M + N)O(M+N), where M,NM, NM,N are the lengths of S and T respectively.

Space Complexity: O(M+N)O(M + N)O(M+N).

Approach #2: Two Pointer [Accepted]
Intuition

When writing a character, it may or may not be part of the final string depending on how many backspace keystrokes occur in the future.

If instead we iterate through the string in reverse, then we will know how many backspace characters we have seen, and therefore whether the result includes our character.

Algorithm

Iterate through the string in reverse. If we see a backspace character, the next non-backspace character is skipped. If a character isn't skipped, it is part of the final answer.

See the comments in the code for more details.
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}

class Solution(object):
    def backspaceCompare(self, S, T):
        def F(S):
            skip = 0
            for x in reversed(S):
                if x == '#':
                    skip += 1
                elif skip:
                    skip -= 1
                else:
                    yield x

        return all(x == y for x, y in itertools.izip_longest(F(S), F(T)))

Complexity Analysis

Time Complexity: O(M+N)O(M + N)O(M+N), where M,NM, NM,N are the lengths of S and T respectively.

Space Complexity: O(1)O(1)O(1).

 */
