package com.cochabamba.geeksforgeeks;

import java.util.Scanner;

/**
 * @author ariel.alcocer
 */
//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/?track=md-arrays&batchId=144
public class SubArrayWithGivenSum {

    public static void main(String[] args)  {
        //Read input data
        Scanner scanner = new Scanner(System.in);
        int testCasesNumber = scanner.nextInt();
        for(int t=0;t<testCasesNumber;t++)   {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[] array = new int[n];
            //fill array
            for(int i=0;i<n;i++)  {
                array[i] = scanner.nextInt();
            }
            //subArrayGivenSum(n, s, array);
            subArrayGivenSum2(n, s, array);
        }
    }

    //Naive solution O(n^2)
    public static void subArrayGivenSum(int n, int s, int[] array) {
        for(int i=0;i<n;i++)    {
            int sum = 0;
            for(int f=i;f<n;f++)    {
                sum = sum+array[f];
                if(sum==s)  {
                    System.out.println(i+1+" "+(f+1));
                    return;
                }
                if(sum>s)   {
                    break;
                }
            }
        }
        System.out.println("-1");
    }

    //Better solution O(n+m) ?
    public static void subArrayGivenSum2(int n, int s, int[] array) {
        int i = 0;
        int sum = 0;
        for(int f=0;f<n;f++)    {
            sum = sum+array[f];
            while(sum>=s) {
                if(sum==s)  {
                    System.out.println(i+1+" "+(f+1));
                    return;
                }
                sum = sum - array[i];
                i++;
            }
        }
        System.out.println("-1");
    }

    //GFG solution O(n)
    private static void findSubArray(int n, int s, int[] m) {
        int first = 0;
        int last = 0;

        long result = m[first];

        while (result != s) {
            if (result > s) {
                if (first == last) {
                    last++;
                    first++;
                    if (last >= n) break;
                    result = m[first];
                } else {
                    result -= m[first];
                    first++;
                }
            } else {
                last++;
                if (last < n) {
                    result += m[last];
                } else {
                    break;
                }
            }
        }

        if (result != s) {
            System.out.println(-1);
        } else {
            System.out.println((first + 1) + " " + (last + 1));
        }
    }
}
