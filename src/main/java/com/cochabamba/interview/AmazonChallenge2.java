package com.cochabamba.interview;

/**
 * @author ariel.alcocer
 */
public class AmazonChallenge2 {
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int generalizedGCD(int num, int[] arr)  {
        int result = arr[0];
        for (int i = 1; i < num; i++)
            result = gcd(arr[i], result);

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6};
        int n = 5;
        System.out.println(generalizedGCD(n, arr));

        System.out.println(generalizedGCD(5, new int[]{2,4,6,8,10}));

    }
}
