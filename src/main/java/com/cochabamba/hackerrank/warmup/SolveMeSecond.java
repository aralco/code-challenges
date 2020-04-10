package com.cochabamba.hackerrank.warmup;

import java.util.Scanner;

public class SolveMeSecond {
    static Scanner in = new Scanner(System.in);
    static int sum(int a, int b)    {
        return a+b;
    }

    static void seriesGenerator(int t)  {
        for(int i=0;i<t;i++)    {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(sum(a,b));
        }
    }
    public static void main(String[] args) {
        int t = in.nextInt();
        seriesGenerator(t);
    }
}
