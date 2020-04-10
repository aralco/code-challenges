package com.cochabamba.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
//https://en.wikipedia.org/wiki/Longest_increasing_subsequence


public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for(int k=1;k<=t;k++)   {
            int n = Integer.parseInt(bufferedReader.readLine());
            String  input = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int[] array = new int[n];
            for(int i=0;i<n;i++)    {
                array[i] = Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(lis(array, array.length));
        }
    }

    //L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
    //L(i) = 1, if no such j exists.
    //max(L(i)) where 0 < i < n.
    static int lis(int[] array, int n) {
        int[] lis = new int[n];
        int max = 0;

        /* Initialize LIS values for all indexes */
        for(int i=0;i<n;i++)
            lis[i] = 1;

           /* Compute optimized LIS values in bottom up manner */
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++)
                if(array[i] > array[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

           /* Pick maximum of all LIS values */
        for(int i=0;i<n;i++) {
            if(lis[i] > max)
                max = lis[i];
        }
        return max;
    }

}
//10 22 9 33 21 50 41 60 80
//0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15