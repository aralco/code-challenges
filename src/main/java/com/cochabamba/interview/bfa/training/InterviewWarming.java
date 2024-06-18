package com.cochabamba.interview.bfa.training;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals("aabbaa", longestPalin("aabbaa"));
        Assert.assertEquals("aabbaa", longestPalin("aaaabbaa"));
    }

    @Test
    public void testIsPalindrome()  {
        Assert.assertFalse(isPalindrome("ab"));
        Assert.assertTrue(isPalindrome("aabbaa"));
        Assert.assertFalse(isPalindrome("capic"));
        Assert.assertTrue(isPalindrome("aca"));
        Assert.assertFalse(isPalindrome("banana"));
        Assert.assertTrue(isPalindrome("racecar"));
    }
}
