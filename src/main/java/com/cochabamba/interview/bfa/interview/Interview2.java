package com.cochabamba.interview.bfa.interview;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a string s and an integer k, return a list of all unique substrings of length k,
// that also only contain distinct characters. The substrings should be in the same order
// that they appear in S.
//
//        Example:
//        S = aabcbc, k = 2
//        answer = ab, bc, cb

public class Interview2 {
    public List<String> subStrings(String s, int k) {
        List<String> res = new ArrayList<>(); //[]
        if(k<=s.length())	{		//2<6
            for(int i=0;i<s.length()-k;i++)	{	//i=4 <=6
                System.out.println(i);
                String subString = s.substring(i,i+k);	//aa,ab,bc,cb,bc
                if(substringIsUnique(res,subString)&&hasDistinctChars(subString))	{ //false
                    res.add(subString);	//[ab,bc,cb]
                }
            }
        }
        return res;
    }

    //uniqueness should be defined iterate all existing items comparison
    boolean substringIsUnique(List<String> list, String s)	{
//	list.stream().filter(s:s.equals(i))
        Set<String> set = new HashSet<>();
        //for(String item:list)	{
        //	set.add(item);
//}
        set.addAll(list);
        set.add(s);
        return set.size()>list.size();
    }

    private static boolean hasDistinctChars(String subs) {
        Set<Integer> uniq = new HashSet<>();
        return subs.chars().allMatch(uniq::add);
    }

    @Test
    public void testSubStrings()    {
        String[] expectedSubStrings = new String[] {"ab", "bc", "cb"};
        List<String> resultList = subStrings("aabcbc", 2);
        Assertions.assertArrayEquals(expectedSubStrings, resultList.toArray());
    }

    public List<String> betterSubStrings(String s, int k) {
        List<String> res = new ArrayList<>(); //[]
        if(k<=s.length())	{		//2<6
            for(int i=0;i<s.length()-k;i++)	{	//i=4 <=6
                System.out.println(i);
                String subString = s.substring(i,i+k);	//aa,ab,bc,cb,bc
                if(!res.contains(subString)&&hasDistinctChars(subString))	{ //false
                    res.add(subString);	//[ab,bc,cb]
                }
            }
        }
        return res;
    }

    @Test
    public void testBetterSubStrings()    {
        String[] expectedSubStrings = new String[] {"ab", "bc", "cb"};
        List<String> resultList = betterSubStrings("aabcbc", 2);
        Assertions.assertArrayEquals(expectedSubStrings, resultList.toArray());
    }
}
