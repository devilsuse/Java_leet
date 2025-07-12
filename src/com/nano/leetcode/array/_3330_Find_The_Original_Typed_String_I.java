package com.nano.leetcode.array;

/*
3330. Find the Original Typed String I
Easy
Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.

You are given a string word, which represents the final output displayed on Alice's screen.

Return the total number of possible original strings that Alice might have intended to type.

Example 1:

Input: word = "abbcccc"

Output: 5

Explanation:

The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

Example 2:

Input: word = "abcd"

Output: 1

Explanation:

The only possible string is "abcd".

Example 3:

Input: word = "aaaa"

Output: 4

 Constraints:

1 <= word.length <= 100
word consists only of lowercase English letters.

 */
public class _3330_Find_The_Original_Typed_String_I {

    public int possibleStringCount(String word) {
        int count = 1;
        for(int i=0;i<word.length();){
            int j=i+1;
            while(j<word.length() && word.charAt(i) == word.charAt(j)){
                j++;
                count++;
            }
            i=j;
        }

        return count;
    }

    /*
    Approach: One-time Traversal
Intuition
If a character in word appears consecutively k times (where k>1), and Alice makes a mistake in this part, then in the actual original string, this character could have appeared 1,2,…,k−1 times. That is, there are k−1 possible variations.

For the case k=1, Alice will not make a mistake, so there are 0 possibilities, which is consistent with the formula k−1.

Therefore, we can traverse the string once: let the current traversal position be l, and suppose the characters in word from positions [l,r] are the same, while the character at position r+1 is different (or does not exist). In this case, we increase the answer by r−l, and continue traversing from position r+1.

This further implies that the total contribution of the interval [l,r] to the answer is r−l. We can interpret this as position l not contributing to the answer, while each of the positions [l+1,r] contributes 1. Therefore, for any position i in the string word (where i>0), if word[i−1]=word[i], we can increase the answer by 1.

Java
class Solution {

    public int possibleStringCount(String word) {
        int n = word.length(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++ans;
            }
        }
        return ans;
    }
}

Go
func possibleStringCount(word string) int {
	n, ans := len(word), 1
	for i := 1; i < n; i++ {
		if word[i-1] == word[i] {
			ans++
		}
	}
	return ans
}

func possibleStringCount(word string) int {
	n, ans := len(word), 1
	for i := 1; i < n; i++ {
		if word[i-1] == word[i] {
			ans++
		}
	}
	return ans
}

Rust
func possibleStringCount(word string) int {
	n, ans := len(word), 1
	for i := 1; i < n; i++ {
		if word[i-1] == word[i] {
			ans++
		}
	}
	return ans
}

Type
function possibleStringCount(word: string): number {
    let n = word.length,
        ans = 1;
    for (let i = 1; i < n; ++i) {
        if (word[i - 1] === word[i]) {
            ++ans;
        }
    }
    return ans;
}

C#
public class Solution {
    public int PossibleStringCount(string word) {
        int n = word.Length, ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word[i - 1] == word[i]) {
                ++ans;
            }
        }
        return ans;
    }
}

C
int possibleStringCount(char* word) {
    int n = strlen(word), ans = 1;
    for (int i = 1; i < n; ++i) {
        if (word[i - 1] == word[i]) {
            ++ans;
        }
    }
    return ans;
}

c++
class Solution {
public:
    int possibleStringCount(string word) {
        int n = word.size(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word[i - 1] == word[i]) {
                ++ans;
            }
        }
        return ans;
    }
};








     */

}
