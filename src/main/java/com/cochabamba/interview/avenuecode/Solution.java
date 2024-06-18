package com.cochabamba.interview.avenuecode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'commonSubstring' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static void commonSubstring(List<String> a, List<String> b) {
        for(int i=0;i<a.size();i++)   {
            System.out.println(a.get(i)+" , "+b.get(i));
            hasCommon(a.get(i), b.get(i));
        }
    }

    private static void hasCommon(String a, String b)   {
        boolean[] frequencyAlpha = new boolean[26];
        Arrays.fill(frequencyAlpha, false);
        boolean hasCommon = false;

        for(int i=0;i<a.length();i++) {
            frequencyAlpha[a.charAt(i)-'a']=true;
        }
        for(int j=0;j<b.length();j++)
            if (frequencyAlpha[b.charAt(j) - 'a']) {
                hasCommon = true;
                break;
            }
        if(hasCommon)   {
            System.out.println("YES");
        } else  {
            System.out.println("NO");
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .collect(toList());
//
//        int bCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> b = IntStream.range(0, bCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .collect(toList());
//
//        Result.commonSubstring(a, b);
//
//        bufferedReader.close();
        List<String> a = Arrays.asList("ab", "cd", "ef");
        List<String> b = Arrays.asList("af", "ee", "ef");
        Result.commonSubstring(a, b);
    }
}

