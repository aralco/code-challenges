package com.cochabamba.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
//https://practice.geeksforgeeks.org/problems/maximum-sub-array/0

public class MaximumSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String input = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(tokenizer.nextToken());
            }
            int[] maximumSubArray = maximumSumSubArray(array);
            StringBuilder response = new StringBuilder();
            for (int i : maximumSubArray) {
                response.append(i).append(" ");
            }
            System.out.println(response);

        }
    }

    //BruteForce: O(n^2)
    static int[] maximumSumSubArray(int[] array) {
        int start = 0;
        int end = 0;
        int totalSum = Integer.MIN_VALUE;
        int partialSum;
        for (int i = 0; i < array.length; i++) {
            partialSum = 0;
            for (int j = i; j < array.length; j++) {
                if(array[j]>=0)  {
                    partialSum = partialSum + array[j];
                    if (partialSum >= totalSum) {
                        totalSum = partialSum;
                        start = i;
                        end = j;
                    }
                } else
                    break;
            }
        }
        return Arrays.copyOfRange(array, start, end + 1);
    }

    //TODO Divide and Conquer: O(nLog(n))
    static int[] maximumSumSubArrayDC(int[] array) {
        int start = 0;
        int end = 0;
        int totalSum = Integer.MIN_VALUE;
        int partialSum;
        for (int i = 0; i < array.length; i++) {
            partialSum = 0;
            for (int j = i; j < array.length; j++) {
                if(array[j]>=0)  {
                    partialSum = partialSum + array[j];
                    if (partialSum >= totalSum) {
                        totalSum = partialSum;
                        start = i;
                        end = j;
                    }
                } else
                    break;
            }
        }
        return Arrays.copyOfRange(array, start, end + 1);
    }

    //TODO only for positive numbers Kadane's Algorithm: O(n) keeping track of start and end of sub-array
    //Kadane's Algorithm: O(n) keeping track of start and end of sub-array
    static int[] kadanes(int[] array)    {
        int start = 0;
        int end = 0;
        int pos = 0;
        int totalSum = Integer.MIN_VALUE;
        int partialSum = array[0];
        for(int i=0;i<array.length;i++)    {

                partialSum = partialSum + array[i];
                if(partialSum < 0) {
                    partialSum = 0;
                    pos = i + 1;
                }
                if(partialSum>=totalSum)    {
                    totalSum = partialSum;
                    start = pos;
                    end = i;
                }
        }
        return Arrays.copyOfRange(array, start, end + 1);
    }

}
