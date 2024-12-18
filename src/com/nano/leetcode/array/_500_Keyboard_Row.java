package com.nano.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 500. Keyboard Row
 * Easy
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 *
 * Example 1:
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 * Example 2:
 *
 * Input: words = ["omk"]
 * Output: []
 * Example 3:
 *
 * Input: words = ["adsdf","sfd"]
 * Output: ["adsdf","sfd"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] consists of English letters (both lowercase and uppercase).
 */
public class _500_Keyboard_Row {
    private final String[] keyRows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word: words){
            String s = word.toLowerCase();
            int row=-1;

            for(int i=0;i<s.length();i++){
                if(i==0){
                    for(int j=0;j<keyRows.length;j++){
                        if(keyRows[j].indexOf((char)s.charAt(i))>=0){
                            row=j;
                            break;
                        }
                    }
                }
                else{
                    if(keyRows[row].indexOf((char)s.charAt(i))==-1){
                        break;
                    }
                }
                if(i==s.length()-1)
                    result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
