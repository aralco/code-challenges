package com.cochabamba.interview.bfa.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterviewWarming {
    public static void main(String[] args)   {
    }

    public static boolean isPalindrome(String s)    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }

    public static String longestPalin(String S){
        String maxPal=new String();
        for(int i=0;i<S.length();i++){
            String substr= new String();
            for(int j=i;j<S.length();j++){
                substr += S.charAt(j);
                if(isPalindrome(substr)){
                    if(substr.length()>maxPal.length()){
                        maxPal = substr;
                    }
                }
            }
        }
        return maxPal;
    }

    @Test
    public void testLongestPalindrome() {
        assertEquals("aabbaa", longestPalin("aabbaa"));
        assertEquals("aabbaa", longestPalin("aaaabbaa"));
    }

    @Test
    public void testIsPalindrome()  {
        assertFalse(isPalindrome("ab"));
        assertTrue(isPalindrome("aabbaa"));
        assertFalse(isPalindrome("capic"));
        assertTrue(isPalindrome("aca"));
        assertFalse(isPalindrome("banana"));
        assertTrue(isPalindrome("racecar"));
    }
}
