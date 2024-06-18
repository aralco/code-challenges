package com.cochabamba.interview.bfa.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {
        Assert.assertTrue(hasUniqueCharactersNaiveWithoutDS("abc"));
        Assert.assertTrue(hasUniqueCharactersNaiveWithoutDS("abcde"));
        Assert.assertTrue(hasUniqueCharactersNaiveWithoutDS("a"));
        Assert.assertFalse(hasUniqueCharactersNaiveWithoutDS("aba"));
        Assert.assertFalse(hasUniqueCharactersNaiveWithoutDS("abbbba"));
        Assert.assertFalse(hasUniqueCharactersNaiveWithoutDS("adckla"));

        Assert.assertTrue(hasUniqueCharactersBetterWithDS("abc"));
        Assert.assertTrue(hasUniqueCharactersBetterWithDS("abcde"));
        Assert.assertTrue(hasUniqueCharactersBetterWithDS("a"));
        Assert.assertFalse(hasUniqueCharactersBetterWithDS("aba"));
        Assert.assertFalse(hasUniqueCharactersBetterWithDS("abbbba"));
        Assert.assertFalse(hasUniqueCharactersBetterWithDS("adckla"));
    }

    @Test
    public void testWithoutDS()   {
        Assert.assertTrue(hasUniqueCharactersNaiveWithoutDS("abc"));
        Assert.assertTrue(hasUniqueCharactersNaiveWithoutDS("abcde"));
        Assert.assertTrue(hasUniqueCharactersNaiveWithoutDS("a"));
        Assert.assertFalse(hasUniqueCharactersNaiveWithoutDS("aba"));
        Assert.assertFalse(hasUniqueCharactersNaiveWithoutDS("abbbba"));
        Assert.assertFalse(hasUniqueCharactersNaiveWithoutDS("adckla"));
    }

    @Test
    public void testWithDS()    {
        Assert.assertTrue(hasUniqueCharactersBetterWithDS("abc"));
        Assert.assertTrue(hasUniqueCharactersBetterWithDS("abcde"));
        Assert.assertTrue(hasUniqueCharactersBetterWithDS("a"));
        Assert.assertFalse(hasUniqueCharactersBetterWithDS("aba"));
        Assert.assertFalse(hasUniqueCharactersBetterWithDS("abbbba"));
        Assert.assertFalse(hasUniqueCharactersBetterWithDS("adckla"));
    }

    @Test
    public void testASCII() {
        Assert.assertTrue(hasUniqueCharactersASCII("abc"));
        Assert.assertTrue(hasUniqueCharactersASCII("abcde"));
        Assert.assertTrue(hasUniqueCharactersASCII("a"));
        Assert.assertFalse(hasUniqueCharactersASCII("aba"));
        Assert.assertFalse(hasUniqueCharactersASCII("abbbba"));
        Assert.assertFalse(hasUniqueCharactersASCII("adckla"));
    }

    public static boolean hasUniqueCharactersASCII(String string)  {
        boolean[] ascii = new boolean[128];
        for (char c:string.toCharArray()) {
            System.out.println("character:"+c+", ascii:"+ascii[c]);
            if(ascii[c])    {
                return false;
            }
            ascii[c]=true;
        }
        return true;
    }

    public static boolean hasUniqueCharactersBetterWithDS(String string)  {
        Set<Character> set = new HashSet<>();
        for (char c:string.toCharArray()) {
            set.add(c);
        }
        return (set.size()==string.length());
    }

    public static boolean hasUniqueCharactersNaiveWithoutDS(String string)  {
        if(string.length()>1)   {
            for(int i=string.length()-1;i>0;i--) {
                for(int j=i-1;j>=0;j--)    {
                    if(string.charAt(i)==string.charAt(j))   {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
