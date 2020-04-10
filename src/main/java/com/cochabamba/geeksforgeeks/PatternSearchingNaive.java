package com.cochabamba.geeksforgeeks;

import java.util.LinkedList;

public class PatternSearchingNaive {
    public static void main(String[] args)  {
//        String text = "THIS IS A TEST TEXT";
//        String pattern = "TEST";
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
//        String text = "AAAAAAAAAAAAAAAAAB";
//        String pattern = "AAAAB";
        naiveSearch1(text, pattern);
        naiveSearch2(text, pattern);
    }

    static void naiveSearch1(String text, String pattern) {
        LinkedList<Integer> indexes = new LinkedList<>();
        int match;
        int k;
        for(int i=0;i<text.length();i++)    {
            match = 0;
            k = 0;
            for(int j=i;j<text.length();j++)    {
                if(k<pattern.length() && pattern.charAt(k)==text.charAt(j))   {
                    match++;
                    k++;
                    if(match==pattern.length()) {
                        indexes.add(j-match+1);
                        break;
                    }
                } else  {
                    break;
                }
            }
        }
        while(!indexes.isEmpty())   {
            System.out.println("Pattern found at index "+indexes.poll());
        }
    }

    static void naiveSearch2(String text, String pattern) {
        for(int i=0;i<=text.length()-pattern.length();i++)    {
            int j;
            for(j=0;j<pattern.length();j++)    {
                if(pattern.charAt(j)!=text.charAt(i+j))
                    break;
            }
            if(j==pattern.length())
                System.out.println("Pattern found at index "+(i));
        }
    }

}
