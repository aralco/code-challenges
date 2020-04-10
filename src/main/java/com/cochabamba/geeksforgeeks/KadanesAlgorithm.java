package com.cochabamba.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
//https://en.wikipedia.org/wiki/Maximum_subarray_problem#CITEREFBrodalJ%C3%B8rgensen2007
//https://youtu.be/86CQq3pKSUw

public class KadanesAlgorithm {
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
            //System.out.println(largestSumSubArray(array));
            System.out.println(kadanes(array));
        }
    }

    //BruteForce: O(n^2)
    static int largestSumSubArray(int[] array)    {
        int totalSum = Integer.MIN_VALUE;
        int partialSum ;
        for(int i=0;i<array.length;i++)    {
            partialSum = 0;
            for(int j=i;j<array.length;j++)    {
                partialSum = partialSum + array[j];
                if(partialSum>totalSum)
                    totalSum = partialSum;
            }
        }
        return totalSum;
    }

    //Kadane's Algorithm: O(n)
    static int kadanes(int[] array)    {
        int totalSum = array[0];
        int partialSum = array[0];
        for(int i=1;i<array.length;i++)    {
            partialSum = Math.max(array[i], partialSum + array[i]);
            totalSum = Math.max(totalSum, partialSum);
        }
        return totalSum;
    }
}
