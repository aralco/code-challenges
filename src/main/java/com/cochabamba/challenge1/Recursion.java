package com.cochabamba.challenge1;

import java.util.Scanner;

/**
 * @author aralco
 * Day 9: Recursion
 */

public class Recursion {
    public static int factorial(int n)  {
        if(n<=1)    {
            return  1;
        } else  {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));
    }
}
