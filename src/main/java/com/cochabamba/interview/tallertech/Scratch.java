package com.cochabamba.interview.tallertech;

// Given a string, find the length of the longest substring without repeating characters.
// Input: "abcabcbb"
// Output: 3

// Input: "abcaaa"
// Output: 3

// Input: "abcabcdbb"
// Output: 4


//TASK: Given a string, find the length of the longest substring without repeating characters.
//// Example Input: s = "abcabcdbb"
//        In this example, you’ll find 4 substrings (or subsets of characters) without any repeating characters. These are “abc”, “abcd”, “b”, “b”. The longest is “abcd”, so the answer is 4.
//        Another example:
//// Example Input: s = "pwwkew"
//        The longest substring is “wke”, so the answer is 3.
import java.util.*;

class Scratch {

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        char ss[] = s.toCharArray();
        String tmp = new String("");
        for(int i=0;i<ss.length;i++)    {
            if(!tmp.contains(String.valueOf(ss[i]))) {
                tmp=tmp+ss[i];
            } else  {
                if(length<tmp.length()) {
                    length=tmp.length();
                }
                tmp=String.valueOf(ss[i]);
            }
        }
        if(tmp.length()==ss.length)    {
            length=ss.length;
        }
        return length;
    }

    public static void main(String[] arg){
        int result = lengthOfLongestSubstring("abcabcdbb");
        System.out.println(result);
    }
}