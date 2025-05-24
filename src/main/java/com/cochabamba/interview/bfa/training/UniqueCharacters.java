package com.cochabamba.interview.bfa.training;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueCharacters {
    public static void main(String[] args) {
        assertTrue(hasUniqueCharactersNaiveWithoutDS("abc"));
        assertTrue(hasUniqueCharactersNaiveWithoutDS("abcde"));
        assertTrue(hasUniqueCharactersNaiveWithoutDS("a"));
        assertFalse(hasUniqueCharactersNaiveWithoutDS("aba"));
        assertFalse(hasUniqueCharactersNaiveWithoutDS("abbbba"));
        assertFalse(hasUniqueCharactersNaiveWithoutDS("adckla"));

        assertTrue(hasUniqueCharactersBetterWithDS("abc"));
        assertTrue(hasUniqueCharactersBetterWithDS("abcde"));
        assertTrue(hasUniqueCharactersBetterWithDS("a"));
        assertFalse(hasUniqueCharactersBetterWithDS("aba"));
        assertFalse(hasUniqueCharactersBetterWithDS("abbbba"));
        assertFalse(hasUniqueCharactersBetterWithDS("adckla"));
    }

    @Test
    public void testWithoutDS()   {
        assertTrue(hasUniqueCharactersNaiveWithoutDS("abc"));
        assertTrue(hasUniqueCharactersNaiveWithoutDS("abcde"));
        assertTrue(hasUniqueCharactersNaiveWithoutDS("a"));
        assertFalse(hasUniqueCharactersNaiveWithoutDS("aba"));
        assertFalse(hasUniqueCharactersNaiveWithoutDS("abbbba"));
        assertFalse(hasUniqueCharactersNaiveWithoutDS("adckla"));
    }

    @Test
    public void testWithDS()    {
        assertTrue(hasUniqueCharactersBetterWithDS("abc"));
        assertTrue(hasUniqueCharactersBetterWithDS("abcde"));
        assertTrue(hasUniqueCharactersBetterWithDS("a"));
        assertFalse(hasUniqueCharactersBetterWithDS("aba"));
        assertFalse(hasUniqueCharactersBetterWithDS("abbbba"));
        assertFalse(hasUniqueCharactersBetterWithDS("adckla"));
    }

    @Test
    public void testASCII() {
        assertTrue(hasUniqueCharactersASCII("abc"));
        assertTrue(hasUniqueCharactersASCII("abcde"));
        assertTrue(hasUniqueCharactersASCII("a"));
        assertFalse(hasUniqueCharactersASCII("aba"));
        assertFalse(hasUniqueCharactersASCII("abbbba"));
        assertFalse(hasUniqueCharactersASCII("adckla"));
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
