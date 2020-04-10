package com.cochabamba.hackerrank.random;

import java.math.BigInteger;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/fibonacci-finding-easy/problem
public class FibonacciFinding {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int a,b, n;
        for(int i=1;i<=t;i++)    {
            a = scanner.nextInt();
            b = scanner.nextInt();
            n = scanner.nextInt();
//            System.out.println(fibonacci(a, b, n));
            System.out.println(fibonacciNonRecursive(a, b, n));
        }
    }

    //better solution O(n)=n
    static BigInteger fibonacciNonRecursive(int a, int b, int n)   {
        BigInteger fib0 = new BigInteger(String.valueOf(a));
        BigInteger fib1 = new BigInteger(String.valueOf(b));
        BigInteger fibN = BigInteger.ZERO;
        if(n==0)
            fibN=fib0;
        if(n==1)
            fibN = fib1;
        for(int i=2;i<=n;i++)   {
            fibN = fib0.add(fib1);
            fib0 = fib1;
            fib1 = fibN;
        }
        return fibN;
    }

    //naive solution O(n)=e^n
    static int fibonacci(int a, int b, int n)   {
        if(n==0)
            return a;
        if(n==1)
            return b;
        return fibonacci(a, b, n-1) + fibonacci(a, b, n-2);
    }
}
//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//https://www.geeksforgeeks.org/large-fibonacci-numbers-java/

//https://www.hackerrank.com/challenges/fibonacci-finding-easy/problem
//https://www.hackerrank.com/challenges/fibonacci-finding-easy/forum
//https://en.wikipedia.org/wiki/Fibonacci_number#Matrix_form
//https://kukuruku.co/post/the-nth-fibonacci-number-in-olog-n/
//http://tech-queries.blogspot.com/2010/09/nth-fibbonacci-number-in-ologn.html
//http://tech-queries.blogspot.com/2009/04/amazon-interview.html
//https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-multiplication
//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//https://github.com/aralco/hackerrank/blob/master/fibonacci-finding-easy/Solution.java
//https://www.youtube.com/watch?v=3jWPmxEJUP0
